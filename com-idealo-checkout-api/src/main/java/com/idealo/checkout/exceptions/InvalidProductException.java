package com.idealo.checkout.exceptions;

public class InvalidProductException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -7828995190089966930L;

    public InvalidProductException() {
    }

    public InvalidProductException(String err) {
        super(err);
    }

    public InvalidProductException(String err, Throwable e) {
        super(err, e);
    }
}
