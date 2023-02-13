package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
		Student student = new Student("John", "23 East, California", 25);
		student.setX(100);
		String fileName = "student.txt";
		FileOutputStream fileOut;
		ObjectOutputStream objectOut;
		// serialization
		try {
			fileOut = new FileOutputStream(fileName);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(student);
			objectOut.close();
			fileOut.close();
			System.out.println("Student has been serialized: \n"+ student);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// deserialization
		FileInputStream fileIn;
		ObjectInputStream objectIn;
		try {
			fileIn = new FileInputStream(fileName);
			objectIn = new ObjectInputStream(fileIn);
			Student newObject = (Student)objectIn.readObject();
			System.out.println("Object has been deserialized: \n" + newObject);
			System.out.println("deserialized x = "+newObject.getX());
			objectIn.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
