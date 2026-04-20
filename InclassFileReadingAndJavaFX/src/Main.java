import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class: Main
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 8, 2018
 * 
 * 
 *          This class describes Main used to contain the stages of different
 *          person panes. It also contains the main method which starts the
 *          program.
 * 
 *          Purpose: Methods and attributes needed to create a Main of
 *          GeneratePeopleFile class. Display a particular id and add a new item
 *          to a stage.
 *
 */
public class Main extends Application {
	private GeneratePeopleFile myPeople = new GeneratePeopleFile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// read in file and create library
		myPeople.readBinaryFile();

		// display list of library items
		VBox mainPane = new VBox();
		Label mainLabel = new Label("Library Items");

		mainPane.getChildren().add(mainLabel);
		ListView<Person> list = new ListView<Person>();
		ObservableList<Person> items = FXCollections.observableArrayList(myPeople.getTheList());
		list.setItems(items);

		mainPane.getChildren().add(list);

		// make list selectable and popup info on selected item in a separate
		// stage
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

			public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
				// pop up detail stage of selected media object
				Stage newStage = null;
				if (newValue.getType().equals("Employee")) {
					newStage = createEmployeeStage(newValue);
				} else {
					newStage = createStudentStage(newValue);
				}

				newStage.show();
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(mainPane, 500, 200);
		primaryStage.setTitle("Group of People"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	/*
	 * Method to create new Stage for a Employee of person item
	 * 
	 * @param Person
	 * 
	 * @return Stage
	 */
	private Stage createEmployeeStage(Person m) {
		Stage s = new Stage();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		Employee e = (Employee) m;
		// Place nodes in the pane
		pane.add(new Label("FullName:"), 0, 0);
		pane.add(new Label(e.getFullName()), 1, 0);
		pane.add(new Label("Type:"), 0, 1);
		pane.add(new Label(e.getType()), 1, 1);
		pane.add(new Label("ID:"), 0, 2);
		pane.add(new Label("" + e.getId()), 1, 2);
		pane.add(new Label("Salary"), 0, 3);
		pane.add(new Label("" + e.getSalary()), 1, 3);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.setTitle("Employee");
		return s;
	}

	/*
	 * Method to create new Stage for a Student of Person item
	 * 
	 * @param Person
	 * 
	 * @return Stage
	 */
	private Stage createStudentStage(Person m) {

		Stage s = new Stage();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		Student stu = (Student) m;
		// Place nodes in the pane
		pane.add(new Label("FullName:"), 0, 0);
		pane.add(new Label(stu.getFullName()), 1, 0);
		pane.add(new Label("Type:"), 0, 1);
		pane.add(new Label(stu.getType()), 1, 1);
		pane.add(new Label("ID:"), 0, 2);
		pane.add(new Label("" + stu.getId()), 1, 2);
		pane.add(new Label("GPA"), 0, 3);
		pane.add(new Label("" + stu.getGpa()), 1, 3);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.setTitle("Student");
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
