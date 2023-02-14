package concurency.synchronization;

public class SynchronizationDemo {

	public static void main(String[] args) {
		MathUtils mu = new MathUtils();
		Thread1 t1 = new Thread1(mu);
		Thread t2 = new Thread(new Thread2(mu));
		t1.start();
		t2.start();
	}

}
