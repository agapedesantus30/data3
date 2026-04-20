import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Agapitus Iboro

public class HashSetExample {

    public static void main(String[] args) {

      String initialSet[] = {"Romeo", "Juliet", "Adam", "Eve", "Homer", "Marge", "Bart", "Eve"};
      String initialSet2[] = { "Eve", "Homer", "Marge", "Bart", "Eve", "Stewie", "Alex"};
      Set<String> set1 = new HashSet<String>(Arrays.asList(initialSet));
      Set<String> set2 = new HashSet<String>(Arrays.asList(initialSet2));
      Set<String> set3 = new HashSet<String>();

      for (final String s1 : set1) {
          if (set2.contains(s1)) {
              set3.add(s1);
          }
      }

      System.out.println(set3);

    }

}