import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewPerson {

	public static void main(String[] args) {
		Person p1 = new Person("Superman", 500, "Metropolis, USA");
		Person p2 = new Person("Batman", 35, "Gotham City, USA");
		Person p3 = new Person("Aquaman", 78, "Atlantic Ocean, Earth");

		try (FileOutputStream fos = new FileOutputStream("names.dat ");
				DataOutputStream dos = new DataOutputStream(fos)) {

			dos.writeUTF(p1.getName());
			dos.writeInt(p1.getAge());
			dos.writeUTF(p1.getAddress());

			dos.writeUTF(p2.getName());
			dos.writeInt(p2.getAge());
			dos.writeUTF(p2.getAddress());

			dos.writeUTF(p3.getName());
			dos.writeInt(p3.getAge());
			dos.writeUTF(p3.getAddress());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
