package com.dil8654.thread;

/**
 * @author DilankaM
 * @created 26/02/2022 - 16:55
 */
public class BasicCounter implements Countable {
  private long count = 0;

  public long incAndGet() {

    this.count++;
    return this.count;
  }

  public long get() {
    return this.count;
  }
}
