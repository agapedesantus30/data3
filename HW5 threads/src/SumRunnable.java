import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class: SumRunnable
 * 
 * @author Student name removed for privacy
 * @version 1.0
 * 
 *          Course: ITEC 3150
 * 
 *          Written: 04/25/2018
 * 
 *          This Class: This Class describes SumRunnable
 * 
 *          Purpose: It contains the attributes for the runnable and the run
 *          method that go through the array and add the indexes together and
 *          print the total. It also locks the value in order for all of the threads
 *          to add them correctly.
 *          
 */

public class SumRunnable
{
	private double sum;
	private Lock lock;

	/**
	 * Method: SumRannable()
	 * 
	 * This method creates a new ReentrantLock and initializes sum to 0.
	 * 
	 */
	
	public SumRunnable()
	{
		lock = new ReentrantLock();
		sum = 0;
	}

	/**
	 * Method: getSum()
	 * 
	 * This method locks, then returns the sum, then unlocks.
	 * 
	 * @return sum
	 */
	
	public double getSum()
	{
		lock.lock();
		try
		{
			return sum;
		} finally
		{
			lock.unlock();
		}
	}

	/**
	 * Method addSum()
	 * 
	 * This method locks, then sets the value of sum to sum plus the double value.
	 * 
	 * @param value
	 */
	
	public void addSum(double value)
	{
		lock.lock();
		try
		{
			sum = sum + value;
		} finally
		{
			lock.unlock();
		}
	}
}
