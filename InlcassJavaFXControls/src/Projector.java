import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
/**
 * Class: Projector
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: February 10, 2018
 * 
 * 
 *          This class � This class describes Projector used to contain the
 *          BorderPane, start method, an inner class DescriptionPane and setDisplay
 *          method. It also contains the main method which starts the program.
 * 
 *          Purpose: Methods and attributes needed to create a BorderPane,start
 *          method, an inner class DescriptionPane and setDisplay method of 
 *          projector class. Provides a description of characters along with images
 *
 */
public class Projector extends Application {
	protected Text text = new Text(50, 50, "JavaFX Programming");

	protected BorderPane getPane() {
		HBox paneForButtons = new HBox(20);
		Button btLeft = new Button("Left", new ImageView("image/left.gif"));
		Button btRight = new Button("Right", new ImageView("image/right.gif"));
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");
		
		paneForButtons.getChildren().addAll(btLeft, btRight, btUp, btDown);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: brown");

		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);

		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);

		btLeft.setOnAction(e -> text.setX(text.getX() - 10));
		btRight.setOnAction(e -> text.setX(text.getX() + 10));
		btUp.setOnAction(e -> text.setY(text.getY() - 10));
		btDown.setOnAction(e -> text.setY(text.getY() + 10));

		return pane;
	}

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place it in the stage
		Scene scene = new Scene(getPane2(), 1000, 500);
		primaryStage.setTitle("Most Exciting Naruto Shippuden Characters"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		Stage stage = new Stage(); // Create a new stage
		stage.setTitle("Text Manipulator"); // Set the stage title
		// Set a scene in the stage
		stage.setScene(new Scene(getPane(), 600, 300));
		stage.show(); // Display the stage
	}

	class DescriptionPane extends BorderPane {
		/** Label for displaying an image and a title */
		private Label lblImageTitle = new Label();

		/** Text area for displaying text */
		private TextArea taDescription = new TextArea();

		public DescriptionPane() {
			// Center the icon and text and place the text under the icon
			lblImageTitle.setContentDisplay(ContentDisplay.TOP);
			lblImageTitle.setPrefSize(500, 100);

			// Set the font in the label and the text field
			lblImageTitle.setFont(new Font("SansSerif", 40));
			taDescription.setFont(new Font("Georgia", 15));
			taDescription.setPrefHeight(800);

			taDescription.setWrapText(true);
			taDescription.setEditable(false);

			// Create a scroll pane to hold the text area
			ScrollPane scrollPane = new ScrollPane(taDescription);
			scrollPane.setStyle("-fx-border-color: brown");
			scrollPane.setStyle("-fx-border-width: 2px; -fx-border-color: brown");

			// Place label and scroll pane in the border pane
			setLeft(lblImageTitle);
			setCenter(scrollPane);
			setPadding(new Insets(5, 5, 5, 5));
		}

		/** Set the title */
		public void setTitle(String title) {
			lblImageTitle.setText(title);
		}

		/** Set the image view */
		public void setImageView(ImageView icon) {
			lblImageTitle.setGraphic(icon);
		}

		/** Set the text description */
		public void setDescription(String text) {
			taDescription.setText(text);
		}
	}

	// Declare an array of Strings for flag titles
	private String[] characterTitles = { "Pain", "Naruto Uzumaki", "Itachi Uchiha", "Sasuke Uchiha", "Killer Bee",
			"Jiriaya", "Gaara", "Kurenai Yuhi", "Kakashi", "Obito" };

	// Declare an ImageView array for the 10 characters
	private ImageView[] CharacterImage = { new ImageView("image/pain.gif"), new ImageView("image/naruto.gif"),
			new ImageView("image/Itachi.gif"), new ImageView("image/sasuke.gif"), new ImageView("image/KillerBee.gif"),
			new ImageView("image/Jiraiya.gif"), new ImageView("image/Gaara.gif"), new ImageView("image/Kurenai.gif"),
			new ImageView("image/Kakashi.gif"), new ImageView("image/obito.gif") };

	// Declare an array of strings for flag descriptions
	private String[] characterDiscription = new String[10];

	// Declare and create a description pane
	private DescriptionPane descriptionPane = new DescriptionPane();

	// Create a combo box for selecting countries
	private ComboBox<String> cbo = new ComboBox<>(); // characterTitles);

	protected BorderPane getPane2() {
		// BorderPane pane = super.getPane();
		BorderPane pane = new BorderPane();

		// Set text description
		characterDiscription[0] = "ABILITY\r\n Amplification Summoning Technique\r\n Animal Path\r\n Asura Attack\r\n "
				+ "Asura Path\r\n Banshō Ten'in\r\n Black Receiver\r\n Blocking Technique Absorption Seal\r\n "
				+ "Chibaku Tensei\r\n Deva Path\r\n Earth Release: Earth-Style Wall (Anime only)\r\n Five-Seal Barrier\r\n "
				+ "Flaming Arrow of Amazing Ability\r\n Genjutsu Protect\r\n Hidden Doorway Technique\r\n Human Path\r\n "
				+ "Magic Lantern Body Technique\r\n Mirrored Sudden Attacker Technique\r\n Naraka Path\r\n Outer Path\r\n "
				+ "Outer Path — Samsara of Heavenly Life Technique\r\n Preta Path\r\n Rain Tiger at Will Technique\r\n "
				+ "Sealing Technique: Phantom Dragons Nine Consuming Seals\r\n Sensing Technique\r\n "
				+ "Shadow Clone Technique (Anime only)\r\n Shapeshifting Technique\r\n Shinra Tensei\r\n "
				+ "Six Paths Technique\r\n Six Paths of Pain\r\n Summoning Rinnegan\r\n "
				+ "Summoning Technique (Demonic Statue of the Outer Path, Konan)\r\n Summoning: Demonic Statue of the Outer Path\r\n "
				+ "Water Release: Exploding Water Colliding Wave (Anime only)\r\n Water Release: Wild Water Wave\r\n "
				+ "Wind Release: Air Bullets (Anime only)\r\n Wind Release: Gale Palm";
		characterDiscription[1] = "ABILITY \nAll Directions Shuriken \nBig Ball Rasengan \nBig Ball Rasenshuriken"
				+ "\nBig Ball Spiralling Serial Zone Spheres \nBoil Release: Unrivalled Strength \nChakra Transfer Technique"
				+ "\nClone Body Blow \nClone Spinning Heel Drop (Anime only) \nCombination Transformation"
				+ "\nContinuous Tailed Beast Balls \nEarth Release: Earth-Style Wall (Manga only) \nErupting Propulsion Fist"
				+ "\nFire Release: Toad Oil Flame Bullet (Anime only) \nFrog Kata \nFrog Strike \nGentle Step Spiralling Twin Lion Fists"
				+ "\nHarem Technique \nHurricane Thunderclap — Majestic Attire Sword Stroke \nInk Creation \nKurama Arm Attack"
				+ "\nMini-Rasenshuriken \nMultiple Shadow Clone Technique \nNaruto Region Combo \nNaruto Uzumaki Combo "
				+ "Naruto Uzumaki Two Thousand Combo\r\nNegative Emotions Sensing\r\nNew Sexy Technique\r\nNine-Tails Chakra Mode\r\n"
				+ "One Thousand Years of Death\r\nPachinko Technique (Anime only)\r\nParachute\r\nParent and Child Rasengan\r\n"
				+ "Planetary Rasengan\r\nRasengan\r\nRasengan: Flash\r\nRegeneration Ability\r\nRunt Ball Rasengan (Anime only)\r\n"
				+ "Sage Art: Lava Release Rasenshuriken\r\nSage Art: Magnet Release Rasengan\r\n"
				+ "Sage Art: Many Ultra-Big Ball Spiralling Serial Spheres\r\nSage Art: Super Tailed Beast Rasenshuriken\r\nSage Mode\r\n"
				+ "Scorch Release: Halo Hurricane Jet Black Arrow Style Zero\r\nSexy Reverse Harem Technique\r\nSexy Technique\r\n" 
				+ "Sexy Technique: Pole Dance and Nice Body (Anime only)\r\nShadow Clone Technique\r\nShadow Shuriken Technique\r\n"
				+ "Six Paths Sage Mode\r\nSix Paths Senjutsu\r\nSix Paths Yang Power\r\nSix Paths — Chibaku Tensei\r\n"
				+ "Six Paths: Ultra-Big Ball Rasenshuriken\r\nSoap Bubble Ninjutsu (Anime only)\r\nSpiralling Absorption Sphere\r\n"
				+ "Spiralling Serial Spheres\r\nSpiralling Strife Spheres\r\nStrong Fist (Anime only)\r\nSummoning Technique (Toad)\r\n"
				+ "Summoning: Food Cart Destroyer Technique\r\nSuper Mini-Tailed Beast Ball\r\nTailed Beast Ball\r\n"
				+ "Tailed Beast Ball Rasenshuriken\r\nTailed Beast Chakra Arms\r\nTailed Beast Full Charge\r\nTailed Beast Rasengan\r\n"
				+ "Tailed Beast Shockwave\r\nTorii Seal\r\nTruth-Seeking Ball\r\nTurning into a Frog Technique (Anime only)\r\n"
				+ "Typhoon Water Vortex Technique\r\nUltra-Big Ball Rasengan\r\nUltra-Many Spiralling Serial Spheres\r\n"
				+ "Uzumaki Formation (Anime only)\r\nWind Release: Rasengan\r\nWind Release: Rasenshuriken\r\n"
				+ "Wind Release: Repeated Rasenshuriken\r\nWind Release: Toad Gun (Anime only)\r\nWind Release: Toad Oil Bullet (Anime only)\r\n"
				+ "Wind Release: Toad Oil Flame Bullet (Anime only)\r\nWind Release: Ultra-Big Ball Rasenshuriken\r\nWisdom Wolf Decay";
		characterDiscription[2] = "ABILITY\n Amaterasu\r\n Chakra Suppression Technique (Novel only)\r\n Clone Great Explosion\r\n"
				+ " Crow Clone Technique\r\n Demonic Illusion: Mirage Crow\r\n Demonic Illusion: Mirror Heaven and Earth Change\r\n"
				+ " Demonic Illusion: Shackling Stakes Technique\r\n Early Sacrifice\r\n Ephemeral\r\n Fire Release: Great Fireball Technique\r\n"
				+ " Fire Release: Phoenix Sage Fire Technique\r\n Fire Release: Phoenix Sage Flower Nail Crimson\r\n Genjutsu: Sharingan\r\n Izanami\r\n"
				+ " Sensing Barrier Pass Technique\r\n Shadow Clone Technique\r\n Summoning Technique (Crow)\r\n Susanoo\r\n Susanoo: Fist\r\n "
				+ "Transcription Seal: Amaterasu\r\n Tsukuyomi\r\n Water Release: Starch Syrup Capturing Field (Novel only)\r\n "
				+ "Water Release: Water Bullet Technique\r\n Water Release: Water Dragon Bullet Technique\r\n "
				+ "Water Release: Water Fang Bullet\r\n Yasaka Magatama";
		characterDiscription[3] = "ABILITY\n Afterglow\r\n Amaterasu\r\n Amaterasu: Flame Wrapping Fire\r\n Amenotejikara\r\n Animal Path\r\n "
				+ "Asura Path\r\n Banshō Ten'in (Anime only)\r\n Binding Snake Glare Spell\r\n Blaze Release: Honoikazuchi (Anime only)\r\n "
				+ "Blaze Release: Kagutsuchi\r\n Blaze Release: Susanoo Kagutsuchi\r\n Blaze Release: Yasaka Magatama\r\n Chibaku Tensei\r\n "
				+ "Chidori\r\n Chidori Current\r\n Chidori Senbon\r\n Chidori Sharp Spear\r\n Coercion Sharingan\r\n Cursed Seal of Heaven\r\n "
				+ "Demonic Illusion: Mirage Crow\r\n Demonic Illusion: Shackling Stakes Technique\r\n Deva Path\r\n Evil Releasing Method\r\n "
				+ "Fire Release: Dragon Fire Technique\r\n Fire Release: Great Dragon Fire Technique\r\n Fire Release: Great Fireball Technique\r\n "
				+ "Fire Release: Phoenix Sage Fire Technique\r\n Genjutsu: Sharingan\r\n Hidden Shadow Snake Hands\r\n Human Path\r\n "
				+ "Hurricane Thunderclap — Majestic Attire Sword Stroke\r\n Indra's Arrow\r\n Kirin\r\n Lightning Flash\r\n Lion Combo\r\n "
				+ "Majestic Attire: Susanoo\r\n Manipulated Shuriken Technique\r\n Manipulating Windmill Triple Blades\r\n Moonlight\r\n "
				+ "Naka Shrine Pass Technique\r\n Naraka Path\r\n Orochimaru-Style Body Replacement Technique\r\n Outer Path\r\n "
				+ "Pachinko Technique (Anime only)\r\n Peregrine Falcon Drop (Anime only)\r\n Preta Path\r\n Sasuke Uchiha's Space–Time Dōjutsu\r\n "
				+ "Scorch Release: Halo Hurricane Jet Black Arrow Style Zero\r\n Shadow Clone Technique\r\n Shadow Shuriken Technique\r\n "
				+ "Shadow of the Dancing Leaf\r\n Six Paths Technique\r\n Six Paths Yin Power\r\n Six Paths — Chibaku Tensei\r\n Strong Fist\r\n "
				+ "Summoning Technique (Hawk, Snake)\r\n Summoning: Lightning Flash Blade Creation\r\n Surging Fire Wild Dance\r\n Susanoo\r\n "
				+ "Susanoo: Captive Slash\r\n Susanoo: Chidori\r\n Susanoo: Crush\r\n Susanoo: Fist\r\n Susanoo: Great Fireball Technique (Anime only)\r\n "
				+ "Sword of Kusanagi: Chidori Katana";
		characterDiscription[4] = "ABILITY\n Acrobat\r\n Continuous Tailed Beast Balls\r\n Disturbance Taijutsu\r\n Headbutt\r\n Ink Clone Technique\r\n "
				+ "Ink Creation\r\n Lightning Release: Double Lariat\r\n Lightning Release: Lariat\r\n Octopus Leg Clone Technique\r\n "
				+ "Sealing Technique: Octopus Hold\r\n Tailed Beast Ball\r\n Tailed Beast Chakra Arms\r\n Tailed Beast Eight Twists\r\n "
				+ "Tailed Beast Full Charge\r\n Tailed Beast Lariat";
		characterDiscription[5] = "ABILITY\n Barrier: Canopy Method Formation\r\n Barrier: Toad Gourd Prison\r\n Big Ball Rasengan\r\n "
				+ "Earth Release: Swamp of the Underworld\r\n Finger Carving Seal\r\n Fire Release: Big Flame Bullet\r\n "
				+ "Fire Release: Dragon Fire Technique\r\n Fire Release: Flame Bullet\r\n Fire Release: Toad Oil Flame Bullet\r\n "
				+ "Fire Sealing Method\r\n Five Elements Unseal\r\n Frog Kata\r\n Hair Needle Senbon\r\n Hiding in a Toad Technique\r\n "
				+ "Needle Hell (Anime only)\r\n Needle Jizō\r\n Rasengan\r\n Sage Art: Goemon\r\n Sage Mode\r\n Shadow Clone Technique\r\n "
				+ "Spiralling Serial Spheres\r\n Summoning Technique (Toad)\r\n Summoning: Crushing Toad Stomach (Anime only)\r\n "
				+ "Summoning: Food Cart Destroyer Technique\r\n Summoning: Toad Mouth Bind\r\n Summoning: Toad Shop Technique\r\n "
				+ "Toad Flatness — Shadow Manipulation Technique\r\n Toad Oil Bullet\r\n Transparent Escape Technique\r\n "
				+ "Turning into a Frog Technique\r\n Ultra-Big Ball Rasengan\r\n Water Release: Water Gun (Anime only)\r\n Wild Lion's Mane Technique";
		characterDiscription[6] = "ABILITY\n Air Sand Protective Wall\r\n Armour of Sand\r\n Concealed Sand Picture Cat\r\n "
				+ "Desert Layered Imperial Funeral Seal\r\n Desert Suspension\r\n Desert Wave\r\n Desert: Hand\r\n Feigning Sleep Technique\r\n "
				+ "Monstrous Sand Arm\r\n Prison Sand Burial\r\n Quicksand Waterfall Flow\r\n Sand Binding Coffin\r\n Sand Binding Prison\r\n "
				+ "Sand Bullet (Anime only)\r\n Sand Clone\r\n Sand Drizzle\r\n Sand Hail\r\n Sand Pillar (Anime only)\r\n Sand Shuriken\r\n "
				+ "Sand Sword (Novel only)\r\n Sand Waterfall Funeral\r\n Sand Waterfall Imperial Funeral\r\n Shield of Sand\r\n "
				+ "Successive Shots Sand Drizzle\r\n Third Eye\r\n Ultimately Hard Absolute Attack: Spear of Shukaku (Anime only)\r\n "
				+ "Ultimately Hard Absolute Defence: Shield of Shukaku\r\n Wind Release: Breakthrough\r\n Wind Release: Great Breakthrough\r\n "
				+ "Wind Release: Infinite Sand Cloud — Great Breakthrough\r\n Wind Release: Multi-Layered Gale (Novel only)\r\n Wind Release: Sand Buckshot";
		characterDiscription[7] = "ABILITY\r\n Demonic Illusion: Tree Binding Death\r\n Evil Sealing Method (Anime only)\r\n "
				+ "Genjutsu: Flower Petal Escape (Anime only)\r\n Hair Camouflage (Anime only)\r\n Hiding in Surface Technique (Anime only)\r\n "
				+ "Sensing Technique (Anime only)\r\n String Bean Binding Illusion";
		characterDiscription[8] = "ABILITY\r\n Chidori\r\n Demonic Illusion: Hell Viewing Technique\r\n "
				+ "Earth Release: Double Suicide Decapitation Technique\r\n Earth Release: Earth Wave Technique (Anime only)\r\n "
				+ "Earth Release: Earth-Style Wall\r\n Earth Release: Hiding Like a Mole Technique\r\n "
				+ "Earth Release: Multiple Earth-Style Wall (Anime only)\r\n Eight Gates\r\n Evil Sealing Method\r\n Eye Mind Reading (Anime only)\r\n "
				+ "Fire Release: Great Fireball Technique (Anime only)\r\n Flying Revolving Sword (Anime only)\r\n Front Lotus (Anime only)\r\n "
				+ "Genjutsu: Sharingan\r\n Hiding in Mist Technique (Anime only)\r\n Kamui\r\n Kamui Lightning Cutter\r\n Kamui Shuriken\r\n "
				+ "Lightning Cutter\r\n Lightning Release: Lightning Beast Tracking Fang\r\n Lightning Release: Purple Electricity (Anime only)\r\n "
				+ "Lightning Release: Shadow Clone Technique\r\n Lightning Transmission\r\n Multiple Shadow Clone Technique\r\n "
				+ "One Thousand Years of Death\r\n Peregrine Falcon Drop (Anime only)\r\n Rasengan\r\n Shadow Clone Technique\r\n "
				+ "Shadow of the Dancing Leaf (Anime only)\r\n Silent Killing\r\n Strong Fist (Anime only)\r\n Summoning Technique (Ninken)\r\n "
				+ "Summoning: Earth Release: Tracking Fang Technique\r\n Susanoo\r\n Water Clone Technique\r\n "
				+ "Water Release: Great Waterfall Technique\r\n Water Release: Water Bullet Technique\r\n Water Release: Water Dragon Bullet Technique\r\n "
				+ "Water Release: Water Formation Wall\r\n Water Release: Water Shark Bullet Technique";
		characterDiscription[9] = "ABILITY\r\n Animal Path\r\n Asura Path\r\n Black Receiver\r\n Chakra Transfer Technique\r\n "
				+ "Demonic Statue Chains\r\n Deva Path\r\n Earth Release: Hiding Like a Mole Technique\r\n Explosive Landmines\r\n "
				+ "Fire Release: Blast Wave Wild Dance\r\n Fire Release: Great Fireball Technique\r\n "
				+ "Fire Release: Phoenix Sage Fire Technique (Anime only)\r\n Genjutsu: Sharingan\r\n Human Path\r\n Infinite Tsukuyomi\r\n "
				+ "Inukai Takeru no Mikoto\r\n Izanagi\r\n Kamui\r\n Naraka Path\r\n Outer Path\r\n "
				+ "Outer Path — Samsara of Heavenly Life Technique\r\n Preta Path\r\n Regeneration Ability\r\n "
				+ "Sealing Technique: Phantom Dragons Nine Consuming Seals\r\n Sensing Technique\r\n Six Paths Senjutsu\r\n "
				+ "Six Paths Technique\r\n Six Paths Ten-Tails Coffin Seal\r\n Six Paths of Pain\r\n Six Red Yang Formation\r\n "
				+ "Summoning Rinnegan\r\n Summoning Technique (Demonic Statue of the Outer Path, Kurama)\r\n "
				+ "Summoning: Demonic Statue of the Outer Path\r\n Tail Releasing Method\r\n Tailed Beast Ball\r\n "
				+ "Tailed Beast Chakra Arms\r\n Tailed Beast Transfer Technique\r\n Telescope Technique\r\n Truth-Seeking Ball\r\n "
				+ "Uchiha Flame Formation\r\n Uchiha Return\r\n Whac-A-Mole Technique (Anime only)\r\n Wood Release: Cutting Technique\r\n "
				+ "Wood Release: Great Spear Tree\r\n Wood Release: Underground Roots Technique";

		// Set the first character (pain) for display
		setDisplay(0);

		// Add combo box and description pane to the border pane
		BorderPane paneForComboBox = new BorderPane();
		paneForComboBox.setLeft(new Label("Select a Character: "));
		paneForComboBox.setCenter(cbo);
		paneForComboBox.setStyle("-fx-border-color: brown");
		paneForComboBox.setStyle("-fx-border-width: 2px; -fx-border-color: brown");
		pane.setTop(paneForComboBox);
		cbo.setPrefWidth(300);
		cbo.setValue("Pain");

		ObservableList<String> items = FXCollections.observableArrayList(characterTitles);
		cbo.getItems().addAll(items);
		pane.setCenter(descriptionPane);

		// Display the selected country
		cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

		return pane;
	}

	/** Set display information on the description pane */
	public void setDisplay(int index) {
		descriptionPane.setTitle(characterTitles[index]);
		descriptionPane.setImageView(CharacterImage[index]);
		descriptionPane.setDescription(characterDiscription[index]);
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
