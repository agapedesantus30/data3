import java.util.Random;

/**
 * Class: ArrayRunnable
 * 
 * @author student name removed for privacy
 * @version 1.0
 * 
 *          Course: ITEC 3150
 * 
 *          Written: 04/25/2018
 * 
 *          This Class: This Class describes the runnable ArrayRunnable
 * 
 *          Purpose: It contains the attributes for the runnable and the run
 *          method that go through the array and add the indexes together and
 *          print the total.
 *
 */

public class ArrayRunnable implements Runnable
{
	int startIndex;
	int endIndex;
	SumRunnable sum;
	double numbersArray[] = null;

	/**
	 * Method: ArrayRunnable()
	 * 
	 * This method creates an ArrayRunnable object with the follow parameters
	 * It needs a start index and end index to allow the thread to know where to start
	 * and end in the array, a sum for the values to add themselves to, and the array itself.
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @param sum
	 * @param numbersArray
	 */
	
	public ArrayRunnable(int startIndex, int endIndex, SumRunnable sum, double[] numbersArray)
	{
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.sum = sum;
		this.numbersArray = numbersArray;
	}

	/**
	 * Method: run()
	 * 
	 * This method: Runs through the array and prints out the sum of the array.
	 * 
	 */
	
	@Override
	public void run()
	{
		double total = 0;

		for (int i = startIndex; i <= endIndex; i++)
		{
			total = total + numbersArray[i];
		}
		System.out.println("Thread total = " + total);
		sum.addSum(total);
	}

}
