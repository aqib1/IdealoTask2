package com.idealo.checkout.exceptions;

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
