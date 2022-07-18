package com.codingiscaring;

public class DoubleUtils {

    private DoubleUtils() {
    }

    public static String twoDecimalsFormat(Double value) {
        return String.format("%.2f", value);
    }
}
