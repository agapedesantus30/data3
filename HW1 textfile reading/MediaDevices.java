/**
 * Class: MediaDevices
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2012 Written: January 15, 2018
 * 
 * 
 *          This class � This class describes a subclass of MediaDevices called
 *          Books
 * 
 *          Purpose: This class id intended to serve as a parent class only for
 *          all types of media devices
 *
 */
public class MediaDevices {
	private String category;
	private String name;
	private int itemNumber;

	/**
	 * default constructor
	 */
	public MediaDevices(String category, String name, int itemNumber) {
		super();
		this.category = category;
		this.name = name;
		this.itemNumber = itemNumber;
	}

	/**
	 * @return concatenation of objects
	 */
	@Override
	public String toString() {
		return "MediaDevice [category=" + category + ", name=" + name + ", itemNumber=" + itemNumber + "]";
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the itemNumber
	 */
	public int getItemNumber() {
		return itemNumber;
	}
}
