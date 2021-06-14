package com.bdshadow.java11;

import java.util.ArrayList;

class Student {
}

public class VarDeclarations {

    // var students = new ArrayList<Student>();
    //// var declaration is allowed only inside method body and for loop declarations.
    //// It is not allowed to declare class/instance fields, method parameters, or method return types.

    public static void main(String[] args) {
        var student = new Student();
        var allStudents = new ArrayList<>();
        allStudents.add(student);
        for (var s : allStudents) {
            System.out.println(s);
        }

        //// Observe that new ArrayList<>() means the type of the objects in the list is java.lang.Object.
        //// So, you cannot assign an object retrieved from this list to a Student variable.
        //// Had it been new ArrayList<Student>(), the assignment would have been valid.
        // Student s2 = allStudents.get(0);

        var var = "what?";

        final var a = "";

        //// 'var' is not allowed in a compound declaration
        //var i1 = 0, i2 =0;

        var i1 = 0;
        var i2 = i1 = 1;

        int q = 1, w = i1 = 100;
    }
}
