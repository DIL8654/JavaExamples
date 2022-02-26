package com.dil8654.thread;

/**
 * @author DilankaM
 * @created 26/02/2022 - 21:29
 */
public class SynchronizedCounter implements Countable {
  private long count = 0;

  public long incAndGet() {
    synchronized (this) {
      this.count++;
      return this.count;
    }
  }

  public long get() {
    synchronized (this) {
      return this.count;
    }
  }
}
