package BasicThreading;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumberTwo implements Runnable{
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
                if(counter > 10){
                    continueRunning.set(false);
                    throw new InterruptedException();

                }
            }catch (InterruptedException e){
               // continueRunning.set(false);
                System.out.println(e.getMessage() + " :The program has terminated " );

            }
        }
    }

    //Number three
    public int getCounter(){
        return counter;
    }
}
