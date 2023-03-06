package jdbc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;

import org.springframework.beans.factory.annotation.Value;

public class DataBase {

	@Value("${DataBase.url}")
	private String url ;
	@Value("${DataBase.user}")
	private String user ;
	@Value("${DataBase.password}")
	private String password ;
	
	private File openFileFromExplorer() throws FileNotFoundException {
		File file = null;
		JFileChooser fileChoser = new JFileChooser();
		int response = fileChoser.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			file = new File(fileChoser.getSelectedFile().getAbsolutePath());
			}
		if (file == null) throw new FileNotFoundException();
		
		return file;
	}
	
	public void retriveTextFileFromDBAndSaveToHardDrive(int textFileId) {
		String sql = "select * from city_history where history_id =?;";
		Connection connection = null;
		PreparedStatement prepStatement = null;
		
		try {
			connection = DriverManager.getConnection(url,user, password);
			prepStatement = connection.prepareStatement(sql);
			prepStatement.setInt(1, textFileId);
			ResultSet rs = prepStatement.executeQuery();
			
			rs.next();
			String name = rs.getString("history_name");
			Reader reader = rs.getCharacterStream("history_details");
			 
			
			File file = openFileFromExplorer();
			FileWriter fw = new FileWriter(file);
			int i;
				while((i = reader.read()) != -1 ) {
					fw.write((char)i);
				}
			
				System.out.println(file.getPath() + " is saved");
				fw.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			if(prepStatement!= null)
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	public void saveTextFileToDB() {
		String sql = "insert into city_history (history_name, history_details) values (?,?);";
		Connection connection = null;
		PreparedStatement prepStatement = null;
		FileReader fileReader = null;
		
		try {
			connection = DriverManager.getConnection(url,user,password);
			prepStatement = connection.prepareStatement(sql);
			File file = openFileFromExplorer();
			fileReader = new FileReader(file);
			
			prepStatement.setString(1, file.getName());
			prepStatement.setCharacterStream(2, fileReader);
			
			int numberOwRowsInserted = prepStatement.executeUpdate();
			System.out.println("number of row inserted "+ numberOwRowsInserted);
		
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(prepStatement!= null)
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void retriveImageFromDBAndSaveToHardDrive(int imageId) {
		String sql = "select * from city_image where img_id = ?;";
		Connection connection = null;
		PreparedStatement prepStatement = null;
		FileOutputStream fileOutputStream = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
			prepStatement = connection.prepareStatement(sql);
			prepStatement.setInt(1, imageId);
			
			ResultSet rs = prepStatement.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			 System.out.println("Class of column photo is "+ metaData.getColumnClassName(3));
			 System.out.println("Type of column photo is "+ metaData.getColumnType(3));
			 System.out.println("Type of column photo is "+ metaData.getColumnTypeName(3));
			rs.next();
			String imageName = rs.getString("img_name");
			InputStream imageBlob = rs.getBinaryStream("photo"); 
						
				File file = openFileFromExplorer();
				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(imageBlob.readAllBytes());			
				System.out.println(imageName +" has been stored in "+file.getAbsolutePath());
				
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			if(fileOutputStream!=null)
				try {
					fileOutputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(prepStatement != null)
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void saveImageToDB() {
		String sql = "insert into city_image (img_name, photo) values(?,?);";
		Connection connection = null;
		PreparedStatement prepStatement = null;
		FileInputStream fileInputStream = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
			prepStatement = connection.prepareStatement(sql);
			
			JFileChooser fileChoser = new JFileChooser();
			int response = fileChoser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChoser.getSelectedFile().getAbsolutePath());
			
			prepStatement.setString(1, file.getName());
			fileInputStream = new FileInputStream(file);
			prepStatement.setBinaryStream(2, fileInputStream, fileInputStream.available());
			int numberOfRowsInserted = prepStatement.executeUpdate();
			System.out.println("numberOfRowsInserted "+numberOfRowsInserted);
			
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			if(fileInputStream!=null)
				try {
					fileInputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(prepStatement != null)
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	public void updatableResultSetTest(int updateRow, int setNewAge) {
		String sql = "select * from student;";
		Connection connection = null;
		PreparedStatement prepStatement = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
			prepStatement = connection.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = prepStatement.executeQuery();
			
			rs.absolute(updateRow);
			rs.updateInt(3, setNewAge);
			rs.updateRow();
			System.out.println(updateRow+" row age column is updated. New age is " + setNewAge);
			
//			move cursor to the insert row - what does it mean????
			rs.moveToInsertRow();
			rs.updateInt("rollno", 13);// looks like adding new student
			rs.updateString("st_name", "newName!");
			rs.updateInt("age", (setNewAge+2));
			rs.insertRow();
			System.out.println("new row was inserted into students table");
			//dich is going on here
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prepStatement != null)
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void printScrollableResultSetSelect(int limitRows) {
		String sql = "select * from student limit ?;";
		Connection connection = null;
		PreparedStatement prepStatement = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
			prepStatement = connection.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prepStatement.setInt(1, limitRows);
			ResultSet rs = prepStatement.executeQuery();
			//rs move forward (standard situation)
			System.out.println("----------------------ResultSet move Forward-----------------------");
			while(rs.next()) {
				int rollno = rs.getInt("rollno");
				String name = rs.getString("st_name");
				int age = rs.getInt("age");
//				display values
				System.out.print("RollNo: "+rollno);
				System.out.print(" Name: "+name);
				System.out.println(" Age: "+age);
			}
			System.out.println("\n----------------------ResultSet Move Backward-----------------------");
			rs.last();
			while(rs.previous()) {
				int rollno = rs.getInt("rollno");
				String name = rs.getString("st_name");
				int age = rs.getInt("age");
//				display values
				System.out.print("RollNo: "+rollno);
				System.out.print(" Name: "+name);
				System.out.println(" Age: "+age);
			}
			System.out.println("\n---------------ResultSet Move To Particular Position------------");
			rs.absolute(3);
			int rollno = rs.getInt("rollno");
			String name = rs.getString("st_name");
			int age = rs.getInt("age");
//			display values
			System.out.print("RollNo: "+rollno);
			System.out.print(" Name: "+name);
			System.out.println(" Age: "+age);
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(prepStatement != null)
				try {
					prepStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void printDatabaseMetadata() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
			DatabaseMetaData dbMetadata = connection.getMetaData();
			System.out.println("Driver name : " + dbMetadata.getDriverName());
			System.out.println("Driver version : " + dbMetadata.getDriverVersion());
			System.out.println("User name : " + dbMetadata.getUserName());
			System.out.println("DataBase product name : " + dbMetadata.getDatabaseProductName());
			System.out.println("DataBase product version : " + dbMetadata.getDatabaseProductVersion());
			System.out.println();
			System.out.println("------------------------Tables-------------------");
			String table[] = {"TABLE"};
			ResultSet rs = dbMetadata.getTables(null, null, null, table);
			while(rs.next()) {
				System.out.println(rs.getString(3));
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void printStudentTableMetadata() {
		String sql = "select * from student;";
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			ResultSet results = statement.executeQuery(sql);
			ResultSetMetaData rsMetadata = results.getMetaData();
			int columnCount = rsMetadata.getColumnCount();
			System.out.println("Total number of columns : " + columnCount);
			/*
			 * Get all column names, column type and columnDisplaySize
			 * 
			 */
			for(int i = 1; i <= columnCount; i++) {
				String columnName = rsMetadata.getColumnName(i);
				String columnType = rsMetadata.getColumnTypeName(i);
				int columnDisplaySize = rsMetadata.getColumnDisplaySize(i);
				System.out.println("ColumnName : "+columnName + 
				", ColumnType : "+ columnType+
				", ColumnDisplaySize : "+columnDisplaySize);
			}
			results.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
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
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
}
