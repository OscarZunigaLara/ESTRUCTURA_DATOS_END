package LISTAS;


/**
 *
 * @author Julio Arriaga
 */
public interface List<H> {

    void addFirst(H element);

    void addLast(H element);

    void add(int index, H element);

    H removeFirst();

    H removeLast();

    H remove(int index);

    boolean remove(H element);

    H getFirst();

    H getLast();

    H get(int index);

    void set(int index, H element);

    boolean contains(H element);

    int indexOf(H element);

    void clear();

    int size();

    boolean isEmpty();

    H[] toArray();

}