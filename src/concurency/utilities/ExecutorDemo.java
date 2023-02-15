package concurency.utilities;
import java.util.concurrent.*;
public class ExecutorDemo {

	public static void main(String[] args) {
		executorInvoke();
		executorServiceInvoke();
	}

	private static void executorInvoke() {
		Executor executor = new Caller();
		executor.execute(()-> System.out.println("executor example"));
	}
	private static void executorServiceInvoke() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(()->System.out.println("executor service example"));
		
	}
}
