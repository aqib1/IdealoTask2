package com.idealo.product.exceptions;
/**
 * <p>
 * This is the custom exception class for invalid product
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
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
