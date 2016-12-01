package main.java.concurrency.lock;

public class ReentrantLock {

	private boolean isLocked;

	private Thread currentThread;
	
	private int lockedCount = 0;

	public synchronized void lock() throws InterruptedException {
		while (isLocked && !Thread.currentThread().equals(currentThread)) {
			wait();
		}
		lockedCount++;
		currentThread = Thread.currentThread();
		isLocked = true;
	}

	public synchronized void unlock() throws InterruptedException {
		while (Thread.currentThread().equals(currentThread)) {
			lockedCount--;
		}
		if(lockedCount ==0){
			isLocked = false;
			notify();
		}
	}

}
