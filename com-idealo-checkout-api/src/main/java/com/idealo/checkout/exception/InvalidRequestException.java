package com.idealo.checkout.exception;
/**
 * <p>
 * This is the custom exception class for invalid request
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
public class InvalidRequestException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -7888897190799966939L;

    public InvalidRequestException() {
    }

    public InvalidRequestException(String err) {
        super(err);
    }

    public InvalidRequestException(String err, Throwable e) {
        super(err, e);
    }
}
