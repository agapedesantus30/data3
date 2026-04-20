import java.util.*;
import java.util.concurrent.locks.Lock;

//Agapitus Iboro

public class HashSetSynchronized
{
 private Set<Integer> hashSet = new HashSet<Integer>();
	private static final int DELAY = 1000;
	int[] thread = new int[20];
	private Lock lock;


 class Task1 implements Runnable
 {
  public void run()
  {
	  for(int i = 0; i < thread.length; i++) {
			thread[i] = i;
			hashSet.add(thread[i]);
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(hashSet.toString());
		}

  }
 }



 class Task2 implements Runnable
 {
  public void run()
  {
	// Write code to iterate through hashset every 2 seconds and print the contents. 
	  // do this until there are at least 20 values in the set.  Make sure to make it thread safe
  }
 }


// YOU MAY ONLY ADD TO THIS METHOD - DO NOT CHANGE THE EXISTING CODE
 public HashSetSynchronized()
 {
  Thread thread1 = new Thread(new Task1());
  Thread thread2 = new Thread(new Task2());
  thread1.start();
  thread2.start();
 }
 
 // DO NOT MODIFY THIS METHOD
 public static void main(String[] args)
 {
  new HashSetSynchronized();
 }
}
