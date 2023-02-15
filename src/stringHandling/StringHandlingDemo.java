package stringHandling;

import java.util.Arrays;

public class StringHandlingDemo {

	public static void main(String[] args) {
		String str1 = "John is studying ";
		String str3 = "John is studying ";
		String str2 = "in college";
		System.out.println(str1.length());
		
		String result = str1.concat(str2);
		System.out.println(result);
		
		String r =String.format("The name of student is " +"%s, and age is %d", "John", 21);
		System.out.println(r);
		
		System.out.println("str1.charAt(5) = "+str1.charAt(5));
		
		if(str1.equals(str3)) {
			System.out.println("string1 equals string3");
		}else {
			System.out.println("both strings are different");
		}
		
		System.out.println("str1.indexOf('y') is "+str1.indexOf('y'));
		
		System.out.println("replace s with r : "+str1.replace('s', 'r'));
		
		String[] array = str1.split(" ");
		Arrays.asList(array).forEach(s -> System.out.println(s));
		System.out.println( Arrays.toString(array) );
		
		String newStr1 = str1.substring(1, 5);
		System.out.println(newStr1);
		
	}

}
