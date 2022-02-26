package com.dil8654.thread;

/**
 * @author DilankaM
 * @created 26/02/2022 - 22:28
 */
public class RaceConditionExample3 {
    public static void main(String[] args) {

        Countable counter = new SynchronizedCounter();

        Thread thread1 = new Thread(getWriteRunnable(counter, "Thread 1 counter end at : "));
        Thread thread2 = new Thread(getReadRunnable(counter, "Thread 2 counter end at : "));

        thread1.start();
        thread2.start();
    }

    private static Runnable getWriteRunnable(Countable counter, String message) {
        return () -> {
            for (int i = 0; i < 1000000; i++) {
                counter.incAndGet();
            }
            System.out.println(message + counter.get());
        };
    }

    private static Runnable getReadRunnable(Countable counter, String message) {
        return () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(message + counter.get());
            }

        };
    }
}
