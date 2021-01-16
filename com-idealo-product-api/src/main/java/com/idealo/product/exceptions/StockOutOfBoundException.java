package com.idealo.product.exceptions;

public class StockOutOfBoundException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -3888371918279966939L;

    public StockOutOfBoundException() {
    }

    public StockOutOfBoundException(String err) {
        super(err);
    }

    public StockOutOfBoundException(String err, Throwable e) {
        super(err, e);
    }
}
