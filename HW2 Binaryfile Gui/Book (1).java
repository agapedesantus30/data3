/**
 * Class: Book
 * 
 * @author Dr. Johnson
 * @version 1.0 Course : ITEC 3150, Fall, 2015 Written: January 18, 2012
 * @version 2.0 August 26, 2016
 * 
 * 
 *          This class � This class describes a subclass of Media called Book
 * 
 *          Purpose: � Contains the attributes specific to a type of Media
 *          called Book.
 *
 */
public class Book extends Media
{
    private String format;
    private String author;
    private String isbnNumber;

    /**
     * Method:Book()
     * 
     * Constructor method that accepts values for all the attributes and sets
     * them.
     * 
     * @param idNumber
     * @param itemName
     * @param type
     * @param format
     * @param author
     * @param isbnNum
     */
    public Book(int idNumber, String itemName, String type, String format, String author, String isbnNum)
    {
        super(idNumber, itemName, type);
        this.format = format;
        this.author = author;
        this.isbnNumber = isbnNum;
    }

    /**
     * Getter method for format
     * @return the format
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * Getter method for author
     * 
     * @return the author
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Getter method for isbnNumber
     * 
     * @return the isbnNumber
     */
    public String getIsbnNumber()
    {
        return isbnNumber;
    }

    /*
     * Method:toString() Converts the attributes of the class to a text readable
     * format.
     * 
     * 
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return super.toString() ;
    }

}
