
import java.io.FileNotFoundException;
import java.io.IOException;


import java.io.InputStream;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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

	public class GameMenu extends Application{	
		
		private GameLogic logic = new GameLogic();
		Image grassTile = new Image("file:grass.png", 64, 64, true, false);
		Image lavaTile = new Image("file:lava.png", 64, 64, true, false);
		Image wallTile = new Image("file:wall.png", 64, 64, true, false);
		Image waterTile = new Image("file:water.png", 64, 64, true, false);
		Image chest = new Image("file:chest.png", 64, 64, true, false);
		Image playerChar = new Image("file:playerChar.png", 64, 64, true, false);
		Image enemyChar = new Image("file:enemyChar.png", 64, 64, true, false);
		Image portal = new Image("file:portal.png", 64, 64, true, false);
		
		public void start(Stage primaryStage) throws Exception{
			Pane root = new Pane();
			
			root.setPrefSize(1050, 600);
			
			try(InputStream is = Files.newInputStream(Paths.get("galaxy.png"))){
				ImageView img = new ImageView(new Image(is));
				img.setFitWidth(1050);
				img.setFitHeight(600);
				root.getChildren().add(img);
			}
			catch(IOException e) {
				System.out.println("Couldn't load image");
			}
			
			Title title = new Title ("ANIMATED MAZE GAME");
			title.setTranslateX(215);
			title.setTranslateY(240);
			
			MenuItem play = new MenuItem("PLAY");
			MenuItem load = new MenuItem("LOAD MAP");
			MenuItem exit = new MenuItem("EXIT");
			
			MenuBox vbox = new MenuBox(play, load, exit);
			vbox.setTranslateX(390);
			vbox.setTranslateY(320);
			
			root.getChildren().addAll(title,vbox);
			
			Scene scene = new Scene(root);
			primaryStage.setTitle("ANIMATION GAME");
			primaryStage.setScene(scene);
			
			VBox popup2 = new VBox(10);
			popup2.setPadding(new Insets(10));
			HBox innerBox3 = new HBox(5);
			HBox innerBox4 = new HBox(5);
			Label l4 = new Label("Enter name of initialization file:");
			TextField tf2 = new TextField();
			innerBox3.setAlignment(Pos.CENTER);
			innerBox4.setAlignment(Pos.CENTER);
			Button b3 = new Button("Ok");
			Button b4 = new Button("Cancel");
			b4.setOnAction(e -> primaryStage.setScene(scene));
			popup2.getChildren().add(innerBox3);
			popup2.getChildren().add(innerBox4);
			innerBox3.getChildren().add(l4);
			innerBox3.getChildren().add(tf2);
			innerBox4.getChildren().add(b3);
			innerBox4.getChildren().add(b4);
			
			popup2.setAlignment(Pos.CENTER);
			Scene loadIni = new Scene(popup2, 400, 100, Color.LIGHTGREY);
			
			VBox mainGUI = new VBox();
			final Canvas canvas = new Canvas();
			logic.map.setGrid("map1.txt");
			drawMap(logic.map.getBaseGrid(), canvas);
			Scene gameDisplay = new Scene(mainGUI, mainGUI.getPrefHeight(), mainGUI.getPrefWidth());
			mainGUI.getChildren().add(canvas);
			
			VBox rootPopup = new VBox(10);
			rootPopup.setPadding(new Insets(10));
			HBox innerBox1 = new HBox(5);
			Label l3 = new Label("Enter map name:");
			TextField tf1 = new TextField();
			innerBox1.setAlignment(Pos.CENTER);
			HBox innerBox2 = new HBox(5);
			Button b1 = new Button("Ok");
			
			b1.setOnAction(e -> {
				try {
					logic.map.setGrid(tf1.getCharacters().toString());
					drawMap(logic.map.getBaseGrid(), canvas);
					primaryStage.setScene(loadIni);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}	
			});
			
			Button b2 = new Button("Cancel");
			b2.setOnAction(e -> primaryStage.setScene(scene));
			
			b3.setOnAction(e -> {
				try {
					logic.getGameData().setInitialization(tf2.getCharacters().toString());
					logic.getGameData().initializeMap(logic.map);
					logic.getGameData().initializePlayer(logic.player);
					drawInitialization(logic.map.getGrid(), canvas);
					primaryStage.setScene(gameDisplay);
				}
				catch(FileNotFoundException e2) {
					e2.printStackTrace();
				}
			});
			
			innerBox2.setAlignment(Pos.CENTER);
			rootPopup.getChildren().add(innerBox1);
			rootPopup.getChildren().add(innerBox2);
			innerBox1.getChildren().add(l3);
			innerBox1.getChildren().add(tf1);
			innerBox2.getChildren().add(b1);
			innerBox2.getChildren().add(b2);
			rootPopup.setAlignment(Pos.CENTER);
			Scene loadMap = new Scene(rootPopup, 300, 100, Color.LIGHTGREY);
			
			load.setOnMouseClicked(e -> primaryStage.setScene(loadMap));
			play.setOnMouseClicked(e -> primaryStage.setScene(gameDisplay));
			exit.setOnMouseClicked(e -> primaryStage.close());
			
			primaryStage.show();
		}
		
		private static class Title extends StackPane{
			public Title(String name) {
				
				Text text = new Text(name);
				text.setFill(Color.BLACK);
				text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));
				
				setAlignment(Pos.CENTER);
				getChildren().addAll(text);
			}
		}
		
		private static class MenuBox extends VBox{
			public MenuBox(MenuItem...items) {
				getChildren().add(createSeperator());
				
				for(MenuItem item : items) {
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
		

		private static class MenuItem extends StackPane{
			public MenuItem(String name) {
				LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] { 
					new Stop(0, Color.DARKBLUE),
					new Stop(0.1, Color.BLACK),
					new Stop(0.9, Color.BLACK),
					new Stop(1, Color.DARKBLUE)
					
				});
				
				Rectangle bg = new Rectangle(200,30);
				bg.setOpacity(0.4);
				
				Text text = new Text(name);
				text.setFill(Color.WHITE);
				text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
				
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
	
			public void drawMap(char[][] aGrid, Canvas canvas) {
				canvas.setHeight(aGrid.length * 64);
				canvas.setWidth(aGrid[0].length * 64);
				GraphicsContext gc = canvas.getGraphicsContext2D();
				for(int i = 0; i < aGrid.length; i++) {
					for (int j = 0; j < aGrid[0].length; j++) {
						switch(aGrid[i][j]) {
						case '.':
							gc.drawImage(grassTile, j*64, i*64);
							break;
						case '~':
							gc.drawImage(waterTile, j*64, i*64);
							break;
						case '#':
							gc.drawImage(wallTile, j*64, i*64);
							break;
						case '^':
							gc.drawImage(lavaTile, j*64, i*64);
							break;
						default:
							gc.drawImage(grassTile, j*64, i*64);
						}
					}
				}
			}
		
			public void drawInitialization(char[][] aGrid, Canvas canvas) {
				GraphicsContext gc = canvas.getGraphicsContext2D();
				for(int i = 0; i < aGrid.length; i++) {
					for (int j = 0; j < aGrid[0].length; j++) {
						switch(aGrid[i][j]) {
						case 'E':
							gc.drawImage(enemyChar, j*64, i*64);
							break;
						case 'o':
							gc.drawImage(chest, j*64, i*64);
							break;
						case 'P':
							gc.drawImage(playerChar, j*64, i*64);
							break;
						case'@':
							gc.drawImage(portal, j*64, i*64);
						default:
							;
						}
					}
				}
			}
			
		public static void main(String[] args) {
			
			launch(args);
		}
	}

