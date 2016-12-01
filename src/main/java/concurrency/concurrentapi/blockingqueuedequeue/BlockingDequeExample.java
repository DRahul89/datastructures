package main.java.concurrency.concurrentapi.blockingqueuedequeue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * This class will contain the examples of blocking dequeue api of concurrent
 * package
 *
 */
public class BlockingDequeExample {

	private static BlockingDeque<String> blockingDeuqe = null;

	/**
	 * 
	 * linked blockingdeuqe
	 */
	public static void linkedBlockingDequeExample() throws InterruptedException {
		blockingDeuqe = new LinkedBlockingDeque<String>();

		blockingDeuqe.addFirst("1");
		blockingDeuqe.addLast("2");

		System.out.println(blockingDeuqe.takeLast());
		System.out.println(blockingDeuqe.takeFirst());
	}

	public static void main(String[] args) {
		try {
			linkedBlockingDequeExample();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
