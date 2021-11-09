package serializationDeserilization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable {
	//The class that will be Serializable needs to implement the Serializable interface
	int i = 10, j = 20;

}

public class SerializationAndDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//Object creation
		Test t1 = new Test();

		
		/**
		 * Serialization: Means that convert an object to binary file
		 * "test.txt" Will create at the root project and contains binary
		 */
		FileOutputStream fos = new FileOutputStream("test.txt"); 
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(t1);

		
		/**
		 * Deserialization: Means that convert from binary file to object
		 */
		
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Test t2 = (Test) ois.readObject();
		System.out.println(t2.i + "  " + t2.j);
		
	}

}
