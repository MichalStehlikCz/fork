package com.provys.common.exception;

import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents internal exception. This exception can be used in internal checks, where other code
 * should ensure exception is not thrown. It should never be used for validation of external data
 */
public final class InternalException extends ProvysBaseException {

  private static final String NAME_NM = "JAVA_INTERNAL_EXCEPTION";
  private static final long serialVersionUID = 1719485415644421475L;

  /**
   * Constructs a new PROVYS internal exception with the specified detail message, parameters and
   * cause. Note that the detail message associated with {@code cause} is not automatically
   * incorporated in this runtime exception's detail message.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param params  is list of parameter and their values that can be embedded in error message
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method). (A @{code null} value is permitted, and indicates that the cause is
   *                nonexistent or unknown.)
   */
  public InternalException(String message, @Nullable Map<String, String> params,
      @Nullable Throwable cause) {
    super(Objects.requireNonNull(message), params, cause);
  }

  /**
   * Constructs a new PROVYS internal exception with the specified detail message and parameters.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param params  is list of parameter and their values that can be embedded in error message
   */
  public InternalException(String message, @Nullable Map<String, String> params) {
    this(message, params, null);
  }

  /**
   * Constructs a new PROVYS internal exception with the specified detail message and cause. Note
   * that the detail message associated with {@code cause} is not automatically incorporated in this
   * runtime exception's detail message.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method). (A @{code null} value is permitted, and indicates that the cause is
   *                nonexistent or unknown.)
   */
  public InternalException(String message, @Nullable Throwable cause) {
    this(message, null, cause);
  }

  /**
   * Constructs a new PROVYS internal exception with the specified detail message.
   *
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   */
  public InternalException(String message) {
    this(message, (Throwable) null);
  }

  @Override
  public String getNameNm() {
    return NAME_NM;
  }
}
