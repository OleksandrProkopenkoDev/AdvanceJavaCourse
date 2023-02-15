package concurency.utilities;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(() -> {
			Thread.sleep(5000);
			return "Completed";
		});
		
			try {
				while (!future.isDone()) {
					System.out.println("task still in progress... wait");
					Thread.sleep(1000);
				}
				System.out.println("Task compleeted!");
				String result = future.get(3000, TimeUnit.MILLISECONDS);
				System.out.println(result);
				executorService.shutdown();
			} catch (TimeoutException | ExecutionException | InterruptedException e) {
				future.cancel(true);
				e.printStackTrace();
		}
		
	}

}
