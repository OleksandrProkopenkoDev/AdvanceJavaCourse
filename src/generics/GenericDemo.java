package generics;

public class GenericDemo {

	public static void main(String[] args) {
		SimpleGenericHolder<Integer> iObject = new SimpleGenericHolder<Integer>(10);
		System.out.println(iObject.getObject());
		
		SimpleGenericHolder<String> sObject = new SimpleGenericHolder<String>("Simple Code");
		System.out.println(sObject.getObject());
		
		DualGenericHolder<String, Integer> obj = 
				new DualGenericHolder("Simple code", 10);
		obj.display();
	}

}
