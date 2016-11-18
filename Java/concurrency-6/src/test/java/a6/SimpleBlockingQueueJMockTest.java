package a6;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.jmock.lib.concurrent.Blitzer;
import org.junit.Test;

public class SimpleBlockingQueueJMockTest {
	Blitzer blitzer = new Blitzer(25000, 6);

	@Test
	public void stressTest() throws InterruptedException {
		final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
		blitzer.blitz(new Runnable() {
			public void run() {
				try {
					queue.put(42);
					queue.get();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		assertThat(queue.getSize(), is(0));
	}
}
