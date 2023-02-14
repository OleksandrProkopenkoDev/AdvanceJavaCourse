package jdbc;

import java.util.ArrayList;



public class JdbcDemo {

	public static void main(String[] args)  {
		DataBase db = new DataBase();
		int rollno = 5;
		String name = "Kel";
		int age = 21;
//		db.addStudent(rollno, name, age);
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student(6, "Gus", 34));
		students.add(new Student(7, "Ous", 24));
		students.add(new Student(8, "qus", 31));
		students.add(new Student(9, "tus", 38));
		db.addStudents(students);
	}

}
