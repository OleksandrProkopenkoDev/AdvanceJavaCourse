package concurency.synchronization;

public class Thread2 implements Runnable {
	private MathUtils mu;
	
	
	public Thread2(MathUtils mu) {
		super();
		this.mu = mu;
	}


	@Override
	public void run() {
		mu.getMultiples(3, Thread.currentThread().getName());
	}

}
