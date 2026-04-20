import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * Main GUI class - contains ListView and launches additional Stages as needed
 * 
 * @author cjohns25
 *
 */
public class MainInterface extends Application
{
	private Library myLibrary = new Library();

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		// read in file and create library
		myLibrary.readBinaryFile();

		// display list of library items
		VBox mainPane = new VBox();
		Label mainLabel = new Label("Library Items");

		mainPane.getChildren().add(mainLabel);
		ListView<Media> list = new ListView<Media>();
		ObservableList<Media> items = FXCollections
		        .observableArrayList(myLibrary.getTheList());
		list.setItems(items);

		mainPane.getChildren().add(list);

		// make list selectable and popup info on selected item in a separate
		// stage
		list.getSelectionModel().selectedItemProperty()
		        .addListener(new ChangeListener<Media>()
		        {

			        public void changed(
			                ObservableValue<? extends Media> observable,
			                Media oldValue, Media newValue)
			        {
				        // pop up detail stage of selected media object
				        Stage newStage = null;
				        if (newValue.getType().equals("book"))
				        {
					        newStage = createBookStage(newValue);
				        } else if (newValue.getType().equals("music"))
				        {
					        newStage = createMusicStage(newValue);
				        } else
				        {
					        newStage = createVideoStage(newValue);
				        }

				        newStage.show();
			        }
		        });

		// Create a scene and place it in the stage
		Scene scene = new Scene(mainPane, 500, 200);
		primaryStage.setTitle("Media Library"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	
	/*
	 * Method to create new Stage for a Book Media item
	 * 
	 * @param Media
	 * @return Stage
	 */
	private Stage createBookStage(Media m)
	{
		Stage s = new Stage();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		Book b = (Book) m;
		// Place nodes in the pane
		pane.add(new Label("Name:"), 0, 0);
		pane.add(new Label(b.getName()), 1, 0);
		pane.add(new Label("ID:"), 0, 1);
		pane.add(new Label("" + b.getIsbnNumber()), 1, 1);
		pane.add(new Label("Format:"), 0, 2);
		pane.add(new Label(b.getFormat()), 1, 2);
		pane.add(new Label("Author"), 0, 3);
		pane.add(new Label(b.getAuthor()), 1, 3);
		pane.add(new Label("ISBN"), 0, 4);
		pane.add(new Label(b.getIsbnNumber()), 1, 4);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.setTitle("Book");
		return s;
	}

	/*
	 * Method to create new Stage for a Music Media item
	 * 
	 * @param Media
	 * @return Stage
	 */
	private Stage createMusicStage(Media m)
	{

		Stage s = new Stage();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		Music b = (Music) m;
		// Place nodes in the pane
		pane.add(new Label("Name:"), 0, 0);
		pane.add(new Label(b.getItemName()), 1, 0);
		pane.add(new Label("ID:"), 0, 1);
		pane.add(new Label("" + b.getIdNumber()), 1, 1);
		pane.add(new Label("Format:"), 0, 2);
		pane.add(new Label(b.getFormat()), 1, 2);
		pane.add(new Label("Artist"), 0, 3);
		pane.add(new Label(b.getArtist()), 1, 3);
		

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.setTitle("Music");
		return s;
	}

	/*
	 * Method to create new Stage for a Video Media item
	 * 
	 * @param Media
	 * @return Stage
	 */
	private Stage createVideoStage(Media m)
	{
		Stage s = new Stage();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		Video b = (Video) m;
		// Place nodes in the pane
		pane.add(new Label("Name:"), 0, 0);
		pane.add(new Label(b.getItemName()), 1, 0);
		pane.add(new Label("ID:"), 0, 1);
		pane.add(new Label("" + b.getIdNumber()), 1, 1);
		pane.add(new Label("Format:"), 0, 2);
		pane.add(new Label(b.getFormat()), 1, 2);
		pane.add(new Label("Director"), 0, 3);
		pane.add(new Label(b.getDirector()), 1, 3);
		pane.add(new Label("Definition"), 0, 4);
		pane.add(new Label(b.getDefinition()), 1, 4);
		pane.add(new Label("Genre"), 0, 5);
		pane.add(new Label(b.getGenre()), 1, 5);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.setTitle("Video");
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);

	}

}
