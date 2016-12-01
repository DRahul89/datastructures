package main.java.concurrency.concurrentapi.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * A dummy service use count down latch
 *
 */
public class Service implements Runnable {

	private CountDownLatch countDownLatch;

	private int timeTostart;

	private String name;

	public Service(final String name, final int timeToStart, final CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
		this.timeTostart = timeToStart;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeTostart);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(name + " is Up");
		countDownLatch.countDown();
	}

}
