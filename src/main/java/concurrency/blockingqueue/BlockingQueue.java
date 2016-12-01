package main.java.concurrency.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<E> {

	private int limit = 10;

	private Queue<E> blockingQueue = new LinkedList<E>();

	public BlockingQueue(final int limit) {
		this.limit = limit;
	}

	public synchronized void enQueue(final E data) throws InterruptedException {
		while (blockingQueue.size() == limit) {
			wait();
		}
		if (blockingQueue.size() == 0) {
			notifyAll();
		}
		blockingQueue.add(data);

	}

	public synchronized E deQueue() throws InterruptedException {
		while (blockingQueue.size() == 0) {
			wait();
		}
		if (blockingQueue.size() == limit) {
			notifyAll();
		}

		return blockingQueue.poll();

	}

}
