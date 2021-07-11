package com.bdshadow.java11;

import java.io.IOException;

public class CrazyMathExamples {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        a += (a = 4);
        b = b + (b = 5);
        System.out.println(a + ",  " + b);

        int y = 1;
        y += (y=4) + (y=7) + y;
        System.out.println("y=" + y);

        int z = 1;
        z += (z=4) + (z=7 + z);
        System.out.println("z=" + z);
    }
}
