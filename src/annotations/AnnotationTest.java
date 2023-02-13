package annotations;

import java.lang.reflect.Method;

public class AnnotationTest {
	@MyCustomAnnotation(value = 10)
	public void sayHello() {
		System.out.println("My custom annotation");
	}
	
	public static void main(String[] args) {
		AnnotationTest aTest = new AnnotationTest();
		try {
			Method method = aTest.getClass().getMethod("sayHello");
			MyCustomAnnotation myAnno = method.getAnnotation(MyCustomAnnotation.class);
			System.out.println("value is: "+ myAnno.value());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
