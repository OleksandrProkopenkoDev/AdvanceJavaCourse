package concurency.synchronization;

public class Thread1 extends Thread {
	private MathUtils mu;
	
	
	public Thread1(MathUtils mu) {
		super();
		this.mu = mu;
	}


	@Override
	public void run() {
		mu.getMultiples(2, this.getName());
	}

}
