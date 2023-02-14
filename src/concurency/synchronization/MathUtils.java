package concurency.synchronization;

import java.util.Iterator;

public class MathUtils {

	 void getMultiples(int n, String name) {
			synchronized (this) {

				for (int i = 1; i <= 5; i++) {
					System.out.println(name + " :" + n * i);
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
}
