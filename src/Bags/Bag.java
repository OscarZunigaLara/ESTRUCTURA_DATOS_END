package Bags;

/**
 *
 * @author Julio Arriaga
 */
public interface Bag<T> {

    public abstract int getCurrentSize();

    boolean isFull();

    boolean isEmpty();

    boolean add(T element);

    void clear();

    T remove();

    boolean remove(T element);

    int getFrequencyOf(T element);

    boolean contains(T element);

    T[] toArray();
}