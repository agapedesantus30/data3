/**
 * Word Count class for 3150 Homework 3 Solution
 * holds word and current count of how many times word has been found
 * @author cjohns25
 *
 */

public class WordCount implements Comparable<WordCount>
{
	private String word;
	private int count;

	/*
	 * CompareTo method to implement Comparable interface
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
    public int compareTo(WordCount w)
    {
	    
	    return word.compareTo(w.word);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString()
    {
	    return "word=" + word + ", count=" + count;
    }

	/**
	 * Constructor that accepts word and sets count to 1
	 * @param word
	 */
    public WordCount(String word)
    {
	
	    this.word = word;
	    this.count = 1;
    }
    
    /*
     * method to increment word count
     */
    public void increment()
    {
    	count++;
    }

}
