package ConcurrentProgramming;

import java.util.concurrent.atomic.AtomicInteger;

public class CancelWithInterrupt {

    public static void main(String[] args) {

        AtomicInteger count= new AtomicInteger();
        long now=System.currentTimeMillis();
        Thread hello = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("Hello");
                try{
                    count.getAndIncrement();
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                if(count.get() == 5){
                   Thread.currentThread().interrupt();
                }
            }
        });
        hello.start();

    }
}
