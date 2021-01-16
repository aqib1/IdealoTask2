package com.idealo.pricing.rules.exceptions;

public class InvalidRuleTypeException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -1972797190799966939L;
    public InvalidRuleTypeException() {
    }

    public InvalidRuleTypeException(String err) {
        super(err);
    }

    public InvalidRuleTypeException(String err, Throwable e) {
        super(err, e);
    }
}
