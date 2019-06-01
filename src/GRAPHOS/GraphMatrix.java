/*
 * Copyright (c) 2019 Julio Arriaga.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Julio Arriaga - initial API and implementation and/or initial documentation
 */
package GRAPHOS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Julio Arriaga
 */
public class GraphMatrix<E> implements Graph<E> {

    private boolean[][] matrix;
    private Node<E>[] nodes;
    private int numNodes;

    public GraphMatrix(int maxNodes) {
        nodes = new Node[maxNodes];
        matrix = new boolean[maxNodes][maxNodes];
        numNodes = 0;
    }

    @Override
    public boolean addNode(E element) {
        if (numNodes < nodes.length && !contains(element)) {
            nodes[numNodes] = new Node<>(element);
            numNodes++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(E source, E destiny) {
        int s = indexOf(source);
        int d = indexOf(destiny);
        if (s >= 0 && d >= 0) {
            matrix[s][d] = true;
            matrix[d][s] = true;
            return true;
        }
        return false;
    }

    private int indexOf(E element) {
        for (int i = 0; i < numNodes; i++) {
            if (nodes[i].data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean deleteNode(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteEdge(E source, E destiny) {
        int s = indexOf(source);
        int d = indexOf(destiny);
        if (s >= 0 && d >= 0) {
            matrix[s][d] = false;
            matrix[d][s] = false;
            return true;
        }
        return false;
    }

    @Override
    public LinkedList neighbors(E element) {
        int i = indexOf(element);
        LinkedList<E> neighbors = new LinkedList<>();
        if (i >= 0) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    neighbors.add(nodes[j].data);
                }
            }
        }
        return neighbors;
    }

    public String BFS(E start) {
        LinkedList<Node<E>> q = new LinkedList<>();
        String bfs = "";
        resetVisitAll();
        int i = indexOf(start);
        if (i >= 0) {
            q.addLast(nodes[i]);
            nodes[i].visited = true;
            bfs += nodes[i].data;
            while (!q.isEmpty()) {
                LinkedList<Node<E>> ns = neighbors(q.peek().data);
                boolean allDone = true;
                for (Node<E> n : ns) {
                    if (!n.visited) {
                        n.visited = true;
                        bfs += n.data;
                        q.addLast(n);
                        allDone = false;
                        break;
                    }
                }
                if (allDone) {
                    q.removeFirst();
                }
            }
        }
        return bfs;
    }

    public String DFS(E start) {
        Stack<Node<E>> q = new Stack<>();
        String dfs = "";
        resetVisitAll();
        int i = indexOf(start);
        if (i >= 0) {
            q.push(nodes[i]);
            nodes[i].visited = true;
            dfs += nodes[i].data;
            while (!q.isEmpty()) {
                LinkedList<Node<E>> ns = neighbors(q.peek().data);
                boolean allDone = true;
                for (Node<E> n : ns) {
                    if (!n.visited) {
                        n.visited = true;
                        dfs += n.data;
                        q.push(n);
                        allDone = false;
                        break;
                    }
                }
                if (allDone) {
                    q.pop();
                }
            }
        }
        return dfs;
    }

    private void resetVisitAll() {
        for (Node<E> n : nodes) {
            n.visited = false;
        }
    }

    @Override
    public String toString() {
        String edges = "";
        for (boolean[] m : matrix) {
            for (boolean e : m) {
                edges += e + " ";
            }
            edges += "\n";
        }
        return "{" + "Nodes=" + Arrays.toString(nodes) + "\n"
                + "Matrix:\n" + edges + '}';
    }

}