package EXAMEN1;

public class TestExam2 {

    public static void main(String[] args) {
        SimpleList<Integer> a = new SimpleList<>();
        SimpleList<Integer> b = new SimpleList<>();
        SimpleList<Integer> c = new SimpleList<>();
        for (int i = 0; i < 10; i++) {
            a.addLast(i);
            b.addFirst(i + 5);
            c.addLast(i);
        }

        System.out.println("TESTING EXAM2");
        System.out.println("*************");

        testDifference(a, b);

        testSublist(c);

    }

    public static void testSublist(SimpleList<Integer> c) {
        System.out.println("Testing sublist");
        System.out.println("c:" + c);
        System.out.println("c sublist from 0: " + c.sublist(0));
        System.out.println("c sublist from 2: " + c.sublist(2));
        try {
            System.out.print("c sublist from 11: ");
            c.sublist(11);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        System.out.println();
    }

    public static void testDifference(SimpleList<Integer> a, SimpleList<Integer> b) {
        System.out.println("Testing difference");
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        a.difference(b);
        System.out.println("a difference b: " + a);
        System.out.println();
    }

}