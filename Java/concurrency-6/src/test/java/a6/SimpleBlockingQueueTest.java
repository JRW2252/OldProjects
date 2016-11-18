package a6;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class SimpleBlockingQueueTest {
	private static final int NUM_THREADS = 6;

	private static class BlockingThread extends Thread {
		private SimpleBlockingQueue<Integer> queue;
		private boolean wasInterrupted = false;
		private boolean reachedAfterGet = false;
		private boolean throwableThrown;

		public BlockingThread(SimpleBlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				try {
					queue.get();
				} catch (InterruptedException e) {
					wasInterrupted = true;
				}
				reachedAfterGet = true;
			} catch (Throwable t) {
				throwableThrown = true;
			}
		}

		public boolean isWasInterrupted() {
			return wasInterrupted;
		}

		public boolean isReachedAfterGet() {
			return reachedAfterGet;
		}

		public boolean isThrowableThrown() {
			return throwableThrown;
		}
	}

	@Test
	public void testPutOnEmptyQueueBlocks() throws InterruptedException {
		final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
		BlockingThread blockingThread = new BlockingThread(queue);
		blockingThread.start();
		Thread.sleep(5000);
		assertThat(blockingThread.isReachedAfterGet(), is(false));
		assertThat(blockingThread.isWasInterrupted(), is(false));
		assertThat(blockingThread.isThrowableThrown(), is(false));
		queue.put(42);
		Thread.sleep(1000);
		assertThat(blockingThread.isReachedAfterGet(), is(true));
		assertThat(blockingThread.isWasInterrupted(), is(false));
		assertThat(blockingThread.isThrowableThrown(), is(false));
		blockingThread.join();
	}

	@Test
	public void testParallelInsertionAndConsumption() throws InterruptedException, ExecutionException {
		final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
		ExecutorService threadPool = Executors.newFixedThreadPool(NUM_THREADS);
		final CountDownLatch latch = new CountDownLatch(NUM_THREADS);
		List<Future<Integer>> futuresPut = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 3; i++) {
			Future<Integer> submit = threadPool.submit(new Callable<Integer>() {
				public Integer call() {
					int sum = 0;
					for (int i = 0; i < 1000; i++) {
						int nextInt = ThreadLocalRandom.current().nextInt(100);
						queue.put(nextInt);
						sum += nextInt;
						System.out.println("put " + nextInt);
						Thread.yield();
					}
					latch.countDown();
					return sum;
				}
			});
			futuresPut.add(submit);
		}
		List<Future<Integer>> futuresGet = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 3; i++) {
			Future<Integer> submit = threadPool.submit(new Callable<Integer>() {
				public Integer call() {
					int count = 0;
					try {
						for (int i = 0; i < 1000; i++) {
							Integer got = queue.get();
							count += got;
							System.out.println("get " + got);
						}
					} catch (InterruptedException e) {

					}
					latch.countDown();
					return count;
				}
			});
			futuresGet.add(submit);
		}
		latch.await();
		int sumPut = 0;
		for (Future<Integer> future : futuresPut) {
			sumPut += future.get();
		}
		int sumGet = 0;
		for (Future<Integer> future : futuresGet) {
			sumGet += future.get();
		}
		assertThat(sumPut, is(sumGet));
	}
}
