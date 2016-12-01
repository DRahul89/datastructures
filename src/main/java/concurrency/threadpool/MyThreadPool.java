package main.java.concurrency.threadpool;

import java.util.ArrayList;
import java.util.List;

import main.java.concurrency.blockingqueue.BlockingQueue;

public class MyThreadPool {

	private boolean isStopped;

	private BlockingQueue<Runnable> tasks;

	private List<PoolThread> threads;

	public MyThreadPool(final int maxTaskCount, final int maxThreadCount) {

		this.tasks = new BlockingQueue<Runnable>(maxTaskCount);
		threads = new ArrayList<PoolThread>(maxThreadCount);
		for (int i = 0; i < maxThreadCount; i++) {
			threads.add(new PoolThread(tasks));
		}
		for (PoolThread thread : threads) {
			thread.start();
		}
	}

	public synchronized void execute(final Runnable task) throws Exception {
		if (isStopped)
			throw new IllegalStateException("thread pool is stoped");
		tasks.enQueue(task);
	}
	
	public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
           thread.doStop();
        }
    }

}
