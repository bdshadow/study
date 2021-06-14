package com.bdshadow.java11;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueExamples {
    /*
    push() is a stack method that adds the element to the front. Therefore, the contents of d change as follows:
    1
    offer(e) is a queue method that adds the element to the end and offerLast(e) is equivalent to offer(e). So the deque now contains:
    1, 2
    push(3) changes it to:
    3, 1, 2
    Now, peek methods don't modify the structure, therefore even though peekFirst returns 3, the deque doesn't change.
    removeLast() removes the element from the end, so d now contains:
    3, 1
    pop() is a stack method that removes the element from the front. Therefore, the contents of d change to:
    1
     */
    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();
        d.push(1);
        d.offerLast(2);
        d.push(3);
        d.peekFirst();
        d.removeLast();
        d.pop();
        System.out.println(d);
    }
}
