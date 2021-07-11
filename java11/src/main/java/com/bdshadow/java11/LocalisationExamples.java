package com.bdshadow.java11;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class LocalisationExamples {
    public static void main(String[] args) {
        Locale l = Locale.getDefault();
        DateFormat df = DateFormat.getDateInstance();
        System.out.println(l.getCountry() + " " + df.format(new Date()));
    }
}
