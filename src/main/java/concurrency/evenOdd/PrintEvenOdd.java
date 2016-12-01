package main.java.concurrency.evenOdd;

/**
 * 
 * This class will print even and odd
 *
 */
public class PrintEvenOdd {

	private boolean isEvenTurn = false;

	private int count = 1;

	public synchronized void printEven() {
		while (!isEvenTurn) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		System.out.println("Printing thread Name"
				+ Thread.currentThread().getName() + " " + count++);
		isEvenTurn = false;
		notify();
	}

	public synchronized void printOdd() {
		while (isEvenTurn) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		System.out.println("Printing thread Name"
				+ Thread.currentThread().getName() + " " + count++);
		isEvenTurn = true;
		notify();

	}

}
