package com.idealo.checkout.utils;
/**
 * <p>
 * This is the class for checkout application constants
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
public class AppConst {
    public static final String CHECKOUT_API_URI= "/checkout";
    public static final String CHECKOUT_CHECK = "/check";
    public static final String PRODUCT_GET_ALL = "/product/all";
    public static final String PRICING_RULES_APPLY_URI = "/pricing/rule";

    //Constant http status
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int BAD_REQUEST = 400;

    private AppConst() {

    }
}
