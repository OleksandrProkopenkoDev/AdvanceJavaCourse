package enums;

public class EnamColorTest {

	public static void main(String[] args) {
		Color color1 = Color.RED;
		
		System.out.println("Red enum name "+ color1.name());
		System.out.println("Red enum value "+ color1.getValue());
		for (Color color : Color.values()) {
			System.out.println("Enum value: " + color.getValue());
		}

	}

}
