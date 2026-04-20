import java.util.Random;

/**
 * Class: ThreadLauncher
 * 
 * @author Student name removed for privacy
 * @version 1.0
 *
 *          Course: ITEC 3150
 * 
 *          Written: 04/25/2018
 * 
 *          This Class: This Class describes how the ThreadLauncher calculates the sum
 *          of 9,000,000 index with random numbers in them.
 * 
 *          Purpose: This class contains the main method which starts the program and
 *          the fill array method that will fill the Array with double values.
 */

public class ThreadLauncher
{

	/**
	 * Method: main()
	 * 
	 * This method starts the program by creating an array, filling the array with
	 * 9,000,000 random doubles, creating a SumRunnable object, and using those two
	 * into creating a ArrayRunnable. Within each ArrayRunnable we set the start and
	 * end indexes. We then pass through the ArrayRunnable into 10 Threads and start
	 * the threads, while making sure to wait for each thread to finish before printing.
	 * 
	 * @param args
	 */

	public static void main(String[] args)
	{
		double[] numbersArray = new double[9000000];

		fillArray(numbersArray);
		SumRunnable r = new SumRunnable();
		// create 10 0f theses
		ArrayRunnable runnable1 = new ArrayRunnable(0, 900000, r, numbersArray);
		ArrayRunnable runnable2 = new ArrayRunnable(900001, 1800000, r, numbersArray);
		ArrayRunnable runnable3 = new ArrayRunnable(1800001, 2700000, r, numbersArray);
		ArrayRunnable runnable4 = new ArrayRunnable(2700001, 3600000, r, numbersArray);
		ArrayRunnable runnable5 = new ArrayRunnable(3600001, 4500000, r, numbersArray);
		ArrayRunnable runnable6 = new ArrayRunnable(4500001, 5400000, r, numbersArray);
		ArrayRunnable runnable7 = new ArrayRunnable(5400001, 6300000, r, numbersArray);
		ArrayRunnable runnable8 = new ArrayRunnable(6300001, 7200000, r, numbersArray);
		ArrayRunnable runnable9 = new ArrayRunnable(7200001, 8100000, r, numbersArray);
		ArrayRunnable runnable10 = new ArrayRunnable(8100001, 8999999, r, numbersArray);

		Thread s1 = new Thread(runnable1);
		Thread s2 = new Thread(runnable2);
		Thread s3 = new Thread(runnable3);
		Thread s4 = new Thread(runnable4);
		Thread s5 = new Thread(runnable5);
		Thread s6 = new Thread(runnable6);
		Thread s7 = new Thread(runnable7);
		Thread s8 = new Thread(runnable8);
		Thread s9 = new Thread(runnable9);
		Thread s10 = new Thread(runnable10);

		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		s6.start();
		s7.start();
		s8.start();
		s9.start();
		s10.start();

		// create 10
		while (s1.isAlive() || s2.isAlive() || s3.isAlive() || s4.isAlive() || s5.isAlive() || s6.isAlive()
				|| s7.isAlive() || s8.isAlive() || s9.isAlive() || s10.isAlive())// check all ten threads here
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Final total: " + r.getSum());
	}

	/**
	 * Method fillArray()
	 * 
	 * This method go through an array, and fills each index with a random
	 * double value from 1 to 10.
	 * 
	 * @param array
	 */
	
	public static void fillArray(double[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			Random rand = new Random();
			double number = (double) rand.nextInt(10) + 1;
			// double number = 1;
			array[i] = number;
		}
	}
}
