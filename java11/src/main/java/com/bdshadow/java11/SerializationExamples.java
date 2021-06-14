package com.bdshadow.java11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializationExamples {

    /**
     * During deserialization, the constructor of the class (or any static or instance blocks) is not executed.
     * However, if the super class does not implement Serializable, its constructor is called.
     * So here, BooBoo and Boo are not Serializable. So, their constructor is invoked.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Moo moo = new Moo();
        moo.moo = 20;
        FileOutputStream fos = new FileOutputStream("/tmp/moo1.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(moo);  //moo must be serializable
        os.close();

        System.out.println("______________________________________________");
        // What is the output of the next block
        FileInputStream fis = new FileInputStream("/tmp/moo1.ser");
        ObjectInputStream is = new ObjectInputStream(fis);
        Moo moo1 = (Moo) is.readObject();
        is.close();
        System.out.println(moo1.moo);
    }
}

class Boo {
    public Boo() {
        System.out.println("In Boo");
    }
}

class BooBoo extends Boo {
    public BooBoo() {
        System.out.println("In BooBoo");
    }
}

class Moo extends BooBoo implements Serializable {
    int moo = 10;

    {
        System.out.println("moo set to 10");
    }

    public Moo() {
        System.out.println("In Moo");
    }
}