package com.provys.common.exception;

import static org.checkerframework.checker.nullness.util.NullnessUtil.castNonNull;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Common ancestor for exceptions thrown by PROVYS code. Makes it easier to track all defined
 * exceptions, adds mapping to PROVYS registered errors.
 *
 * @author stehlik
 */
@SuppressWarnings("AbstractClassExtendsConcreteClass")
public abstract class ProvysBaseException extends RuntimeException implements ProvysException {

  private static final long serialVersionUID = 7155232755615842135L;

  private final Map<String, String> params;

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message, parameters and
   * cause. Note that the detail message associated with {@code cause} is not automatically
   * incorporated in this runtime exception's detail message.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param params  are additional parameters for exception. Parameters are saved and can be
   *                retrieved, e.g. when creating (translated) message for given exception
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method). (A @{code null} value is permitted, and indicates that the cause is
   *                nonexistent or unknown.)
   */
  protected ProvysBaseException(String message, @Nullable Map<String, String> params,
      @Nullable Throwable cause) {
    super(message, cause);
    if (params == null) {
      this.params = Collections.emptyMap();
    } else {
      this.params = Map.copyOf(params);
    }
  }

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message and parameters.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param params  are additional parameters for exception. Parameters are saved and can be
   *                retrieved, e.g. when creating (translated) message for given exception
   */
  protected ProvysBaseException(String message, @Nullable Map<String, String> params) {
    this(message, params, null);
  }

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message and cause.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method). (A @{code null} value is permitted, and indicates that the cause is
   *                nonexistent or unknown.)
   */
  protected ProvysBaseException(String message, Throwable cause) {
    this(message, null, cause);
  }

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available
   */
  protected ProvysBaseException(String message) {
    this(message, null, null);
  }

  @Override
  public Map<String, String> getParams() {
    return params;
  }

  @Override
  public String getMessage() {
    return castNonNull(super.getMessage()); // We do not allow creation without message
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProvysBaseException)) {
      return false;
    }
    ProvysBaseException that = (ProvysBaseException) o;
    return Objects.equals(params, that.params);
  }

  @Override
  public int hashCode() {
    return params != null ? params.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "ProvysException{"
        + "params=" + params
        + ", " + super.toString() + '}';
  }
}
