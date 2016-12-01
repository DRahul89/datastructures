package main.java.concurrency.concurrentapi.blockingqueuedequeue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 
 * This class will contain the examples of blocking queue api of concurrent
 * package
 *
 */
public class BlockingQueueExamples {

	private static BlockingQueue<String> blockingQueue = null;

	/**
	 * 
	 * Bounded blockingqueue
	 */
	public static void arrayBlockingQueueExample() throws InterruptedException {
		blockingQueue = new ArrayBlockingQueue<>(10);
		blockingQueue.put("abc");
		System.out.println(blockingQueue.take());
	}

	/**
	 * 
	 * delayed blockingqueue element must implement {@link Delayed} interface
	 * and maintain in the order comprator provide and next element can be fetch
	 * only after a particular time
	 */
	public static void delayedBlockingQueueExample() throws InterruptedException {
		DelayQueue<DelayedElement> blockingQueue = new DelayQueue<>();
		DelayedElement delayedElement = new DelayedElement();
		delayedElement.setDelayTime(2);
		blockingQueue.put(delayedElement);
		System.out.println(blockingQueue.take().getDelayTime());
	}

	/**
	 * 
	 * linked blockingqueue both boubded and unbounded
	 */
	public static void linkBlockingQueueExample() throws InterruptedException {
		blockingQueue = new LinkedBlockingQueue<>();
		blockingQueue.put("abc");
		System.out.println(blockingQueue.take());
		blockingQueue = new LinkedBlockingQueue<>(1);
		blockingQueue.put("abc");
		blockingQueue.put("ghe");
		System.out.println(blockingQueue.take());
	}

	/**
	 * 
	 * priority blockingqueue element ordering based on coparator implementation
	 */
	public static void priorityBlockingQueueExample() throws InterruptedException {
		blockingQueue = new PriorityBlockingQueue<>();
		blockingQueue.put("abc");
		System.out.println(blockingQueue.take());
		System.out.println(blockingQueue.take());
	}

	/**
	 * 
	 * synchronous blockingqueue single element queue
	 */
	public static void synchronouseBlockingQueueExample() throws InterruptedException {
		blockingQueue = new SynchronousQueue<>();
		Thread another = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println(blockingQueue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		another.start();
		blockingQueue.put("abc");

	}

	public static void main(String[] args) {
		try {
			// arrayBlockingQueueExample();
			// delayedBlockingQueueExample();
			// linkBlockingQueueExample();
			// priorityBlockingQueueExample();
			synchronouseBlockingQueueExample();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
