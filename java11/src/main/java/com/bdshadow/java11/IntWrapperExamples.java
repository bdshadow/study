package com.bdshadow.java11;

public class IntWrapperExamples {

    /**
     * 2.val1++ uses post-increment operator, which implies that you note down the current value of val1,
     * increment it, and then pass the original noted down value to the method testInts.
     * Thus, the reference value of Integer 5 is passed to testInts.
     * But val1 is set to point to a new Integer object containing 6.
     * ++val2 uses pre-increment operator, which implies that you first increment val2 and then pass the incremented value.
     * Therefore, val2 is incremented to 10 and then 10 is passed to the method testInts.
     */
    public static void testInts(Integer obj, int var) {
        obj = var++;
        obj++;
    }

    public static void main(String[] args) {
        Integer val1 = new Integer(5);
        int val2 = 9;
        testInts(val1++, ++val2);
        System.out.println(val1 + " " + val2);
    }
}
