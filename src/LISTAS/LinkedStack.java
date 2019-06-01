package LISTAS;

import java.util.NoSuchElementException;

/**
 *
 * @author Julio Arriaga
 */
public class LinkedStack<E> implements StackInterface<E> {

    private Node<E> top;
    private int numberOfElements;

    public LinkedStack(){
        numberOfElements = 0;
        top = new Node<>(null);
    }

    @Override
    public void push(E newEntry) {
        Node<E> newNode = new Node<>(newEntry);
        newNode.setNext(top.getNext());
        top.setNext(newNode);
        numberOfElements++;
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new NoSuchElementException();
        E element = top.getNext().getData();
        top.setNext(top.getNext().getNext());
        numberOfElements--;
        return element;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return top.getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public void clear() {
        numberOfElements = 0;
        top.setNext(null);
    }

    @Override
    public int size() {
        return numberOfElements;
    }

}