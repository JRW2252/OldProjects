
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InterruptExample implements Runnable {
 
    public void run() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
        }
        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        while(!Thread.interrupted()) {
            
        }
        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        System.out.println("["+Thread.currentThread().getName()+"] Interrupted for the second time.");
    }
 
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new InterruptExample(), "myThread");
        myThread.start();
         
        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);
         
        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();
         
        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);
         
        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();
    }
}