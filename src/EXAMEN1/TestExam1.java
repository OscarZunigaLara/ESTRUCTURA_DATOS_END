package EXAMEN1;

import java.util.LinkedList;

public class TestExam1 {

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        LinkedList<Integer> c = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            a.addLast(i);
            c.addLast(i);
        }
        for (int i = 5; i < 10; i++) {
            b.addLast(i);
            c.addFirst(i);
        }

        System.out.println("TESTING EXAM1");
        System.out.println("*************");

        testMerge(a, b);

        testReverse(c);

    }

    public static void testReverse(LinkedList<Integer> c) {
        System.out.println("Testing reverse");
        System.out.println("c: " + c);
        System.out.println("After reverse(c): " + MoreListUtils.reverse(c));
        System.out.println();

        System.out.println();
    }

    public static void testMerge(LinkedList<Integer> a, LinkedList<Integer> b) {
        System.out.println("Testing merge");
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        MoreListUtils.merge(a, b, 1);
        System.out.println("After merge(a, b, 1): " + a);
        MoreListUtils.merge(b, a, 5);
        System.out.println("After merge(b, a, 5): " + b);
        try {
            System.out.print("Attempting merge(a, b, 30): ");
            MoreListUtils.merge(a, b, 30);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        System.out.println();
    }

}