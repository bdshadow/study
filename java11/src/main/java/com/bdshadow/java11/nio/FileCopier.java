package com.bdshadow.java11.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * What will the following code print if file test1.txt exists but test2.txt doesn't exist?
 *
 * ANSWER
 * It will print unable to copy file but test2.txt will contain the same data as test1.txt
 */
public class FileCopier {

    public static void copy1(Path p1, Path p2) throws Exception {
        Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
    }
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("test1.txt");
        Path p2  = Paths.get("test2.txt");
        copy1(p1, p2);
        if(Files.isSameFile(p1, p2)){
            System.out.println("file copied");
        }else{
            System.out.println("unable to copy file");
        }
    }
}