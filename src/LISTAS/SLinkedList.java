package LISTAS;


import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author Julio Arriaga
 */
public class SLinkedList<E> implements List<E> {

    private Node<E> top;
    private int numberOfElements;

    public SLinkedList() {
        top = new Node(null);
        numberOfElements = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node(element);
        newNode.setNext(top.getNext());
        top.setNext(newNode);
        numberOfElements++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node(element);
        Node<E> i = top;
        while (i.getNext() != null) {
            i = i.getNext();
        }
        i.setNext(newNode);
        numberOfElements++;
    }

    /**
     * Returns the node at the specified index Sentinel node is located at index
     * -1
     *
     * @param index
     * @return the node at the specified index
     */
    private Node<E> getNodeAt(int index) {
        Node<E> n = top;
        for (int i = 0; i <= index; i++) {
            n = n.getNext();
        }
        return n;
    }

    // A4
    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E e = top.getNext().getData();
        top.setNext(top.getNext().getNext());
        numberOfElements--;
        return e;
    }

    // A4
    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // A4
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(E element) {
        int i = indexOf(element);
        if (i >= 0) {
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.getNext().getData();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getNodeAt(numberOfElements - 1).getData();
    }

    // A4
    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // A4
    @Override
    public void set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // A4
    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        if (isEmpty()) {
            return -1;
        }
        Node<E> n = top.getNext();
        int i = 0;
        while (n != null) {
            if (n.getData().equals(element)) {
                return i;
            }
            n = n.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public void clear() {
        top.setNext(null);
        numberOfElements = 0;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public E[] toArray() {
        E[] a = (E[]) new Object[numberOfElements];
        Node<E> n = top.getNext();
        for (int i = 0; i < numberOfElements; i++) {
            a[i] = n.getData();
            n = n.getNext();
        }
        return a;
    }

    @Override
    public String toString(){
        return Arrays.toString(toArray());
    }

    public void union(SLinkedList<E> otherLst){
        for(int i=0;i<otherLst.size();i++){
            addLast(otherLst.get(i));
        }
    }

}
