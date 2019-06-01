package EXAMEN2;


/**
 *
 * @author Julio Arriaga
 */
public interface ExamStack<T> {

    /**
     * Agrega un nuevo elemento al tope de la pila
     *
     * @param item el elemento ha ser agregado Si la pila esta llena, arroja un
     * IndexOutOfBoundsException
     */
    void push(T item);

    /**
     * Regresa y elimina el elemento al tope de la pila
     *
     * @return el elemento al tope de la pila Si la pila esta vacia, arroja un
     * NoSuchElementException
     */
    T pop();

    /**
     * Regresa el elemento al tope de la pila
     *
     * @return el elemento al tope de la pila Si la pila esta vacia, arroja un
     * NoSuchElementException
     */
    T peek();

}
