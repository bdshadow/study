package com.bdshadow.java11.impl;

import com.bdshadow.java11.api.Print;

public class PrintImpl implements Print {

    @Override
    public void print() {
        System.out.println("Hello world");
    }
}
