package serialization;

import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String address;
	private int age;
	transient private int x;
	


	public Student(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student name is "+ name + ", age is: "+age+", and address is: "+address;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}
