package main.java.concurrency.lock;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteReentrantLock {

	/**
	 * contains the count of writer thread
	 */
	private int writers = 0;
	/**
	 * contains the all write requests count
	 */
	private int writeRequests = 0;
	/**
	 * A map which will contain the reader threads with the count
	 */
	private Map<Thread, Integer> readerMap = new HashMap<>();

	private Thread writerThread = null;

	public synchronized void lockRead() throws InterruptedException {
		Thread currentThread = Thread.currentThread();
		while (!canGrantReadAccess(currentThread)) {
			wait();
		}
		readerMap.put(currentThread, getaccessCount(currentThread) + 1);
	}

	private int getaccessCount(Thread currentThread) {
		return null != readerMap.get(currentThread) ? readerMap.get(currentThread) : 0;
	}

	private boolean canGrantReadAccess(Thread currentThread) {
		Integer readerThreadCount = readerMap.get(currentThread);
		if (isWriter(currentThread))
			return true;
		if (writers > 0 || writeRequests > 0)
			return false;
		if (readerThreadCount != null)
			return true;
		return true;
	}

	private boolean isWriter(Thread currentThread) {
		return currentThread == writerThread;
	}

	public synchronized void unlockRead() throws InterruptedException {
		Thread currentThread = Thread.currentThread();
		if (!isReader(currentThread)) {
			throw new IllegalMonitorStateException(
					"Calling Thread does not" + " hold a read lock on this ReadWriteLock");
		}
		Integer readerThreadCount = readerMap.get(currentThread);
		if (readerThreadCount == 1) {
			readerMap.remove(currentThread);
		} else {
			readerMap.put(currentThread, getaccessCount(currentThread) - 1);
		}
		notifyAll();
	}

	private boolean isReader(Thread currentThread) {
		return readerMap.get(currentThread) != null;
	}

	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		while (!canGrantWriteAccess(Thread.currentThread())) {
			wait();
		}
		writerThread = Thread.currentThread();
		writeRequests--;
		writers++;
	}

	private boolean canGrantWriteAccess(Thread currentThread) {
		if (isOnlyReader(currentThread))
			return true;
		if (readerMap.size() > 0)
			return false;
		if (currentThread != writerThread)
			return false;
		return true;
	}

	private boolean isOnlyReader(Thread currentThread) {
		return readerMap.size() == 1 && null != readerMap.get(currentThread);
	}

	public synchronized void unlockWrite() throws InterruptedException {
		if (!isWriter(Thread.currentThread())) {
			throw new IllegalMonitorStateException(
					"Calling Thread does not" + " hold the write lock on this ReadWriteLock");
		}
		writers--;
		if (writers == 0)
			writerThread = null;
		notifyAll();
	}

}
