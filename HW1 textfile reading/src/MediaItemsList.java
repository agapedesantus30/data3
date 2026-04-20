import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: MediaItemsList
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2012 Written: January 15, 2018
 * 
 * 
 *          This class � This class describes MediaItemList used to contain the
 *          MediaDevices item MediaItemList. It also contains the main method
 *          which starts the program.
 * 
 *          Purpose: Methods and attributes needed to create a MediaItemList of
 *          MediaDevices class. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class MediaItemsList {

	// actual MediaItemsList data
	private ArrayList<MediaDevices> MediaItemsList = new ArrayList<MediaDevices>();

	/**
	 * Method:printMediaItemsList()
	 * 
	 * This method prints the MediaItems contained in the MediaItemsList Array list.
	 * It relies on the toString method of the various MediaDevices to print the
	 * items in a user friendly format.
	 * 
	 * 
	 */
	public void printMediaItemsList() {
		for (int i = 0; i < MediaItemsList.size(); i++) {
			MediaDevices temp = MediaItemsList.get(i);
			System.out.println(temp);
		}
	}

	/**
	 * Method:searchByname()
	 * 
	 * This method looks at each item in the MediaItemsList array list and if its
	 * idNumber attribute matches the input parameter id, that item is returned to
	 * the caller. It returns null if item is not found.
	 * 
	 * @param name
	 * 
	 * @return Pet
	 * 
	 */
	public MediaDevices searchByName(String name) {
		MediaDevices item = null;
		for (MediaDevices temp : MediaItemsList) {
			if (temp.getName().equalsIgnoreCase(name)) {
				item = temp;
			}
		}
		return item;
	}

	/**
	 * @return the MediaItemsList
	 */
	public ArrayList<MediaDevices> getMediaItemsList() {
		return MediaItemsList;
	}

	/**
	 * Method:addItem()
	 * 
	 * This method adds the parameter @param md to the MediaItemsList array list
	 * 
	 * @param md
	 * 
	 */
	public void addItem(MediaDevices md) {
		MediaItemsList.add(md);
	}

	/**
	 * Method:removeItem()
	 * 
	 * This method removes the item with name from the array list
	 * 
	 * @param md
	 * 
	 */
	public void removeItem(String name) {
		MediaDevices md = this.searchByName(name);
		if (md != null) {
			MediaItemsList.remove(md);
		}
	}

	/**
	 * 
	 * Method:main()
	 * 
	 * This method is the starting point of the program. It contains the initial
	 * reading of items from the text file mediaDevice.txt and a menu for allowing
	 * user to choose various tasks.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// create MediaItemsList by reading in from text file named mediaDevice.txt
		MediaItemsList myMediaItemsList = new MediaItemsList();

		// open text file
		File mediaDeviceFile = new File("mediaDevice.txt");
		// open a Scanner to read data from File
		Scanner mediaDeviceReader = null;
		try {
			mediaDeviceReader = new Scanner(mediaDeviceFile);
		} catch (FileNotFoundException e) {
			System.out.println("No MediaDevice found in the MediaItemsList - MediaItemsList is empty");
		}

		// reads one mediaDevice at a time
		while (mediaDeviceReader != null && mediaDeviceReader.hasNext()) {
			String specification = mediaDeviceReader.nextLine();
			String name = mediaDeviceReader.nextLine();
			String itemNumberString = mediaDeviceReader.nextLine();
			int itemNumber = Integer.parseInt(itemNumberString);

			if (specification.equalsIgnoreCase("Video")) {
				String director = mediaDeviceReader.nextLine();
				String genre = mediaDeviceReader.nextLine();
				String platform = mediaDeviceReader.nextLine();
				Video vd = new Video(specification, name, itemNumber, director, genre, platform);
				myMediaItemsList.addItem(vd);
			} else if (specification.equalsIgnoreCase("Music")) {
				String artist = mediaDeviceReader.nextLine();
				String platform = mediaDeviceReader.nextLine();
				Music mu = new Music(specification, name, itemNumber, artist, platform);
				myMediaItemsList.addItem(mu);
			} else if (specification.equalsIgnoreCase("Books")) {
				String author = mediaDeviceReader.nextLine();
				String iSBNString = mediaDeviceReader.nextLine();
				long iSBN = Long.parseLong(iSBNString);
				String platform = mediaDeviceReader.nextLine();
				Books bks = new Books(specification, name, itemNumber, author, iSBN, platform);
				myMediaItemsList.addItem(bks);
			} else {
				System.out.println("Unknown MediaDevice " + specification);
			}
		}

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to the Media Items List");
		boolean done = false;
		while (!done) {
			System.out.println("Would you like to :");
			System.out.println("  1. View contents of Media Items List");
			System.out.println("  2. Search for a media device");
			System.out.println("  3. Remove a media device");
			System.out.println("  4.  Exit");
			String str = keyboard.nextLine();
			int userInput = Integer.parseInt(str);
			if (userInput == 1) {
				myMediaItemsList.printMediaItemsList();
			} else if (userInput == 2) {
				System.out.println("Please enter media device");
				String id = keyboard.nextLine();
				MediaDevices item = myMediaItemsList.searchByName(id);
				if (item != null) {
					System.out.println(item);
				} else {
					System.out.println("Sorry- item not found");
				}
			} else if (userInput == 3) {
				System.out.println("Please enter the name of media device");
				String id2 = keyboard.nextLine();
				myMediaItemsList.removeItem(id2);
			} else {
				done = true;
				// write out contents of MediaItemList back to original file
				PrintWriter out = null;
				// open file for writing
				try {
					out = new PrintWriter(new File("mediaDevice.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// write contents of each ClientList item to file
				for (MediaDevices md : myMediaItemsList.getMediaItemsList()) {
					// first write the attributes common to all
					out.println(md.getCategory());
					out.println(md.getName());
					out.println(md.getItemNumber());

					if (md.getCategory().equalsIgnoreCase("Video")) {
						// cast to appropriate subclass
						Video v = (Video) md;
						// write attributes specific to Video
						out.println(v.getDirector());
						out.println(v.getGenre());
						out.println(v.getPlatform());
					} else if (md.getCategory().equalsIgnoreCase("Music")) {
						// cast to appropriate subclass
						Music m = (Music) md;
						// write attributes specific to Music
						out.println(m.getArtist());
						out.println(m.getPlatform());
					} else if (md.getCategory().equalsIgnoreCase("Books")) {
						Books b = (Books) md;
						out.println(b.getISBN());
						out.println(b.getPlatform());
					} else {
						System.out.println("Unknown Media Device " + md.getCategory());
					}
				}
				out.close();
			}

		}

	}
}