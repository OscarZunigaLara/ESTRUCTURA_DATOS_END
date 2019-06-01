package LISTAS;


/**
 *
 * @author Julio Arriaga
 */
public class ListStack<E> implements StackInterface<E> {

    private SLinkedList<E> stk;

    public ListStack(){
        stk = new SLinkedList<>();
    }

    @Override
    public void push(E newEntry) {
        stk.addFirst(newEntry);
    }

    @Override
    public E pop() {
        return stk.removeFirst();
    }

    @Override
    public E peek() {
        return stk.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return stk.isEmpty();
    }

    @Override
    public void clear() {
        stk.clear();
    }

    @Override
    public int size() {
        return stk.size();
    }

    @Override
    public String toString(){
        return stk.toString();
    }

}
