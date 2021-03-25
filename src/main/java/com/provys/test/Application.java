package com.provys.test;

import org.checkerframework.checker.nullness.qual.Nullable;

public final class Application {

  @Nullable Integer value;

  public Application() {
  }

  /**
   * Value of field value.
   *
   * @return value of field value
   */
  public @Nullable Integer getValue() {
    return value;
  }

  /**
   * Set value of field value.
   *
   * @param value the new value to be set
   * @return self to enable fluent build
   */
  public Application setValue(Integer value) {
    this.value = value;
    return this;
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
