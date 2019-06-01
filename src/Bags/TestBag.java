package Bags;

/**
 *
 * @author Julio Arriaga
 */
public class TestBag {

    public static void main(String[] args) {
        Bag<Integer> bag1 = new ArrayBag<>(5);
        System.out.println("Bag1 = " + bag1);
        bag1.add(0);
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        bag1.add(4);
        bag1.add(5);
        System.out.println("Bag1 = " + bag1);
        bag1.remove();
        bag1.remove(2);
        System.out.println("Bag1 = " + bag1);
        System.out.println("Bag1 size = " + bag1.getCurrentSize());
        bag1.add(1);
        System.out.println("Frequency of 1 = " + bag1.getFrequencyOf(1));
        bag1.clear();
        System.out.println("Bag1 is empty? " + bag1.isEmpty());
        System.out.println("Bag1 = " + bag1);

        Bag<String> bag2 = new ArrayBag<>(10);
        bag2.add("hola");
        bag2.add("mundo");
        System.out.println("Bag2 = " + bag2);
    }

}
