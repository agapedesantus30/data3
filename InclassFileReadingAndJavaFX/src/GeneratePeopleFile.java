import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Class: GeneratePeopleFile
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 8, 2018
 * 
 * 
 *          This class describes GeneratePeopleFile used to populate the Main
 *          class pane.
 * 
 *          Purpose: Methods and attributes needed to create a
 *          GeneratePeopleFile for the Main class. create objects, Print them,
 *          and read them from a file.
 *
 */
public class GeneratePeopleFile {

	// actual library data
	private ArrayList<Person> libraryItems = new ArrayList<Person>();

	public ArrayList<Person> getTheList() {
		return libraryItems;
	}

	/**
	 * Method:printLibraryItems()
	 * 
	 * This method prints the library items contained in the libraryItems Array
	 * list. It relies on the toString method of the various Person types to print
	 * the items in a user friendly format.
	 * 
	 * 
	 */
	public void printLibraryItems() {
		for (int i = 0; i < libraryItems.size(); i++) {
			Person temp = libraryItems.get(i);
			System.out.println(temp);
		}

	}

	/**
	 * Method:addItem()
	 * 
	 * This method adds the parameter m to the libraryItems array list
	 * 
	 * @param m
	 * 
	 */
	public void addItem(Person m) {
		libraryItems.add(m);
	}

	/**
	 * readBinaryFile()
	 * 
	 * This method populates the libraryItems array list from a binary files
	 */
	public void readBinaryFile() {
		try { // Create an input stream for file object.dat
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("people.dat"));
			while (true) {
				Person m = (Person) input.readObject();
				addItem(m);
			}
		} catch (EOFException ex) {
			// do nothing reached the end of the file
		} catch (IOException i) {
			System.out.println("Unable to read from file");
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Object read is not a java.util.Date instance");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("people.dat"));

			// create some students
			Student s1 = new Student("Luke Skywalker", "Student", 1, 3.1);
			Student s2 = new Student("Leia Organa", "Student", 2, 3.6);
			Employee e1 = new Employee("Obi-Wan Kenobi", "Employee", 3, 50000);
			Employee e2 = new Employee("Darth Vader", "Employee", 4, 60000);

			// write to the file
			output.writeObject(s1);
			output.writeObject(s2);
			output.writeObject(e1);
			output.writeObject(e2);

			output.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
