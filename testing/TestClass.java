package com.justinuy.playground.testing;

/**
 * @author Justin Uy
 * @version 0.1
 * @since 0.1
 */
public abstract class TestClass {

  protected Test[] tests;

  protected TestClass(Test[] tests) {
    this.tests = tests;
  }

  public Test[] getTests() {
    return this.tests;
  }
}
