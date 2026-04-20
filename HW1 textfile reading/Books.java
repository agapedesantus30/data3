/**
 * Class: Books
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2012 Written: January 15, 2018
 * 
 * 
 *          This class � This class describes a subclass of MediaDevices called
 *          Books
 * 
 *          Purpose: contains the attributes specific to a type of media device
 *          called Books.
 *
 */
public class Books extends MediaDevices {
	private String author;
	private long iSBN;
	private String platform;

	/**
	 * @return concatenation of objects
	 */
	@Override
	public String toString() {
		return super.toString() + " " + "Books [author=" + author + ", iSBN=" + iSBN + ", platform=" + platform + "]";
	}

	/**
	 * default constructor
	 */
	public Books(String category, String name, int itemNumber, String author, long iSBN, String platform) {
		super(category, name, itemNumber);
		this.author = author;
		this.iSBN = iSBN;
		this.platform = platform;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the iSBN
	 */
	public long getISBN() {
		return iSBN;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
}