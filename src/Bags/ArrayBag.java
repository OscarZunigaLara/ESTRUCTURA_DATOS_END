package Bags;

import java.util.Arrays;

/**
 *
 * @author Julio Arriaga
 */
public class ArrayBag<T> implements Bag<T> {

    private int numberOfElements;
    private T[] bagish;
    private static final int DEFAULT_SIZE = 10;

    public ArrayBag() {
        bagish = (T[]) new Object[DEFAULT_SIZE];
        numberOfElements = 0;
    }

    public ArrayBag(int size) {
        bagish = (T[]) new Object[size];
        numberOfElements = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfElements;
    }

    @Override
    public boolean isFull() {
        return numberOfElements == bagish.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean add(T element) {
        if (!isFull()) {
            bagish[numberOfElements] = element;
            numberOfElements++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        numberOfElements = 0;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        } else {
            numberOfElements--;
            return bagish[numberOfElements];
        }
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < numberOfElements; i++) {
            if (bagish[i].equals(element)) {
                numberOfElements--;
                bagish[i] = bagish[numberOfElements];
                return true;
            }
        }
        return false;
    }

    @Override
    public int getFrequencyOf(T element) {
        int frequency = 0;
        for (int i = 0; i < numberOfElements; i++) {
            if (bagish[i].equals(element)) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(T element) {
        return getFrequencyOf(element) > 0;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(bagish, numberOfElements);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}