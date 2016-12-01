package main.java.concurrency.concurrentapi.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {

	private Exchanger<String> exchanger;

	private String value;

	public ExchangerRunnable(final Exchanger<String> exchanger, final String value) {
		this.exchanger = exchanger;
		this.value = value;
	}

	@Override
	public void run() {
		try {
			String oldVal = this.value;
			String exchengedVal = exchanger.exchange(oldVal);
			System.out.println("exchanger exchange the value" + oldVal + "with new val " + exchengedVal + "by thread "
					+ Thread.currentThread());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
