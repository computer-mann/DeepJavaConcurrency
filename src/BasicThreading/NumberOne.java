package BasicThreading;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumberOne extends Thread{
    private int counter;
    private final AtomicBoolean continueRunning=new AtomicBoolean(true);

    private void increment(){
        counter++;
    }

    @Override
    public void run() {
        while (continueRunning.get()) {
            try {
                increment();
                System.out.println(counter);

                Thread.sleep(1000);
            }catch (InterruptedException e){
               // Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
                continueRunning.set(false);
            }
        }
    }
}
