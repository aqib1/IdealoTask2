package com.idealo.checkout.exception;

public class BadRequestException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -2972797190799966939L;

    public BadRequestException() {
    }

    public BadRequestException(String err) {
        super(err);
    }

    public BadRequestException(String err, Throwable e) {
        super(err, e);
    }
}
