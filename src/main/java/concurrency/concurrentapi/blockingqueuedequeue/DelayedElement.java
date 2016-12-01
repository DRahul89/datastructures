package main.java.concurrency.concurrentapi.blockingqueuedequeue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {

	private int delayTime;

	@Override
	public int compareTo(Delayed delayed) {
		DelayedElement delayedElement = null;
		if (delayed instanceof DelayedElement)
			delayedElement = (DelayedElement) delayed;
		return this.getDelayTime() - delayedElement.getDelayTime();
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return -2 * delayTime ;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}

}
