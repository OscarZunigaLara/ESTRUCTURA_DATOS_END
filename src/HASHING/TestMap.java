package HASHING;

import java.util.NoSuchElementException;

/**
 *
 * @author julius
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, Integer> ht = new OAMap<>(3);
        ht.add("one", 1);
        System.out.println("Adding 'one', Table: " + ht);
        ht.add("one", 2);
        System.out.println("Adding 'one', Table: " + ht);
        ht.add("two", 2);
        System.out.println("Adding 'two', Table: " + ht);
        ht.add("three", 3);
        System.out.println("Adding 'three', Table: " + ht);
        ht.add("four", 4);
        System.out.println("Adding 'four', Table: " + ht);
        ht.add("five", 5);
        System.out.println("Adding 'five', Table: " + ht);
        System.out.println("");

        System.out.println("Value for 'one': " + ht.get("one"));
        System.out.println("Value for 'two': " + ht.get("two"));
        System.out.println("Value for 'three': " + ht.get("three"));
        System.out.println("Value for 'four': " + ht.get("four"));
        System.out.println("Value for 'five': " + ht.get("five"));
        try {
            System.out.println("Value for 'six': " + ht.get("six"));
        } catch (NoSuchElementException ex) {
            System.out.println("Value not found");
        }
        System.out.println("");

        ht.delete("two");
        System.out.println("Table after deleting 'two': " + ht);
        System.out.println("Value for 'one': " + ht.get("one"));
        try {
            System.out.println("Value for 'two': " + ht.get("two"));
        } catch (NoSuchElementException ex) {
            System.out.println("Value not found");
        }
        System.out.println("Value for 'three': " + ht.get("three"));
        System.out.println("Value for 'four': " + ht.get("four"));
        System.out.println("Value for 'five': " + ht.get("five"));
        try {
            System.out.println("Value for 'six': " + ht.get("six"));
        } catch (NoSuchElementException ex) {
            System.out.println("Value not found");
        }
        System.out.println("");

        ht.delete("four");
        System.out.println("Table after deleting 'four': " + ht);
        System.out.println("Value for 'one': " + ht.get("one"));
        try {
            System.out.println("Value for 'two': " + ht.get("two"));
        } catch (NoSuchElementException ex) {
            System.out.println("Value not found");
        }
        System.out.println("Value for 'three': " + ht.get("three"));
        try {
            System.out.println("Value for 'four': " + ht.get("four"));
        } catch (NoSuchElementException ex) {
            System.out.println("Value not found");
        }
        System.out.println("Value for 'five': " + ht.get("five"));
        try {
            System.out.println("Value for 'six': " + ht.get("six"));
        } catch (NoSuchElementException ex) {
            System.out.println("Value not found");
        }
        System.out.println("");
    }

}