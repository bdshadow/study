### Exception Handling

1. The program ends with `ExceptionInInitializerError` because any exception thrown in a static block is wrapped into `ExceptionInInitializerError` and then that `ExceptionInInitializerError` is thrown. Remember that a static or instance initializer can only throw a `RuntimeException`.

2. You cannot override a non-static method with a static method and vice versa. (A default method is a non-static method.) You can, however, redeclare a static method of a super interface as a default method in the sub interface. For example: 
    ```java
    class Base { 
        static void m(){ } 
        void n(){ } 
        static void x(){ } 
        void y(){ } 
    } 
    class Sub extends Base { 
        void m(){ } //WILL NOT COMPILE
        static void n(){ } //WILL NOT COMPILE
        static void x(){ } //VALID, x() of base is hidden 
        void y(){ }// VALID, y() of base is overridden 
    }
    ```
3. Equals method of array classes returns the same result as ==

4. long, float, double, and boolean can never be used as a switch variable.
Only String, byte, char, short, int, (and their wrapper classes Byte, Character, Short, and Integer), 
and enums can be used as types of a switch variable. 

5. Although you can pass any string value to the SuppressWarnings annotation (unrecognized values are ignored), 
the Java specification mandates only three values - unchecked, deprecation, and removal. 

6.
A functional interface must have exactly one abstract method. Remember that methods of the java.lang.Object class 
do not count towards the number of abstract methods of an interface. So, for example, the following is still a 
valid functional interface even though it has three abstract method declarations:  

```java
@FunctionalInterface 
public interface FI { 
    int m1(); //valid abstract method
    boolean equals(Object o); //valid declaration but does not count towards the number of abstract methods 
    String toString(); //valid declaration but does not count towards the number of abstract methods 
}
```

7. JDBC: The numbering of columns in a ResultSet starts with 1

8. JDBC url always starts with jdbc: and has at least three components separated by a semicolon

