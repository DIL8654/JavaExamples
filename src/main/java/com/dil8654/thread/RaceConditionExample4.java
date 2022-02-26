package com.dil8654.thread;

/**
 * @author DilankaM
 * @created 26/02/2022 - 22:35
 */
public class RaceConditionExample4 {
    public static void main(String[] args) {

        Countable counter1 = new BasicCounter();
        Countable counter2 = new BasicCounter();

        Thread thread1 = new Thread(getRunnable(counter1, counter2, "Thread 1 counter end at : "));
        Thread thread2 = new Thread(getRunnable(counter2,counter1, "Thread 2 counter end at : "));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Countable counter1,Countable counter2, String message) {
        return () -> {
            for (int i = 0; i < 1000000; i++) {
                counter1.incAndGet();
            }
            System.out.println(message + counter1.get());
            System.out.println(message + counter2.get());
        };
    }
}
