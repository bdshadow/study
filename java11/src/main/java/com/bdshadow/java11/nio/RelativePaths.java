package com.bdshadow.java11.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePaths {
    public static void main(String[] args) {
        Path p1 = Paths.get("/personal/./photos/../readme.txt");
        Path p2 = Paths.get("/personal/index.html");
        Path p3 = p1.relativize(p2);
        System.out.println(p3);

        Path p4 = Paths.get("/code/java/PathTest.java");
        System.out.println(p4.getRoot());
        System.out.println(p4.getName(0));
        System.out.println(p4.getName(1));
        System.out.println(p4.getName(2));

        Path p5 = Paths.get("c:\\temp\\test.txt");
        Path p6 = Paths.get("report.pdf");
        System.out.println(p5.resolve(p6));
    }
}
