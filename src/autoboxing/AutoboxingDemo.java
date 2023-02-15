package autoboxing;

public class AutoboxingDemo {

	public static void main(String[] args) {
		int i = 10;
		
		//autoboxing
		Integer iObject = Integer.valueOf(i);
		iObject = i;
		System.out.println("Value of Integer obj: "+iObject);
		
		//auto-unbox
		int j = iObject;
		System.out.println("Value of j: " + j);
		//-----------------------
		Character charObj = 'a';
		char ch = charObj;
		System.out.println("Value of ch: "+ ch);
		System.out.println("Value of charObj: "+ charObj);
		
	}

}
