package jdbc;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class JdbcDemo {

	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("/jdbc/beans.xml");
		System.out.println("xml loaded");
//		DataBase db = new DataBase();
		DataBase db = context.getBean("db", DataBase.class);
		db.printDatabaseMetadata();
		
		
		
		/*
		 * int rollno = 5; String name = "Kel"; int age = 21;
		 */
		
		/*
//		db.addStudent(rollno, name, age);
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student(6, "Gus", 34));
		students.add(new Student(7, "Ous", 24));
		students.add(new Student(8, "qus", 31));
		students.add(new Student(9, "tus", 38));
		db.addStudents(students);
		
		db.printStudentTableMetadata();
		db.printDatabaseMetadata();
		db.printScrollableResultSetSelect(7);
		
		db.updatableResultSetTest(2, 30);
		
		db.saveImageToDB();

		db.retriveImageFromDBAndSaveToHardDrive(1);
	
		db.saveTextFileToDB();
		
		db.retriveTextFileFromDBAndSaveToHardDrive(1);
*/		
	}

}
