package main.java.concurrency.executorservice;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceWithRunnable {

	Runnable tasks;

	List<Callable<String>> futureTasks;

	public ExecutorServiceWithRunnable(final Runnable tasks,
			final List<Callable<String>> futuretasks) {
		this.tasks = tasks;
		this.futureTasks = futuretasks;
	}

	public void executeTaskWithCashedPool() throws InterruptedException {
		ExecutorService cashedThreadPool = Executors.newCachedThreadPool();
		cashedThreadPool.execute(tasks);
		List<Future<String>> results = cashedThreadPool.invokeAll(futureTasks);
		cashedThreadPool.shutdown();

	}

	public void executeTaskWithSinglePool() throws InterruptedException {
		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		singleThreadPool.execute(tasks);
		List<Future<String>> results = singleThreadPool.invokeAll(futureTasks);
		singleThreadPool.shutdown();

	}

	public void executeTaskWithFixedPool() throws InterruptedException {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		fixedThreadPool.execute(tasks);
		List<Future<String>> results = fixedThreadPool.invokeAll(futureTasks);
		fixedThreadPool.shutdown();

	}

	public void withThreadPoolExecutor() throws InterruptedException {
		int corePoolSize = 5;
		int maxPoolSize = 10;
		long keepAliveTime = 5000;

		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
				corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

		threadPoolExecutor.execute(tasks);
		List<Future<String>> results = threadPoolExecutor
				.invokeAll(futureTasks);
		threadPoolExecutor.shutdown();
	}

	public void scheduleRunnableWithExecutor() throws InterruptedException {
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(5);
		ScheduledFuture<?> scheduledFuture = scheduledExecutorService
				.scheduleAtFixedRate(tasks, 5, 2, TimeUnit.SECONDS);
		scheduledExecutorService.shutdown();

	}

	@SuppressWarnings("unchecked")
	public void scheduleCallableWithExecutor() throws InterruptedException {
		ScheduledExecutorService scheduledExecutorService = Executors
				.newScheduledThreadPool(5);
		@SuppressWarnings("rawtypes")
		ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(
				new Callable() {
					public Object call() throws Exception {
						System.out.println("Executed!");
						return "Called!";
					}
				}, 5, TimeUnit.SECONDS);
		scheduledExecutorService.shutdown();

	}

}
