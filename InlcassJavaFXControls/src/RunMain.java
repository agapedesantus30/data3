import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 * Class: RunMain
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: February 10, 2018
 * 
 * 
 *          This class � This class describes RunMain used to contain the
 *          BorderPane. It also contains the main method which starts the program.
 * 
 *          Purpose: Methods and attributes needed to create a BorderPane of
 *          class RunMain. Ask users to select a check box of colors Pink, 
 *          Orange, Yellow, Purple, Red, Green, and Blue.
 *
 */
public class RunMain extends Italics {
	@Override // Override the getPane() method in the super class
	protected BorderPane getPane() {
		BorderPane pane = super.getPane();

		VBox paneForRadioButtons = new VBox(20);
		paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
		paneForRadioButtons.setStyle("-fx-border-color: brown");
		paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: brown");
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbPink = new RadioButton("Pink");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbPurple = new RadioButton("Purple");
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlue = new RadioButton("Blue");
		paneForRadioButtons.getChildren().addAll(rbPink, rbOrange, rbYellow, rbPurple, rbRed, rbGreen, rbBlue);
		pane.setLeft(paneForRadioButtons);

		ToggleGroup group = new ToggleGroup();
		rbPink.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbPurple.setToggleGroup(group);
		rbRed.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		rbBlue.setToggleGroup(group);

		rbPink.setOnAction(e -> {
			if (rbPink.isSelected()) {
				text.setFill(Color.PINK);
			}
		});

		rbOrange.setOnAction(e -> {
			if (rbOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});

		rbYellow.setOnAction(e -> {
			if (rbYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});

		rbPurple.setOnAction(e -> {
			if (rbPurple.isSelected()) {
				text.setFill(Color.PURPLE);
			}
		});

		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});

		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});

		rbBlue.setOnAction(e -> {
			if (rbBlue.isSelected()) {
				text.setFill(Color.BLUE);
			}
		});

		return pane;
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
