package com.provys.common.exception;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents regular PROVYS exception - extends {@link ProvysBaseException} with supplied internal
 * name.
 */
public final class RegularException extends ProvysBaseException {

  private static final long serialVersionUID = -715640935829167916L;
  private final String nameNm;

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message, parameters and
   * cause. Note that the detail message associated with {@code cause} is not automatically
   * incorporated in this runtime exception's detail message.
   *
   * @param nameNm  is internal name of exception as registered in ERROR database object
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param params  is list of parameter and their values that can be embedded in error message
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method). (A @{code null} value is permitted, and indicates that the cause is
   *                nonexistent or unknown.)
   */
  public RegularException(String nameNm, String message, @Nullable Map<String, String> params,
      @Nullable Throwable cause) {
    super(nameNm + ": " + message, params, cause);
    this.nameNm = nameNm;
  }

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message and parameters.
   *
   * @param nameNm  is internal name of exception as registered in ERROR database object
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param params  is list of parameter and their values that can be embedded in error message
   */
  @SuppressWarnings("ParameterNameDiffersFromOverriddenParameter")
  public RegularException(String nameNm, String message, @Nullable Map<String, String> params) {
    this(nameNm, message, params, null);
  }

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message and cause. Note
   * that the detail message associated with {@code cause} is not automatically incorporated in this
   * runtime exception's detail message.
   *
   * @param nameNm  is internal name of exception as registered in ERROR database object
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()}
   *                method). (A {@code null} value is permitted, and indicates that the cause is
   *                nonexistent or unknown.)
   */
  @SuppressWarnings("ParameterNameDiffersFromOverriddenParameter")
  public RegularException(String nameNm, String message, @Nullable Throwable cause) {
    this(nameNm, message, Collections.emptyMap(), cause);
  }

  /**
   * Constructs a new PROVYS runtime exception with the specified detail message and cause.
   *
   * @param nameNm  is internal name of exception as registered in ERROR database object
   * @param message the detail message; displayed to user if translations via database are not
   *                available. Message is prefixed with internal name
   */
  public RegularException(String nameNm, String message) {
    this(nameNm, message, (Throwable) null);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RegularException)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    RegularException that = (RegularException) o;
    return Objects.equals(nameNm, that.nameNm);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (nameNm != null ? nameNm.hashCode() : 0);
    return result;
  }

  @Override
  public String getNameNm() {
    return nameNm;
  }
}
