import java.util.Set;


/**
 * HashMap In-Class Correct Example
 * @author cjohns25
 *
 */
public class MediaTester
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Media m1 = new Media("101", "Item 1", "book");
		Media m2 = new Media("102", "Item 2" , "music");
		Media m3 = new Media("103", "Item 3", "video");
		
		MediaHashMap myMap = new MediaHashMap();
	
		myMap.put(m1.getIdNumber(), m1);
		myMap.put(m2.getIdNumber(), m2);
		myMap.put(m3.getIdNumber(), m3);
		
		System.out.println("Original Hash Map");
		Set<String> keys = myMap.keySet();
		for (String key : keys)
		{
			System.out.println("Key:" + key + " Value: " + myMap.get(key));
		}
		
		myMap.remove("103");
		
		System.out.println("Final Hash Map");
		keys = myMap.keySet();
		for (String key : keys)
		{
			System.out.println("Key:" + key + " Value: " + myMap.get(key));
		}
				

	}

}
