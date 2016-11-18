public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal threadLocal = new ThreadLocal();
    private final int value;
 
    public ThreadLocalExample(int value) {
        this.value = value;
    }
 
    @Override
    public void run() {
        threadLocal.set(value);
        Integer integer = (Integer) threadLocal.get();
        System.out.println("[" + Thread.currentThread().getName() + "]: " + integer);
    }
 
    public static void main(String[] args) throws InterruptedException {
        Thread threads[] = new Thread[15];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ThreadLocalExample(i), "thread-" + Thread.currentThread().getId());
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
            System.out.println("Joining " + Thread.currentThread().getName() );
        }
    }
}