import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ITEC 3150 - Text File I/O Example Person Class - This is the object we will
 * read and write to file
 * 
 * @author Agapitus Iboro
 * 
 */
public class Person {
	public String firstName;
	public String lastName;
	public int idNum;
	public String city;

	/**
	 * Default constructor used to create empty attributes
	 */
	public Person() {
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
	public Person(String firstName, String lastName, int idNum, String city) {
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

	public static void main(String[] args) {
		Person p1 = new Person("David", "Blaine", 1, "New York");
		Person p2 = new Person("Lionel", "Messi", 2, "Salta");
		Person p3 = new Person("Luiz", "Suarez", 3, "Rivera");

		try (FileOutputStream fos = new FileOutputStream("people.dat");
				DataOutputStream dos = new DataOutputStream(fos)) {

			dos.writeUTF(p1.firstName);
			dos.writeUTF(p1.lastName);
			dos.writeInt(p1.idNum);
			dos.writeUTF(p1.city);

			dos.writeUTF(p2.firstName);
			dos.writeUTF(p2.lastName);
			dos.writeInt(p2.idNum);
			dos.writeUTF(p2.city);

			dos.writeUTF(p3.firstName);
			dos.writeUTF(p3.lastName);
			dos.writeInt(p3.idNum);
			dos.writeUTF(p3.city);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (FileInputStream fis = new FileInputStream("people.dat");
				DataInputStream dis = new DataInputStream(fis)) {
			
			String firstName1 = dis.readUTF();
            String lastName1 = dis.readUTF();
            int idNum1 = dis.readInt();
            String city1 = dis.readUTF();
			System.out.println("firstName:" + firstName1 + "  lastName:" +
            lastName1 + "  idNum:" + idNum1 + "  city:" + city1);
			
			String firstName2 = dis.readUTF();
            String lastName2 = dis.readUTF();
            int idNum2 = dis.readInt();
            String city2 = dis.readUTF();
			System.out.println("firstName:" + firstName2 + "  lastName:" +
            lastName2 + "  idNum:" + idNum2 + "  city:" + city2);
			
			String firstName3 = dis.readUTF();
            String lastName3 = dis.readUTF();
            int idNum3 = dis.readInt();
            String city3 = dis.readUTF();
			System.out.println("firstName:" + firstName3 + "  lastName:" +
            lastName3 + "  idNum:" + idNum3 + "  city:" + city3);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
