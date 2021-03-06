package ConcurrentProgramming;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class CancellationWithFlag {

    //The thread sleeps for 1sec, so incrementing count to 5 will suffice to cancel the thread as requested
    public static void main(String[] args) {

        AtomicInteger count= new AtomicInteger();
        AtomicBoolean continueRunning=new AtomicBoolean(true);

        Thread hello = new Thread(() -> {
            while (continueRunning.get()) {
                System.out.println("Hello");
                try{
                    count.getAndIncrement();
                    Thread.sleep(1000);

                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                if(count.get() == 5){
                    continueRunning.set(false);
                    System.out.println(count.get());
                }
            }
        });
        hello.start();

    }

}
