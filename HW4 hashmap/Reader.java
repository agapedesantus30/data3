import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class: Reader
 *
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: April 9, 2018
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
public class Reader {

    // actual Reader data
    MediaHashMap MediaItemsList = new MediaHashMap();

    /**
     * Method:printMediaItemsList()
     *
     * This method prints the MediaItems contained in the Reader Array list.
     * It relies on the toString method of the various MediaDevices to print the
     * items in a user friendly format.
     *
     *
     */
    public void printMediaItemsList() {
        for (MediaDevices value : MediaItemsList.values()) {
            System.out.println(value);
        }
    }

    /**
     * Method:searchByname()
     *
     * This method looks at each item in the Reader array list and if its
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
        for (MediaDevices temp : MediaItemsList.values()) {
            if (temp.getName().equalsIgnoreCase(name)) {
                item = temp;
            }
        }
        return item;
    }

    /**
     * @return the MediaItemsList
     */
    public MediaHashMap getMediaItemsList() {
        return MediaItemsList;
    }

    /**
     * Method:addItem()
     *
     * This method adds the parameter @param md to the Reader MediaItemsList
     *
     * @param md
     *
     */
    public void addItem(String key, MediaDevices md) {
        MediaItemsList.put(key, md);
    }

    /**
     * Method:removeItem()
     *
     * This method removes the item with name from the MediaItemsList
     *
     * @param name
     *
     */
    public void removeItem(String name) {
        MediaItemsList.remove(name);
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
        // create Reader by reading in from text file named mediaDevice.txt
        Reader myMediaItemsList = new Reader();

        // open text file
        File mediaDeviceFile = new File("mediaDevice.txt");
        // open a Scanner to read data from File
        Scanner mediaDeviceReader = null;
        try {
            mediaDeviceReader = new Scanner(mediaDeviceFile);
        } catch (FileNotFoundException e) {
            System.out.println("No MediaDevice found in the Reader - Reader is empty");
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
                myMediaItemsList.addItem(String.valueOf(itemNumber), vd);
            } else if (specification.equalsIgnoreCase("Music")) {
                String artist = mediaDeviceReader.nextLine();
                String platform = mediaDeviceReader.nextLine();
                Music mu = new Music(specification, name, itemNumber, artist, platform);
                myMediaItemsList.addItem(String.valueOf(itemNumber), mu);
            } else if (specification.equalsIgnoreCase("Books")) {
                String author = mediaDeviceReader.nextLine();
                String iSBNString = mediaDeviceReader.nextLine();
                long iSBN = Long.parseLong(iSBNString);
                String platform = mediaDeviceReader.nextLine();
                Books bks = new Books(specification, name, itemNumber, author, iSBN, platform);
                myMediaItemsList.addItem(String.valueOf(itemNumber), bks);
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
                for (MediaDevices md : myMediaItemsList.getMediaItemsList().values()) {
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