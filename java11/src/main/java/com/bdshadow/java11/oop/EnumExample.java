package com.bdshadow.java11.oop;

import java.util.Arrays;

public class EnumExample {
    public static void main(String[] args) {
        System.out.println(Device.valueOf("PHONE"));
        System.out.println(Device.valueOf("PHONE").ordinal());
        Arrays.stream(Device.values()).forEach(System.out::print);

        // when added to TreeSet - enums are sorted by order of ordinal value;
    }
}

enum Device implements MyInterface{
    PHONE, TABLET;

    @Override
    public String toString() {
        return "Object " + this.name();
    }

    @Override
    public boolean isElectric() {
        return true;
    }
}

interface MyInterface {
    boolean isElectric();
}