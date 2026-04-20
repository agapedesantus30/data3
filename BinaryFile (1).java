import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Class: BinaryFile
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: February 3, 2018
 * 
 * 
 *          This class � This class describes BinaryFile used to contain the the
 *          attributes specific to a type of file. It also contains the main
 *          method which starts the program.
 * 
 *          Purpose: Methods and attributes needed to create a BinaryFile.
 *          Creates objects, write to binary file and read from binary file.
 *
 */
public class BinaryFile implements Serializable {
	private String category, name, artist, director, genre, author, platform;
	private int itemNumber;
	private long iSBN;

	/**
	 * @return concatenation of objects
	 */
	@Override
	public String toString() {
		return "[category=" + category + ", name=" + name + ", itemNumber=" + itemNumber + ", artist=" + artist
				+ ", director=" + director + ", genre=" + genre + ", author=" + author + ", iSBN=" + iSBN
				+ ", platform=" + platform + "]";
	}

	/**
	 * Default constructor used to create empty attributes
	 */
	public BinaryFile() {
		category = "";
		name = "";
		artist = "";
		director = "";
		genre = "";
		author = "";
		platform = "";
		iSBN = 0;
		itemNumber = 0;
	}

	/**
	 * @param category
	 * @param name
	 * @param artist
	 * @param director
	 * @param genre,
	 * @param author,
	 * @param platform;
	 * @param iSBN;
	 * @param itemNumber;
	 */
	public BinaryFile(String category, String name, int itemNumber, String artist, String director, String genre,
			String author, long iSBN, String platform) {
		this.category = category;
		this.name = name;
		this.itemNumber = itemNumber;
		this.artist = artist;
		this.director = director;
		this.genre = genre;
		this.author = author;
		this.iSBN = iSBN;
		this.platform = platform;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist
	 *            the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the itemNumber
	 */
	public int getItemNumber() {
		return itemNumber;
	}

	/**
	 * @param itemNumber
	 *            the itemNumber to set
	 */
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * @return the iSBN
	 */
	public long getiSBN() {
		return iSBN;
	}

	/**
	 * @param iSBN
	 *            the iSBN to set
	 */
	public void setiSBN(long iSBN) {
		this.iSBN = iSBN;
	}

	/**
	 * 
	 * Method:main()
	 * 
	 * This method is the starting point of the program. It contains creation of
	 * objects and the initial reading of items from the binary file.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// creates people.dat binary file by reading in objects
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("people.dat"));

		BinaryFile bf1 = new BinaryFile("Books", "American Elf 1999 ", 1, "", "", "", "James Kochalka ", 9781603092395L,
				"ebooks");
		BinaryFile bf2 = new BinaryFile("Music", "That's what i like ", 2, "Bruno Mars ", "", "", "", 0L, "CD");
		BinaryFile bf3 = new BinaryFile("Books", "Dear Julia ", 3, "", "", "", "Brian Biggs", 9781891830129L,
				"audio books");
		BinaryFile bf4 = new BinaryFile("Video", "Jumaji: Welcome to the Jungle ", 4, "", "Jake Kasdan ", "Comedy ", "",
				0L, "Amazon Video");
		BinaryFile bf5 = new BinaryFile("Music", "Glorious ", 5, "Macklemore feat Skylar grey ", "", "", "", 0L,
				"Vinyl");
		BinaryFile bf6 = new BinaryFile("Books", "Lost Girls ", 6, "", "", "", "Alan Moore and Melinda Gebbie ",
				9781603090495L, "Hardcover");
		BinaryFile bf7 = new BinaryFile("Music", "Come Hang out ", 7, "AJR ", "", "", "", 0L, "Pandora");
		BinaryFile bf8 = new BinaryFile("Video", "Avengers: age of ultron ", 8, "", "Josh Whedon ", "Action ", "", 0L,
				"DVD");
		BinaryFile bf9 = new BinaryFile("Video", "Bright ", 9, "", "David Ayer ", "Action ", "", 0L, "Netflix");
		BinaryFile bf10 = new BinaryFile("Music", "Home ", 10, "MGK ", "", "", "", 0L, "CD");

		objectOutputStream.writeObject(bf1);
		objectOutputStream.writeObject(bf2);
		objectOutputStream.writeObject(bf3);
		objectOutputStream.writeObject(bf4);
		objectOutputStream.writeObject(bf5);
		objectOutputStream.writeObject(bf6);
		objectOutputStream.writeObject(bf7);
		objectOutputStream.writeObject(bf8);
		objectOutputStream.writeObject(bf9);
		objectOutputStream.writeObject(bf10);
		objectOutputStream.close();

		// displays people.dat file onto console
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("people.dat"));

		BinaryFile bfReader1 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader2 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader3 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader4 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader5 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader6 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader7 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader8 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader9 = (BinaryFile) objectInputStream.readObject();
		BinaryFile bfReader10 = (BinaryFile) objectInputStream.readObject();
		objectInputStream.close();

		System.out.println("category:" + bfReader1.category + " name:" + bfReader1.name + "  itemNumber:"
				+ bfReader1.itemNumber + "  author:" + bfReader1.author + "  iSBN:" + bfReader1.iSBN + "  platform:"
				+ bfReader1.platform);
		System.out.println("category:" + bfReader2.category + " name:" + bfReader2.name + "  itemNumber:"
				+ bfReader2.itemNumber + "  artist:" + bfReader2.artist + "  platform:" + bfReader2.platform);
		System.out.println("category:" + bfReader3.category + " name:" + bfReader3.name + "  itemNumber:"
				+ bfReader3.itemNumber + "  author:" + bfReader3.author + "  iSBN:" + bfReader3.iSBN + "  platform:"
				+ bfReader3.platform);
		System.out.println("category:" + bfReader4.category + " name:" + bfReader4.name + "  itemNumber:"
				+ bfReader4.itemNumber + "  director:" + bfReader4.director + "  genre:" + bfReader4.genre
				+ "  platform:" + bfReader4.platform);
		System.out.println("category:" + bfReader5.category + " name:" + bfReader5.name + "  itemNumber:"
				+ bfReader5.itemNumber + "  artist:" + bfReader5.artist + "  platform:" + bfReader5.platform);
		System.out.println("category:" + bfReader6.category + " name:" + bfReader6.name + "  itemNumber:"
				+ bfReader6.itemNumber + "  author:" + bfReader6.author + "  iSBN:" + bfReader6.iSBN + "  platform:"
				+ bfReader6.platform);
		System.out.println("category:" + bfReader7.category + " name:" + bfReader7.name + "  itemNumber:"
				+ bfReader7.itemNumber + "  artist:" + bfReader7.artist + "  platform:" + bfReader1.platform);
		System.out.println("category:" + bfReader8.category + " name:" + bfReader8.name + "  itemNumber:"
				+ bfReader8.itemNumber + "  director:" + bfReader8.director + "  genre:" + bfReader8.genre
				+ "  platform:" + bfReader8.platform);
		System.out.println("category:" + bfReader9.category + " name:" + bfReader9.name + "  itemNumber:"
				+ bfReader9.itemNumber + "  director:" + bfReader9.director + "  genre:" + bfReader9.genre
				+ "  platform:" + bfReader9.platform);
		System.out.println("category:" + bfReader10.category + " name:" + bfReader10.name + "  itemNumber:"
				+ bfReader10.itemNumber + "  artist:" + bfReader10.artist + "  platform:" + bfReader10.platform);

	}
}
