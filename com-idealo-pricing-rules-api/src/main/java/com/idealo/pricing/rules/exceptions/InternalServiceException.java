package com.idealo.pricing.rules.exceptions;

public class InternalServiceException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -8772797190799966939L;

    public InternalServiceException() {
    }

    public InternalServiceException(String err) {
        super(err);
    }

    public InternalServiceException(String err, Throwable e) {
        super(err, e);
    }
}
