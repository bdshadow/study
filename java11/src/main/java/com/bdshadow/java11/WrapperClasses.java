package com.bdshadow.java11;

import java.util.Arrays;
import java.util.List;

public class WrapperClasses {

    public static void main(String[] args){
        Integer dataWrapper = new Integer(5);
        Integer value = wiggler(dataWrapper);
        System.out.println(dataWrapper+value);

        System.out.println("_____________________________");
        List<Double> dList = Arrays.asList(10.0, 12.0);
        dList.stream().forEach(x->{ x = x+10; });
        dList.stream().forEach(d->System.out.println(d));

        List<StringBuilder> sList = Arrays.asList(new StringBuilder("a"), new StringBuilder("aa"));
        sList.stream().forEach(x->x.append("b"));
        sList.stream().forEach(x->System.out.println(x));
    }

    public static Integer wiggler(Integer x){
        Integer y = x + 10;
        x++;
        System.out.println(x);
        return y;
    }
}
