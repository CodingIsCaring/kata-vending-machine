package com.codingiscaring;

import java.text.NumberFormat;
import java.util.Locale;

public class DoubleUtils {

    private DoubleUtils() {
    }

    public static String twoDecimalsFormat(Double value) {
        Locale locale = new Locale("EN", "UK");
        NumberFormat formatter = NumberFormat.getInstance(locale);
        formatter.setMinimumFractionDigits(2);
        return formatter.format(value);
    }
}
