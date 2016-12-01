package main.java.concurrency.concurrentapi.cyclicbarrier;

/**
 * A task which would collect data and used with cyclic barrier
 * 
 *
 */
public class CollectDataTask implements Runnable {

	@Override
	public void run() {
		System.out.println("All task polpulated the data now lets collect it");

	}

}
