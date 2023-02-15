package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {

	private String url = "jdbc:postgresql://localhost:5432/testPostgreDB";
	private String user = "postgres";
	private String password = "postroot";	
	
	public void addStudents(ArrayList<Student> students) {
		String insertStudentsSQL = "insert into student (rollno, st_name, age)"+
				"values(?,?,?);";
		try(Connection connection = DriverManager.getConnection(url,user,password)){
			PreparedStatement preparedStatement = connection.prepareStatement(insertStudentsSQL);
			connection.setAutoCommit(false);
			for (Student student : students) {
				preparedStatement.setInt(1, student.getRollno());
				preparedStatement.setString(2, student.getName());
				preparedStatement.setInt(3, student.getAge());
				preparedStatement.addBatch();
			}
			
			int[] updateCounts = preparedStatement.executeBatch();
			System.out.println(Arrays.toString(updateCounts));
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addStudent(int rollno, String name, int age) {
		Connection connection = null;
		
		String sql = "insert into student (rollno, st_name, age)"+
		"values("+rollno+", '"+name+"', "+age+");";
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			int m = statement.executeUpdate(sql);
			if(m == 1)System.out.println("inserted successfully : "+ sql);
			else System.out.println("insertion failed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
