package generics;

public class SimpleGenericHolder<T> {
	private T object;
	
	public SimpleGenericHolder(T object) {
		this.object = object;
	}
	
	public T getObject() {
		return this.object;
	}
}
