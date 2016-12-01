package main.java.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<String> queue;

	public Producer(final BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {
				System.out.println("producing an element abc:" + counter);
				queue.put("abc" + counter);
				counter++;
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
