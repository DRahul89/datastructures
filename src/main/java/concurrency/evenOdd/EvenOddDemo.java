package main.java.concurrency.evenOdd;

public class EvenOddDemo {

	public static void main(String[] args) {
		PrintEvenOdd printEvenOdd = new PrintEvenOdd();
		EvenThread evenThread = new EvenThread(printEvenOdd);
		OddThread oddThread = new OddThread(printEvenOdd);
		Thread even = new Thread(evenThread);
		Thread odd = new Thread(oddThread);
		even.setName("even");
		odd.setName("odd");
		even.start();
		odd.start();

	}

}
