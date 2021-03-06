package ConcurrentProgramming;

public class HelloThread {
    public static void main(String[] args) {
        Thread hello = new Thread(() -> {
            while (true) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore){}
            }
        });
        Thread hello2 = new Thread(() -> {
            while (true) {
                System.out.println("Hello");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignore){}
            }
        });

        hello.start();
        hello2.start();

        int counter=0;
        while(counter < 5){
            System.out.println(counter);
            counter++;
        }

        int counter2=0;
        while(counter2 < 5){
            System.out.println(counter);
            counter2++;
        }
    }
}