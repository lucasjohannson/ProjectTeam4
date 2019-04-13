
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;

public class GameMenu extends Application {

	private MapGUI mapGUI = new MapGUI();

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("ANIMATION GAME");
		primaryStage.setScene(mainMenu(primaryStage));
		primaryStage.show();
	}

	public Scene mainMenu(Stage aStage) {
		Pane root = new Pane();

		root.setPrefSize(1050, 600);

		try (InputStream is = Files.newInputStream(Paths.get("galaxy.png"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			root.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}

		Title title = new Title("ANIMATED MAZE GAME");
		title.setTranslateX(215);
		title.setTranslateY(240);

		MenuItem play = new MenuItem("PLAY");
		MenuItem load = new MenuItem("LOAD MAP");
		MenuItem exit = new MenuItem("EXIT");
		play.setOnMouseClicked(e -> aStage.setScene(mapGUI.getMapScreen(aStage)));
		load.setOnMouseClicked(e -> aStage.setScene(getMapPrompt(aStage)));
		exit.setOnMouseClicked(e -> aStage.close());

		MenuBox vbox = new MenuBox(play, load, exit);
		vbox.setTranslateX(390);
		vbox.setTranslateY(320);

		root.getChildren().addAll(title, vbox);
		Scene mainMenu = new Scene(root);
		return mainMenu;
	}

	public Scene getIniPrompt(Stage aStage) {
		Popup iniPrompt = new Popup("Enter name of initialization file:");
		iniPrompt.getButton1().setOnAction(e -> {
			try {
				mapGUI.logic.getGameData().setInitialization(iniPrompt.getTextField().getCharacters().toString());
				mapGUI.logic.getGameData().initializeMap(mapGUI.logic.map);
				mapGUI.logic.getGameData().initializePlayer(mapGUI.logic.player);
				mapGUI.drawInitialization(mapGUI.logic.map.getGrid(), mapGUI.canvas);
				aStage.setScene(mapGUI.getMapScreen(aStage));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		});
		iniPrompt.getButton2().setOnAction(e -> aStage.setScene(mainMenu(aStage)));
		Scene loadIni = new Scene(iniPrompt, 360, 90, Color.LIGHTGREY);
		return loadIni;
	}

	public Scene getMapPrompt(Stage aStage) {
		Popup mapPrompt = new Popup("Enter map name:");
		mapPrompt.getButton1().setOnAction(e -> {
			try {
				mapGUI.logic.map.setGrid(mapPrompt.getTextField().getCharacters().toString());
				mapGUI.drawMap(mapGUI.logic.map.getOriginalGrid(), mapGUI.canvas);
				aStage.setScene(getIniPrompt(aStage));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		mapPrompt.getButton2().setOnAction(e -> aStage.setScene(mainMenu(aStage)));
		Scene loadMap = new Scene(mapPrompt, 280, 90, Color.LIGHTGREY);
		return loadMap;
	}

	private static class Title extends StackPane {
		public Title(String name) {

			Text text = new Text(name);
			text.setFill(Color.BLACK);
			text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));

			setAlignment(Pos.CENTER);
			getChildren().addAll(text);
		}
	}

	private static class MenuBox extends VBox {
		public MenuBox(MenuItem... items) {
			getChildren().add(createSeperator());

			for (MenuItem item : items) {
				getChildren().addAll(item, createSeperator());
			}
		}

		private Line createSeperator() {
			Line sep = new Line();
			sep.setEndX(210);
			sep.setStroke(Color.WHITE);
			return sep;
		}
	}

	private static class MenuItem extends StackPane {
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.DARKBLUE), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.DARKBLUE)

					});

			Rectangle bg = new Rectangle(200, 30);
			bg.setOpacity(0.4);

			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.BLACK);

			});

			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});
			setOnMousePressed(event -> {
				bg.setFill(Color.DARKVIOLET);

			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});

		}
	}

	public static void main(String[] args) {

		launch(args);
	}
}
