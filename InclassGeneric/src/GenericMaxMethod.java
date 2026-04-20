/**
 * 
 * Implementing Generic Methods IN-Class
 * 
 * @author cjohns25
 *
 */
public class GenericMaxMethod
{

    public static <E extends Comparable<E>> E max(E[] list)
    {
    	 E max = list[0]; //sets the first value in the array as the current maximum
         for (int i = 1; i < list.length; i++)
         {
             if (list[i].compareTo(max) > 0)
             {
                 max = list[i];
             }
         }
         return max;
    }

    /**
     * Main portion
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        
        // find the mazimum value of three arrays of different types
        
        String[] names = {"Dick", "Harry", "Nina", "Romeo", "Juliet", "Tom"};
        
        System.out.println("The mazimum in names is " + max(names));
        
        Integer[] numbers = { 300, 6040, -10000, 99};
        
        System.out.println("The maximum in numbers is "+ max(numbers));
        
        Person[] people = new Person[3];
        people[0] = new Person("Donald", "Trump", 45, "New York");
        people[1] = new Person("Barack" , "Obama", 44, "Chicago");
        people[2] = new Person("George W", "Bush", 43, "Texas");
        
        System.out.println("The Person class that is highest alphabetically is " + max(people));
        
    }

}
