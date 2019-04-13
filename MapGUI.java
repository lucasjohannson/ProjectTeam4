import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MapGUI {
	
	protected GameLogic logic = new GameLogic();
	//all images below from opengameart.org
	Image grassTile = new Image("file:grass.png", 64, 64, true, false);
	Image lavaTile = new Image("file:lava.png", 64, 64, true, false);
	Image wallTile = new Image("file:wall.png", 64, 64, true, false);
	Image waterTile = new Image("file:water.png", 64, 64, true, false);
	Image chest = new Image("file:chest.png", 64, 64, true, false);
	Image playerChar = new Image("file:playerChar.png", 64, 64, true, false);
	Image enemyChar = new Image("file:enemyChar.png", 64, 64, true, false);
	Image portal = new Image("file:portal.png", 64, 64, true, false);
	Canvas canvas = new Canvas();

	public void drawMap(char[][] aGrid, Canvas canvas) {
		canvas.setHeight(aGrid.length * 64);
		canvas.setWidth(aGrid[0].length * 64);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		for (int i = 0; i < aGrid.length; i++) {
			for (int j = 0; j < aGrid[0].length; j++) {
				switch (aGrid[i][j]) {
				case '.':
					gc.drawImage(grassTile, j * 64, i * 64);
					break;
				case '~':
					gc.drawImage(waterTile, j * 64, i * 64);
					break;
				case '#':
					gc.drawImage(wallTile, j * 64, i * 64);
					break;
				case '^':
					gc.drawImage(lavaTile, j * 64, i * 64);
					break;
				default:
					gc.drawImage(grassTile, j * 64, i * 64);
				}
			}
		}
	}

	public void drawInitialization(char[][] aGrid, Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		for (int i = 0; i < aGrid.length; i++) {
			for (int j = 0; j < aGrid[0].length; j++) {
				switch (aGrid[i][j]) {
				case 'E':
					gc.drawImage(enemyChar, j * 64, i * 64);
					break;
				case 'o':
					gc.drawImage(chest, j * 64, i * 64);
					break;
				case 'P':
					gc.drawImage(playerChar, j * 64, i * 64);
					break;
				case '@':
					gc.drawImage(portal, j * 64, i * 64);
				default:
					;
				}
			}
		}
	}

	public void drawTile(Location aLocation, Canvas canvas, Image image) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, aLocation.getX() * 64, aLocation.getY() * 64);
	}

	public void drawOriginalTile(Location aLocation, Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image img = new Image("file:grass.png", 64, 64, true, false);

		switch (logic.getMap().getOriginalGrid()[aLocation.getY()][aLocation.getX()]) {

		case '~':
			img = waterTile;
		case '^':
			img = lavaTile;
		default:
			img = grassTile;
		}

		gc.drawImage(img, aLocation.getX() * 64, aLocation.getY() * 64);
	}

	public void move(KeyCode key, Canvas canvas) {

		Location playerLocation = logic.player.getLocation();

		switch (key) {
		case UP:
			if (logic.map.isValidMove(logic.player, playerLocation, Direction.NORTH)) {
				drawTile(playerLocation.getNorth(), canvas, playerChar);
				drawOriginalTile(playerLocation, canvas);
				logic.moveNorth();
			}
			break;
		case DOWN:
			if (logic.map.isValidMove(logic.player, playerLocation, Direction.SOUTH)) {
				drawTile(playerLocation.getSouth(), canvas, playerChar);
				drawOriginalTile(playerLocation, canvas);
				logic.moveSouth();
			}
			break;
		case RIGHT:
			if (logic.map.isValidMove(logic.player, playerLocation, Direction.EAST)) {
				drawTile(playerLocation.getEast(), canvas, playerChar);
				drawOriginalTile(playerLocation, canvas);
				logic.moveEast();
			}
			break;
		case LEFT:
			if (logic.map.isValidMove(logic.player, playerLocation, Direction.WEST)) {
				drawTile(playerLocation.getWest(), canvas, playerChar);
				drawOriginalTile(playerLocation, canvas);
				logic.moveWest();
			}
			break;
		default:
			;
		}
	}

	public void checkEvent(Location aLocation, Stage aStage) {
		if (logic.checkCompletion()) {
			aStage.setScene(getEndscreen(aStage));
		}
		if (logic.checkEnemy(aLocation)) {
			Enemy toBattle = logic.getEnemy(logic.player.getLocation());
			// aStage.setScene(BattleGUI(logic.player, toBattle));
			drawOriginalTile(toBattle.getLocation(), canvas);
			drawTile(logic.player.getLocation(), canvas, playerChar);
		}
		if (logic.checkItem(aLocation)) {

		}

	}

	public Scene getMapScreen(Stage aStage) {
		VBox mainGUI = new VBox();
		Scene gameDisplay = new Scene(mainGUI, mainGUI.getPrefHeight(), mainGUI.getPrefWidth());
		mainGUI.getChildren().add(canvas);
		gameDisplay.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case LEFT:
					move(KeyCode.LEFT, canvas);
					checkEvent(logic.player.getLocation(), aStage);
					break;
				case UP:
					move(KeyCode.UP, canvas);
					checkEvent(logic.player.getLocation(), aStage);
					break;
				case RIGHT:
					move(KeyCode.RIGHT, canvas);
					checkEvent(logic.player.getLocation(), aStage);
					break;
				case DOWN:
					move(KeyCode.DOWN, canvas);
					checkEvent(logic.player.getLocation(), aStage);
					break;
				case ESCAPE:
					//aStage.setScene(new GameMenu .mainMenu(aStage));
					break;
				case I:
					// primaryStage.setScene(inventory);
					break;
				default:
				}
			}
		});
		return gameDisplay;
	}

	public Scene getEndscreen(Stage aStage) {
		Pane root = new Pane();

		root.setPrefSize(1050, 600);

		try (InputStream is = Files.newInputStream(Paths.get("win.jpg"))) {
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			root.getChildren().add(img);
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}
		Scene endScreen = new Scene(root);
		// endScreen.setOnKeyPressed(e -> aStage.setScene(getMainMenu()));
		return endScreen;
	}
}
