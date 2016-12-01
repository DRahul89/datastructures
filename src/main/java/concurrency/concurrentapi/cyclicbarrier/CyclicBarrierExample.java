package main.java.concurrency.concurrentapi.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 
 * A demo class for cyclic barrier
 *
 */
public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CollectDataTask());
		PopulateDataTask populateDataTask = new PopulateDataTask(cyclicBarrier);
		Thread first = new Thread(populateDataTask, "firstThread");
		Thread second = new Thread(populateDataTask, "secondThread");
		Thread third = new Thread(populateDataTask, "thirdThread");
		first.start();
		second.start();
		third.start();
	}

}
