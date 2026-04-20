import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ITEC 3150 - Text File I/O Example Person Class - This is the object we will
 * read and write to file
 * 
 * @author Agapitus Iboro
 * 
 */
public class Person2 implements Serializable {
	public String firstName;
	public String lastName;
	public int idNum;
	public String city;

	/**
	 * Default constructor used to create empty attributes
	 */
	public Person2() {
		firstName = "";
		lastName = "";
		idNum = 0;
		city = "";
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param idNum
	 * @param city
	 */
	public Person2(String firstName, String lastName, int idNum, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNum = idNum;
		this.city = city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", idNum=" + idNum + ", city=" + city
				+ "]";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}

	/**
	 * @param idNum
	 *            the idNum to set
	 */
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = 
        		new ObjectOutputStream(new FileOutputStream("people.dat"));

        Person2 p1 = new Person2("David", "Blaine", 1, "New York");
        Person2 p2 = new Person2("Lionel", "Messi", 2, "Salta");
        Person2 p3 = new Person2("Luiz", "Suarez", 3, "Rivera");

        objectOutputStream.writeObject(p1);
        objectOutputStream.writeObject(p2);
        objectOutputStream.writeObject(p3);
        objectOutputStream.close();


        ObjectInputStream objectInputStream =
            new ObjectInputStream(new FileInputStream("people.dat"));

        Person2 p1Reader = (Person2) objectInputStream.readObject();
        Person2 p2Reader = (Person2) objectInputStream.readObject();
        Person2 p3Reader = (Person2) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println("firstName:" + p1Reader.firstName + "  lastName:" +
        p1Reader.lastName + "  idNum:" + p1Reader.idNum + "  city:" + p1Reader.city);
        
        System.out.println("firstName:" + p2Reader.firstName + "  lastName:" +
                p2Reader.lastName + "  idNum:" + p2Reader.idNum + "  city:" + p2Reader.city);
        
        System.out.println("firstName:" + p3Reader.firstName + "  lastName:" +
                p3Reader.lastName + "  idNum:" + p3Reader.idNum + "  city:" + p3Reader.city);
        
    }
}