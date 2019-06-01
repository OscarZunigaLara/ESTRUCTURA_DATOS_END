/**
 *
 * Nombre:  OSCAR ZUNIGA LARA
 * Matricula:   A01654827
 *
 */
package examenFInal;

import GRAPHOS.DiGraph;

import java.util.LinkedList;

/**
 * Clase que representa un grafo dirigido mediante una matriz de adyacencias
 *
 * @author Julio Arriaga
 * @param <E>
 */
public class DiGraphMatrix<E> {

    // Matriz de adyacencias del grafo
    private boolean[][] matrix;
    // Lista de nodos del grafo
    private GraphNode<E>[] nodes;
    // Numero total de nodos en el grafo
    private int numNodes;

    // Constructor para crear un grafo vacio con un maximo de maxNodes
    public DiGraphMatrix(int maxNodes) {
        nodes = new GraphNode[maxNodes];
        matrix = new boolean[maxNodes][maxNodes];
        numNodes = 0;
    }

    // Agrega un nodo al grafo
    public boolean addNode(E element) {
        if (numNodes < nodes.length && !contains(element)) {
            nodes[numNodes] = new GraphNode<>(element);
            numNodes++;
            return true;
        }
        return false;
    }

    // Agrega un arco dirigido al grafo de source a destiny
    // Si source o destiny no son nodos en el grafo, crea dichos nodos
    // Si alguno de los nodos o ambos nodos no existen en el grafo y el grafo 
    // ya esta lleno, no se agrega el arco
    public boolean addEdge(E source, E destiny) {
        int s = indexOf(source);
        int d = indexOf(destiny);
        if (s < 0) {
            addNode(source);
            s = indexOf(source);
        }
        if (d < 0) {
            addNode(destiny);
            d = indexOf(destiny);
        }
        if (s >= 0 && d >= 0) {
            matrix[s][d] = true;
            return true;
        }
        return false;
    }

    // Regresa el indice del nodo conteniendo element
    private int indexOf(E element) {
        for (int i = 0; i < numNodes; i++) {
            if (nodes[i].data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // Indica si element esta contenido en el grafo
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    // Regresa una lista con todos los vecinos de element
    public LinkedList<GraphNode<E>> getNeighbors(E element) {
        int i = indexOf(element);
        LinkedList<GraphNode<E>> neighbors = new LinkedList<>();
        if (i >= 0) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    neighbors.add(nodes[j]);
                }
            }
        }
        return neighbors;
    }

    @Override
    public String toString() {
        String r = "DiGraphMatrix{\n  ";
        for (GraphNode<E> n : nodes) {
            r += n + " ";
        }
        r += "\n";
        for (int i = 0; i < matrix.length; i++) {
            r += nodes[i] + " ";
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    r += "T ";
                } else {
                    r += "F ";
                }
            }
            r += "\n";
        }
        return r + '}';
    }


    public UnGraphList<E> convert() {

        UnGraphList UNGRAPH = new UnGraphList();


        for (int i = 0; i < matrix.length; i++) {
            UNGRAPH.addNode(nodes[i]);
        }

        int oo = 0;
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(i);

            for (int ii = 0; ii < getNeighbors(nodes[i].data).size(); ii++) {
                System.out.println("ESTO:   ");

                System.out.println(this.nodes[oo]);


                //if (!UNGRAPH.getNeighbors(nodes[oo]).contains(this.getNeighbors(nodes[i].data).get(ii))) {
                        E ooo =  this.getNeighbors(nodes[i].data).get(ii).data ;
                        System.out.println(ooo);
                        //System.out.println(this.getNeighbors(nodes[i].data).get(ii));
                        //System.out.print(UNGRAPH.getNeighbors( nodes[i]));

                        UNGRAPH.addEdge(nodes[i], ooo );
                   // System.out.println(UNGRAPH.toString());

                    //System.out.println(UNGRAPH.getNeighbors(nodes[i]));
                        //UNGRAPH.addEdge(this.nodes[i], this.getNeighbors(nodes[i].data).get(ii));
                        System.out.println(this.getNeighbors(nodes[i].data).get(ii));


                    //System.out.println(UNGRAPH.toString());



            }
            oo++;


        }
        return UNGRAPH;

    }


/*
public UnGraphList<E> convert() {

    UnGraphList UNGRAPH = new UnGraphList();


    for (int i = 0; i < matrix.length; i++) {
        UNGRAPH.addNode(nodes[i]);
    }

    int oo = 0;
    for (int i = 0; i < matrix.length; i++) {

        for (int ii = 0; ii < getNeighbors(nodes[i].data).size(); ii++) {
            System.out.println("ESTO: ");
            System.out.println(this.nodes[oo]);


            if (!UNGRAPH.getNeighbors(nodes[oo]).contains(this.getNeighbors(nodes[i].data).get(ii))) {
                System.out.println(this.getNeighbors(nodes[i].data).get(ii));

//System.out.print(UNGRAPH.getNeighbors( nodes[i]));
                //UNGRAPH.addEdge(nodes[oo], this.getNeighbors(nodes[i].data).get(ii));


                    System.out.println(UNGRAPH.getNeighbors(nodes[i]));
                    UNGRAPH.addEdge(this.nodes[i], this.getNeighbors(nodes[i].data).get(ii));
                    System.out.println(this.getNeighbors(nodes[i].data).get(ii));



//System.out.println(UNGRAPH.toString());
            }
        }
        oo++;
    }
    return UNGRAPH;
}


 */
}


