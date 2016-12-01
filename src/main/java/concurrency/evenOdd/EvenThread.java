package main.java.concurrency.evenOdd;

public class EvenThread implements Runnable {

	private PrintEvenOdd printEvenOdd;

	public EvenThread(final PrintEvenOdd printEvenOdd) {
		this.printEvenOdd = printEvenOdd;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			printEvenOdd.printEven();

		}

	}

}
