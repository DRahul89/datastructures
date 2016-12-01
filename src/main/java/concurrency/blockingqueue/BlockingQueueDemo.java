package main.java.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		// BlockingQueue<String> commanQueue = new
		// ArrayBlockingQueue<String>(10);
		BlockingQueue<String> commanQueue = new LinkedBlockingDeque<String>();
		Producer producer = new Producer(commanQueue);
		Consumer consumer = new Consumer(commanQueue);
		new Thread(producer).start();
		new Thread(consumer).start();

	}

}
