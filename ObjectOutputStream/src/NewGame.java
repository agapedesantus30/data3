import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NewGame {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ObjectOutputStream objectOutputStream = 
				new ObjectOutputStream(new FileOutputStream("games.dat "));

		Game g1 = new Game(1, "FIFA 18", "Sport", 20);
		Game g2 = new Game(2, "Need For Speed", "Sport", 50);
		Game g3 = new Game(3, "Assasins Creed", "Action", 33);

		objectOutputStream.writeObject(g1);
		objectOutputStream.writeObject(g2);
		objectOutputStream.writeObject(g3);
		objectOutputStream.close();
	}

}
