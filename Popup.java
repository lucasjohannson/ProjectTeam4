import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A class that formats a VBox with a textfield and 2 buttons
 */
public class Popup extends VBox{
	
	Button b1 = new Button("Ok");
	Button b2 = new Button("Cancel");
	TextField tf1 = new TextField();
	
	public Popup(String labelString) {
		setSpacing(10);
		HBox innerBox1 = new HBox(5);
		Label l1 = new Label(labelString);
		innerBox1.setAlignment(Pos.CENTER);
		HBox innerBox2 = new HBox(5);
		innerBox2.setAlignment(Pos.CENTER);
		getChildren().add(innerBox1);
		getChildren().add(innerBox2);
		innerBox1.getChildren().add(l1);
		innerBox1.getChildren().add(tf1);
		innerBox2.getChildren().add(b1);
		innerBox2.getChildren().add(b2);
		setAlignment(Pos.CENTER);
	}
	
	/**
	 * Gets the first button
	 * @return b1, the first button
	 */
	public Button getButton1() {
		return b1;
	}
	
	/**
	 * Gets the second button
	 * @return b2, the second button
	 */
	public Button getButton2() {
		return b2;
	}
	
	/**
	 * Gets the textfield
	 * @return the textfield contained in the popup
	 */
	public TextField getTextField() {
		return tf1;
	}
}
