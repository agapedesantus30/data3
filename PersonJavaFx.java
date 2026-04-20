import java.io.Serializable;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Class: PersonJavaFx
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: February 2, 2018
 * 
 * 
 *          This class � This class describes PersonJavaFx used to contain the
 *          GridPane. It also contains the main method which starts the program.
 * 
 *          Purpose: Methods and attributes needed to create a GridPane of
 *          PersonJavaFx class. Ask users to enter FirstName, LastName, Id and
 *          city.
 *
 */
public class PersonJavaFx extends Application implements Serializable {
	public String firstName;
	public String lastName;
	public int id;
	public String city;

	/**
	 * Default constructor used to create empty attributes
	 */
	public PersonJavaFx() {
		firstName = "";
		lastName = "";
		id = 0;
		city = "";
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param idNum
	 * @param city
	 */
	public PersonJavaFx(String firstName, String lastName, int idNum, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = idNum;
		this.city = city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", idNum=" + id + ", city=" + city + "]";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the idNum
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param idNum
	 *            the idNum to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);

		// Place nodes in the pane
		pane.add(new Label("First Name:"), 0, 0);
		pane.add(new TextField(), 1, 0);
		pane.add(new Label("Last Name:"), 0, 1);
		pane.add(new TextField(), 1, 1);
		pane.add(new Label("Id"), 0, 2);
		pane.add(new TextField(), 1, 2);
		pane.add(new Label("City"), 0, 3);
		pane.add(new TextField(), 1, 3);
		Button btSave = new Button("Save");
		pane.add(btSave, 1, 4);
		GridPane.setHalignment(btSave, HPos.RIGHT);
		Button btCancel = new Button("Cancel");
		pane.add(btCancel, 1, 5);
		GridPane.setHalignment(btCancel, HPos.RIGHT);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowPersonJavaFx"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}