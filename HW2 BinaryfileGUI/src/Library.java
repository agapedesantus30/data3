import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: Library
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * 
 * 
 *          This class � This class describes library used to contain the
 *          media item library. It also contains the main method which starts
 *          the program.
 * 
 *          Purpose: � Methods and attributes needed to create a library of
 *          Media class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class Library
{

	// actual library data
	private ArrayList<Media> libraryItems = new ArrayList<Media>();

	public ArrayList<Media> getTheList()
	{
		return libraryItems;
	}

	/**
	 * Method:printLibraryItems()
	 * 
	 * This method prints the library items contained in the libraryItems Array
	 * list. It relies on the toString method of the various Media types to
	 * print the items in a user friendly format.
	 * 
	 * 
	 */
	public void printLibraryItems()
	{
		for (int i = 0; i < libraryItems.size(); i++)
		{
			Media temp = libraryItems.get(i);
			System.out.println(temp);
		}

	}

	/**
	 * Method:searchById()
	 * 
	 * This method looks at each item in the libraryItems array list and if its
	 * idNumber attribute matches the input parameter id, that item is returned
	 * to the caller. It returns null if item is not found.
	 * 
	 * @param id
	 * 
	 * @return Media
	 * 
	 */
	public Media searchById(int id)
	{
		Media item = null;
		for (Media temp : libraryItems)
		{
			if (temp.getIdNumber() == id)
			{
				item = temp;
			}

		}
		return item;
	}

	/**
	 * Method:addItem()
	 * 
	 * This method adds the parameter m to the libraryItems array list
	 * 
	 * @param m
	 * 
	 */
	public void addItem(Media m)
	{
		libraryItems.add(m);
	}

	/**
	 * Method:deleteItem()
	 * 
	 * This method deletes the parameter m from the libraryItems array list
	 * 
	 * @param m
	 * @return
	 * 
	 */
	public void deleteItem(int m)
	{
		Media item = searchById(m);
		if (item != null)
		{
			libraryItems.remove(item);
		} else
		{
			System.out.println("Can not delete- item number does not exist");
		}

	}

	/**
	 * readBinaryFile()
	 * 
	 * This method populates the libraryItems array list from a binary files
	 */
	public void readBinaryFile()
	{
		try
		{ // Create an input stream for file object.dat
			ObjectInputStream input = new ObjectInputStream(
			        new FileInputStream("media.dat"));
			while (true)
			{
				Media m = (Media) input.readObject();
				addItem(m);
			}
		} catch (EOFException ex)
		{
			// do nothing reached the end of the file
		} catch (IOException i)
		{
			System.out.println("Unable to read from file");
			i.printStackTrace();
		} catch (ClassNotFoundException c)
		{
			System.out.println("Object read is not a java.util.Date instance");
		}

	}

	/**
	 * Method:readTextFile()
	 * 
	 * This method populates the libraryItems array list from a text file
	 * 
	 * 
	 * 
	 */
	public void readTextFile()
	{
		// open text file
		File mediaFile = new File("media.txt");
		// open a Scanner to read data from File
		Scanner mediaReader = null;
		try
		{
			mediaReader = new Scanner(mediaFile);
		} catch (FileNotFoundException e)
		{

			System.out.println("No library media found- library is empty");

		}

		// read one person at a time
		while (mediaReader != null && mediaReader.hasNext())
		{

			String category = mediaReader.nextLine();
			String name = mediaReader.nextLine();
			String idString = mediaReader.nextLine();
			int id = Integer.parseInt(idString);

			if (category.equalsIgnoreCase("music"))
			{
				String artist = mediaReader.nextLine();
				String format = mediaReader.nextLine();
				Music tp = new Music(id, name, category, format, artist);
				addItem(tp);

			} else if (category.equalsIgnoreCase("video"))
			{
				String def = mediaReader.nextLine();
				String format = mediaReader.nextLine();
				String director = mediaReader.nextLine();
				String genre = mediaReader.nextLine();
				;
				String rating = mediaReader.nextLine();
				Video tp = new Video(id, name, category, def, format, director,
				        rating, genre);
				addItem(tp);

			} else if (category.equalsIgnoreCase("book"))
			{
				String author = mediaReader.nextLine();
				String format = mediaReader.nextLine();
				String isbn = mediaReader.nextLine();
				Book tp = new Book(id, name, category, format, author, isbn);
				addItem(tp);
			} else
			{
				System.out.println("Unknown media type " + category);
			}

		}
	}

	/**
	 * Method:writeTextFile()
	 * 
	 * This method populates the text file with content of libraryItems
	 * 
	 * 
	 * 
	 */
	public void writeTextFile()
	{
		// open text file
		File mediaFile = new File("media.txt");
		// open a Scanner to read data from File
		PrintWriter mediaWriter = null;
		try
		{
			mediaWriter = new PrintWriter(mediaFile);
		} catch (FileNotFoundException e)
		{

			System.out.println("unable to open media.txt for writing");

		}

		if (mediaWriter != null)
		{
			for (Media item : libraryItems)
			{
				// write library item one at a time
				mediaWriter.println(item.getType());
				mediaWriter.println(item.getItemName());
				mediaWriter.println("" + item.getIdNumber());

				if (item.getType().equalsIgnoreCase("music"))
				{
					// cast item to Music to get music specific attributes
					Music temp = (Music) item;
					mediaWriter.println(temp.getArtist());
					mediaWriter.println(temp.getFormat());

				} else if (item.getType().equalsIgnoreCase("video"))
				{
					// cast item to Video to get Video specific attributes
					Video temp = (Video) item;
					mediaWriter.println(temp.getDefinition());
					mediaWriter.println(temp.getFormat());
					mediaWriter.println(temp.getDirector());
					mediaWriter.println(temp.getGenre());
					mediaWriter.println(temp.getRating());

				} else if (item.getType().equalsIgnoreCase("book"))
				{
					// cast item to Book to get Book specific attributes
					Book temp = (Book) item;
					mediaWriter.println(temp.getAuthor());
					mediaWriter.println(temp.getFormat());
					mediaWriter.println(temp.getIsbnNumber());

				} else
				{
					System.out.println("Unknown media type " + item.getType());
				}
			}
		}
		mediaWriter.close();

	}

	/**
	 * 
	 * Method:main()
	 * 
	 * This method is the starting point of the program. It contains the initial
	 * reading of items from the text file media.txt and a menu for allowing
	 * user to choose various tasks.
	 * 
	 * 
	 * @param args
	 * 
	 *            public static void main(String[] args) { // create library by
	 *            reading in from text file named Media.txt Library myLibrary =
	 *            new Library();
	 * 
	 *            myLibrary.readTextFile();
	 * 
	 *            Scanner keyboard = new Scanner(System.in);
	 * 
	 *            System.out.println("Welcome to the library"); boolean done =
	 *            false; while (!done) {
	 *            System.out.println("Would you like to :");
	 *            System.out.println("  1. View contents of library");
	 *            System.out.println("  2. Search for an item");
	 *            System.out.println("  3. Delete an item");
	 *            System.out.println("  4. Add an item");
	 *            System.out.println("  5. Save Changes and Exit"); String
	 *            userInput = keyboard.nextLine(); if (userInput.equals( "1")) {
	 *            myLibrary.printLibraryItems(); } else if
	 *            (userInput.equalsIgnoreCase("2")) {
	 *            System.out.println("Please enter item number"); int id =
	 *            keyboard.nextInt(); Media item = myLibrary.searchById(id); if
	 *            (item != null) { System.out.println(item); } else {
	 *            System.out.println("Sorry- item not found"); } } else if
	 *            (userInput.equals("3")) {
	 *            System.out.println("Please enter item number"); int id =
	 *            keyboard.nextInt(); myLibrary.deleteItem(id);
	 * 
	 *            } else if (userInput.equals("4")) {
	 *            System.out.println("Enter type of Media - book, music or video"
	 *            ); String type = keyboard.nextLine(); type =
	 *            type.toLowerCase(); System.out.println("Enter name of media");
	 *            String name = keyboard.nextLine();
	 *            System.out.println("Enter unique id of media (numeric)");
	 *            String idString = keyboard.nextLine(); int id =
	 *            Integer.parseInt(idString); if (type.equals("book")) {
	 *            System.out.println("Enter author"); String author =
	 *            keyboard.nextLine();
	 *            System.out.println("Enter format (print or ebook)"); String
	 *            format = keyboard.nextLine();
	 *            System.out.println("Enter ISBN "); String isbn =
	 *            keyboard.nextLine(); Book b = new Book(id, name, type, format,
	 *            author,isbn); myLibrary.addItem(b); } else if
	 *            (type.equals("music")) { System.out.println("Enter artist");
	 *            String artist = keyboard.nextLine();
	 *            System.out.println("Enter format"); String format =
	 *            keyboard.nextLine(); Music m = new Music(id, name, type,
	 *            format, artist); myLibrary.addItem(m); } else if
	 *            (type.equals("video")) {
	 *            System.out.println("Enter definition (HD or SD"); String
	 *            definition = keyboard.nextLine();
	 *            System.out.println("Enter format"); String format =
	 *            keyboard.nextLine(); System.out.println("Enter director");
	 *            String director = keyboard.nextLine();
	 *            System.out.println("Enter genre"); String genre=
	 *            keyboard.nextLine(); System.out.println("Enter rating");
	 *            String rating= keyboard.nextLine(); Video v = new Video(id,
	 *            name, type,definition, format, director, rating, genre);
	 *            myLibrary.addItem(v);
	 * 
	 *            } else {
	 *            System.out.println("Unable to add do not recognize type"); } }
	 *            else { done = true; }
	 * 
	 *            } myLibrary.writeTextFile();
	 * 
	 *            }
	 */
}
