package main.java.concurrency.concurrentapi.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * A class with example of count down latch
 *
 */
public class CountDownLatchExample {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);
		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

		cacheService.start(); // separate thread will initialize CacheService
		alertService.start(); // another thread for AlertService initialization
		validationService.start();

		try {
			latch.await();
			System.out.println("All services are up");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
