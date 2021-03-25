package com.provys.common.exception;

import java.util.Collections;
import java.util.Map;

/**
 * Interface represents PROVYS extension of Exception. It allows exceptions to pass information
 * about error code and internal name, that can be subsequently displayed by service API.
 */
@SuppressWarnings("NonExceptionNameEndsWithException")
public interface ProvysException {

  /**
   * Get internal name of Exception. Used for mapping to registered ERROR
   *
   * @return internal name of exception
   */
  String getNameNm();

  /**
   * Http status code, associated with the exception. Fixed as server error in this ancestor, can be
   * modified if some exception should return different http status code when caught in web
   * service.
   *
   * @return http status code, defaults to 500 (internal server error)
   */
  default int getHttpStatus() {
    return 500;
  }

  /**
   * Retrieve map of parameters containing additional information related to exception.
   *
   * @return empty map in this default implementation
   */
  default Map<String, String> getParams() {
    return Collections.emptyMap();
  }

  /**
   * Returns the detail message string of this throwable. IS non-null for all PROVYS exceptions.
   *
   * @return the detail message string of this {@code Throwable} instance
   */
  String getMessage();

  /**
   * Provides programmatic access to the stack trace information printed by {@link
   * Throwable#printStackTrace()}.  Returns an array of stack trace elements, each representing one
   * stack frame. The zeroth element of the array (assuming the array's length is non-zero)
   * represents the top of the stack, which is the last method invocation in the sequence.
   * Typically, this is the point at which this throwable was created and thrown. The last element
   * of the array (assuming the array's length is non-zero) represents the bottom of the stack,
   * which is the first method invocation in the sequence.
   *
   * <p>Some virtual machines may, under some circumstances, omit one
   * or more stack frames from the stack trace.  In the extreme case, a virtual machine that has no
   * stack trace information concerning this throwable is permitted to return a zero-length array
   * from this method.  Generally speaking, the array returned by this method will contain one
   * element for every frame that would be printed by {@code printStackTrace}.  Writes to the
   * returned array do not affect future calls to this method.
   *
   *  @return an array of stack trace elements representing the stack trace pertaining to this
   *     throwable.
   */
  StackTraceElement[] getStackTrace();
}
