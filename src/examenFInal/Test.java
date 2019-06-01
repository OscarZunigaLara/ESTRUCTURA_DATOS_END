package examenFInal;

public class Test {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        System.out.println("***** Testing Tree *****");
        SimpleBinaryTree<Integer> t1 = new SimpleBinaryTree<>(5);
        t1.insert(4, 5);
        t1.insert(7, 5);
        t1.insert(3, 4);
        t1.insert(6, 7);
        t1.insert(2, 3);
        System.out.println("Tree t1: " + t1.inOrder());
        try {
            System.out.println("Testing balance: " + t1.checkBalance());
        } catch (UnsupportedOperationException ex) {
        }
        System.out.println("");

        SimpleBinaryTree<Integer> t2 = new SimpleBinaryTree<>(6);
        t2.insert(4, 6);
        t2.insert(9, 6);
        t2.insert(3, 4);
        t2.insert(5, 4);
        t2.insert(7, 9);
        t2.insert(10, 9);
        System.out.println("Tree t2: " + t2.inOrder());
        try {
            System.out.println("Testing balance: " + t2.checkBalance());
        } catch (UnsupportedOperationException ex) {
        }
    }

    private static void test2() {
        System.out.println("");
        System.out.println("***** Testing Graph *****");
        UnGraphList<Character> g1 = new UnGraphList<>();
        g1.addEdge('A', 'B');
        g1.addEdge('A', 'C');
        g1.addEdge('A', 'D');
        g1.addEdge('B', 'C');
        g1.addEdge('D', 'A');

        DiGraphMatrix<Character> g2 = new DiGraphMatrix<>(4);
        g2.addEdge('A', 'B');
        g2.addEdge('A', 'C');
        g2.addEdge('A', 'D');
        g2.addEdge('B', 'C');
        g2.addEdge('D', 'A');

        try {
            DiGraphMatrix<Character> g3 = g1.convert();
            System.out.println("g:" + g1);
            System.out.println("Convert g:" + g3);
        } catch (UnsupportedOperationException ex) {
        }

        try {
            UnGraphList<Character> g4 = g2.convert();
            System.out.println("g:" + g2);
            System.out.println("Convert g:" + g4);

        } catch (UnsupportedOperationException ex) {
        }
    }
}
