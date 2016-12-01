package main.java.concurrency.semaphore;
/*
 * only some N threads can enter in to semaphore
 */
public class CountingSemaphore {

	private int signalCount = 0;

	private int upperBound = 0;

	public CountingSemaphore(final int upperBound) {
		this.upperBound = upperBound;
	}

	public synchronized void send() throws InterruptedException {
		if (this.signalCount == upperBound) {
			wait();
		}
		signalCount++;
		this.notifyAll();
	}

	public synchronized void recieve() throws InterruptedException {
		if (this.signalCount == 0) {
			wait();
		}
		signalCount--;
		this.notifyAll();
	}
}
