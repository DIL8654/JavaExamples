package com.dil8654.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DilankaM
 * @created 26/02/2022 - 22:51
 */
public class RaceConditionExample5 {

  public static void main(String[] args) {

    Map<String, String> sharedResourceMap = new ConcurrentHashMap<>();

    Thread thread1 = new Thread(getRunnable(sharedResourceMap));
    Thread thread2 = new Thread(getRunnable(sharedResourceMap));

    thread1.start();
    thread2.start();
  }

  private static Runnable getRunnable(Map<String, String> sharedResourceMap) {
    return () -> {
      for (int i = 0; i < 1000000; i++) {
        if (sharedResourceMap.containsKey("key")) {
          String val = sharedResourceMap.remove("key");
          if (val == null) {
            System.out.println("iteration index + " + i + " , key is: " + val);
          }
        } else {
          sharedResourceMap.put("key", "my value");
        }
      }
      ;
    };
  }
}
