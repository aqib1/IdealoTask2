package com.idealo.checkout.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * This is the class for checkout application utilities
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
public class AppUtils {

    public static Map<String, Long> listToMapByCount(List<String> values){
        return values.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
