package base.collection.list.stack;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        MyStackImpl<Integer> stack = new MyStackImpl();

        stack.push(1);
        System.out.println(stack.size());
        stack.push(2);
        System.out.println(stack.size());

        stack.pop();
        System.out.println(stack.size());

        stack.pop();
        System.out.println(stack.size());

        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("empty Stack Exception");
        }

    }
}
