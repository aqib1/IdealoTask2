package com.idealo.pricing.rules.exceptions;

public class InvalidRuleRequestException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -2972797190799966939L;

    public InvalidRuleRequestException() {
    }

    public InvalidRuleRequestException(String err) {
        super(err);
    }

    public InvalidRuleRequestException(String err, Throwable e) {
        super(err, e);
    }
}
