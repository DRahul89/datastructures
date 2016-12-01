package main.java.concurrency.threadpool;

import main.java.concurrency.blockingqueue.BlockingQueue;

public class PoolThread extends Thread {

	private BlockingQueue<Runnable> blockingQueue;

	private Boolean isStop;

	public PoolThread(final BlockingQueue<Runnable> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		while (!isStop) {
			try {
				Runnable task = blockingQueue.deQueue();
				task.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public synchronized void doStop() {
		isStop = true;
		this.interrupt();

	}

	public synchronized boolean isStopped() {
		return isStop;
	}

}
