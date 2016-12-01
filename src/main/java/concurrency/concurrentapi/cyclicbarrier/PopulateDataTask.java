package main.java.concurrency.concurrentapi.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * A task which would populate some data
 *
 */
public class PopulateDataTask implements Runnable {

	private CyclicBarrier cyclicBarrier;

	public PopulateDataTask(final CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			System.out.println("Data populated by thread " + Thread.currentThread().getName());
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

}
