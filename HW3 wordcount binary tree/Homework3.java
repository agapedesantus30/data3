import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Starting class for Homework3.  Contains the main class
 * @author cjohns25
 *
 */
public class Homework3
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		  BST<WordCount> words = new BST<WordCount>();
	      Scanner in;
        try
        {
	        in = new Scanner(new File("TedAndtheTelephone.txt"));
        
	      // Use any characters other than a-z or A-Z as delimiters
	      in.useDelimiter("[^a-zA-Z]+");
	      while (in.hasNext())
	      {
	    	 String word = in.next();
	         WordCount tempCount = new WordCount(word.toLowerCase()); 
	         
	         // handle word already in BST
	         if (words.search(tempCount))
	         {
	        	 // get current count from the tree
	        	 WordCount currentCount = words.delete(tempCount);
	        	 // add one to current count and replace in tree
	        	 currentCount.increment();
	        	 tempCount = currentCount;
	         }
	         // add wordCount to tree
	         words.insert(tempCount);
	      }
	      in.close();
	      words.reverseOrder();
        } catch (IOException e)
        {
	        System.out.println("Problem with file input");
	        e.printStackTrace();
        }

	}

}
