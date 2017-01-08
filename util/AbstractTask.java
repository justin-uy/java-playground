package com.justinuy.playground.util;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractTask implements Runnable {

  protected String name;
  protected int id;

  public AbstractTask(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public abstract void onStart();

  public abstract void onSuccess();

  public abstract void onFail(RuntimeException e);

  public abstract void runTask();

  @Override
  public final void run() {
      this.onStart();
      try {
        this.runTask();
        this.onSuccess();
      } catch (RuntimeException e) {
        this.onFail(e);
      }
  }
}
