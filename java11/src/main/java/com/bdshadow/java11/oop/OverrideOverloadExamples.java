package com.bdshadow.java11.oop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OverrideOverloadExamples {
}


class Base {

    protected Base()  throws IOException {

    }

    public List<String> getUsualList() throws IOException {
        return null;
    }

    public  List<? extends IOException> getExtendsIntegerList(int id) {
        return null;
    }

    public  List<? super IOException> getSuperIntegerList(int id) {
        return null;
    }

}

class Derived extends Base {

    private Derived() throws Exception {
        super();
    }

    @Override
    public ArrayList<String> getUsualList() throws FileNotFoundException {
        return null;
    }

    @Override
    public List<? extends FileNotFoundException> getExtendsIntegerList(int id){
        return null;
    }

    @Override
    public List<? super Exception> getSuperIntegerList(int id){
        return null;
    }
}