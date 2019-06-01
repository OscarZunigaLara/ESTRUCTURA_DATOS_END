package examenFInal;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Clase que representa un nodo de un grafo consistente de un dato, una lista de
 * nodos vecinos y una bandera auxilar para recorridos
 *
 * @author Julio Arriaga
 * @param <E>
 */
public class GraphNode<E> {

    E data;
    LinkedList<GraphNode<E>> neighbors;

    public GraphNode(E data) {
        this.data = data;
        neighbors = new LinkedList<>();
    }

    public void addNeighbor(GraphNode<E> neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GraphNode<?> other = (GraphNode<?>) obj;
        return Objects.equals(this.data, other.data);
    }

}
