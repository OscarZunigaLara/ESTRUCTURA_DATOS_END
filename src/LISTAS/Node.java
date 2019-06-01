package LISTAS;

/**
 *
 * @author Julio Arriaga
 */
public class Node<H> {

    private H data;
    private Node<H> next;
    private Node<H> prev;

    public Node(H data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public H getData() {
        return data;
    }

    public void setData(H data) {
        this.data = data;
    }

    public Node<H> getNext() {
        return next;
    }

    public Node<H> getPrev(){
        return prev;
    }

    public void setNext(Node<H> next) {
        this.next = next;
    }

    public void setPrev(Node<H> prev){
        this.prev = prev;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}