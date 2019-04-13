


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class alert extends Application {
	Stage inventoryPopUp;
	
	
	public void start(Stage stage) throws Exception {
		stage = inventoryPopUp;
		VBox box = new VBox(10);
		Button btn = new Button("Inventory update!");
		Button btn2 = new Button("Back to game");
		box.setAlignment(Pos.CENTER);
		
		btn.setOnAction(e -> {
			
		Alert popUp = new Alert(Alert.AlertType.INFORMATION);
		popUp.setTitle("ADVENTURE GAME");
		popUp.setContentText("You Have Used An Item!");
		popUp.setHeaderText(null);
		popUp.show();
		});
	
		box.getChildren().add(btn);
		Scene scene = new Scene(box,300,300);
		
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}



	
}

