package logic;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import handlers.Back;
import handlers.Sword;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryScene extends Application {
	
//private Button swordBtn;
//private Button potionBtn;
//private Button bootsBtn;
//private Button keyBtn;
//private Button fillerBtn1;
//private Button fillerBtn2;
//private Button backToGame;

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("ANIMATED MAZE GAME");
		Label label = new Label("Select the item you want to use");
		Button swordBtn = new Button("Sword");
		Button potionBtn = new Button("Potion");
		Button bootsBtn = new Button("Boots");
		Button keyBtn = new Button("Key");
		Button fillerBtn1 = new Button("filler");
		Button fillerBtn2 = new Button("filler2");
		Button backBtn = new Button("Back");
		
		
		swordBtn.setPrefWidth(233);
		swordBtn.setPrefHeight(200);
		potionBtn.setPrefWidth(233);
		potionBtn.setPrefHeight(200);
		keyBtn.setPrefWidth(233);
		keyBtn.setPrefHeight(200);
		bootsBtn.setPrefWidth(233);
		bootsBtn.setPrefHeight(200);
		fillerBtn1.setPrefHeight(200);
		fillerBtn1.setPrefWidth(233);
		fillerBtn2.setPrefHeight(200);
		fillerBtn2.setPrefWidth(233);
		
		
		
		VBox verticalBox = new VBox();
		verticalBox.setSpacing(40);
		
		HBox row1 = new HBox();
		row1.setSpacing(40);
		
		HBox row2 = new HBox();
		row2.setSpacing(40);
		
		VBox verticalBox2 = new VBox();
		verticalBox2 = new VBox();
		verticalBox2.getChildren().add(backBtn);
		
		
		
		row1.getChildren().add(swordBtn);
		row1.getChildren().add(potionBtn);
		row1.getChildren().add(fillerBtn1);
		row2.getChildren().add(bootsBtn);
		row2.getChildren().add(keyBtn);
		row2.getChildren().add(fillerBtn2);
		
		//verticalBox.getChildren().add(backBtn);
		
		verticalBox.getChildren().add(row1);
		verticalBox.getChildren().add(row2);
		verticalBox.getChildren().add(label);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(verticalBox);
		layout.getChildren().add(verticalBox2);
		
		
		Scene scene = new Scene(layout,1050, 600);
		stage.setScene(scene);
		stage.show();
		verticalBox.setAlignment(Pos.CENTER);
		row1.setAlignment(Pos.CENTER);
		row2.setAlignment(Pos.CENTER);
		verticalBox2.setAlignment(Pos.TOP_RIGHT);
		
		try(InputStream is = Files.newInputStream(Paths.get("galaxy.png"))){
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			layout.getChildren().add(img);
		}
		catch(IOException e) {
			System.out.println("Couldn't load image");
		}
		
		//space bar to use the buttons  
		Back backHandler = new Back();
		backBtn.setOnAction(backHandler);
		
		Sword swordHandler = new Sword();
		swordBtn.setOnAction(swordHandler);
		
//		Potion potionHandler = new Potion();
//		potionBtn.setOnAction(potionHandler);
	}	                             
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
