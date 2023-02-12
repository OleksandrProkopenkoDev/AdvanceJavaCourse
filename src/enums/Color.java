package enums;

public enum Color {
	RED(1), GREEN(2), BLUE(3);
	private int value;
	Color(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
}
