package com.bdshadow.java11;

public class StringBuilderExamples {

    public static void main(String[] args) {
        String s = "abc-123";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.append("def", 1, 3));
        System.out.println(sb.insert(3, "def", 1, 3));
        System.out.println(sb.replace(0, 1, "HA"));
        System.out.println(sb.substring(0, 2)); // returns String!!!
    }
}
