package com.dil8654.thread;


/**
 * @author DilankaM
 * @created 26/02/2022 - 16:55
 */
public class RaceConditionExample {
  public static void main(String[] args) {
    Countable counter = new BasicCounter();


    Thread thread1 = new Thread(getRunnable(counter, "Thread 1 counter end at : "));
    Thread thread2 = new Thread(getRunnable(counter, "Thread 2 counter end at : "));

    thread1.start();
    thread2.start();
  }

  private static Runnable getRunnable(Countable counter, String message) {
    return () -> {
      for (int i = 0; i < 1000000; i++) {
        counter.incAndGet();
      }
      System.out.println(message + counter.get());
    };
  }
}
