/**
 *
 * Nombre:  OSCARZUNIGALARA
 * Matricula:   A01654827
 *
 */
package examenFInal;

import java.util.LinkedList;

/**
 * Clase que representa un grafo no dirigido mediante una lista de adyacencias
 *
 * @author Julio Arriaga
 * @param <E>
 */
public class UnGraphList<E> {

    // Lista de nodos en el grafo
    LinkedList<GraphNode<E>> nodes;

    // Constructor para crear un grafo vacio
    public UnGraphList() {
        nodes = new LinkedList<>();
    }

    // Agrega un nodo al grafo
    public boolean addNode(E element) {
        GraphNode<E> newNode = new GraphNode(element);
        if (!nodes.contains(newNode)) {
            nodes.add(newNode);
            return true;
        }
        return false;
    }

    // Agrega un arco no dirigido al grafo conectando source a destiny
    // Si source o destiny no son nodos en el grafo, crea dichos nodos
    public boolean addEdge(E source, E destiny) {
        GraphNode<E> s = getNode(source);
        GraphNode<E> d = getNode(destiny);

        if (s == null) {
            addNode(source);
            s = getNode(source);
        }

        if (d == null) {
            addNode(destiny);
            d = getNode(destiny);
        }
        s.addNeighbor(d);
        d.addNeighbor(s);//Como el grafo es no dirigido agregamos el arco a ambos nodos
        return true;
    }

    // Regresa referencia al nodo conteniendo element
    private GraphNode<E> getNode(E element) {
        GraphNode<E> node = new GraphNode<>(element);
        int index = nodes.indexOf(node);
        if (index >= 0) {
            return nodes.get(index);
        } else {
            return null;
        }
    }

    // Indica si element esta contenido en el grafo
    public boolean contains(E element) {
        return getNode(element) != null;
    }

    // Regresa una lista con todos los vecinos de element
    public LinkedList<GraphNode<E>> getNeighbors(E element) {
        GraphNode<E> n = getNode(element);
        return n.getNeighbors();
    }

    @Override
    public String toString() {
        String r = "UnGraphList{\n";
        for (GraphNode<E> n : nodes) {
            r += n.data + ": " + n.neighbors + "\n";
        }
        return r + '}';
    }

    public DiGraphMatrix<E> convert() {
        throw new UnsupportedOperationException();
    }

}
