package main.java.concurrency.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * An implementation of read write reentrant lock by synchronizations
 *
 */
public class ReadWriteLock {
	/**
	 * contains the count of reader thread
	 */
	private int readers = 0;

	/**
	 * contains the count of writer thread
	 */
	private int writers = 0;
	/**
	 * contains the all write requests count
	 */
	private int writeRequests = 0;

	private Map<Thread, Integer> readerMap = new HashMap<>();

	public synchronized void lockRead() throws InterruptedException {
		while (writers > 0 || writeRequests > 0) {
			wait();
		}
		readers++;
	}

	public synchronized void unlockRead() throws InterruptedException {
		readers--;
		notifyAll();
	}

	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		while (readers > 0 || writers > 0) {
			wait();
		}
		writeRequests--;
		writers++;
	}

	public synchronized void unlockWrite() throws InterruptedException {
		writers--;
		notifyAll();
	}

}
