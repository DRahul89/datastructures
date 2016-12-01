package main.java.concurrency.concurrentapi.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
	
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		ExchangerRunnable first = new ExchangerRunnable(exchanger,"A");
		ExchangerRunnable second = new ExchangerRunnable(exchanger, "B");
		ExchangerRunnable third = new ExchangerRunnable(exchanger, "C");
		ExchangerRunnable fourth = new ExchangerRunnable(exchanger, "D");
		new Thread(first,"first").start();
		//new Thread(second,"second").start();
		new Thread(third,"third").start();
		new Thread(fourth,"fourth").start();
	}

}
