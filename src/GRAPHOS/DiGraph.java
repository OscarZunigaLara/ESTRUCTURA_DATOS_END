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

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Julio Arriaga
 */
public class DiGraph<E> implements Graph<E> {

    LinkedList<Node<E>> nodes;

    public DiGraph() {
        nodes = new LinkedList<>();
    }

    @Override
    public boolean addNode(E element) {
        Node<E> newNode = new Node(element);
        if (!nodes.contains(newNode)) {
            nodes.add(newNode);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(E source, E destiny) {
        Node<E> s = getNode(source);
        Node<E> d = getNode(destiny);
        if (s == null) {
            addNode(source);
            s = getNode(source);
        }
        if (d == null) {
            addNode(destiny);
            d = getNode(destiny);
        }
        s.addNeighbor(d);
        return true;
    }

    private Node<E> getNode(E element) {
        Node<E> node = new Node<>(element);
        int index = nodes.indexOf(node);
        if (index >= 0) {
            return nodes.get(index);
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(E element) {
        return getNode(element) != null;
    }

    @Override
    public boolean deleteNode(E element) {
        Node<E> node = getNode(element);
        if (node == null) {
            return false;
        }
        nodes.remove(node);
        for (Node<E> n : nodes) {
            n.deleteNeighbor(node);
        }
        return true;
    }

    @Override
    public boolean deleteEdge(E source, E destiny) {
        Node<E> s = getNode(source);
        Node<E> d = getNode(destiny);
        if (s != null && d != null) {
            s.deleteNeighbor(d);
            return true;
        }
        return false;
    }

    @Override
    public LinkedList neighbors(E element) {
        Node<E> n = getNode(element);
        return n.getNeighbors();
    }

    public String BFS(E start) {
        LinkedList<Node<E>> q = new LinkedList<>();
        String bfs = "";
        resetVisitAll();
        Node<E> n = getNode(start);
        if (n != null) {
            q.addLast(n);
            n.visited = true;
            bfs += n.data;
            while (!q.isEmpty()) {
                LinkedList<Node<E>> neighbors = neighbors(q.peek().data);
                boolean allDone = true;
                for (Node<E> neighbor : neighbors) {
                    if (!neighbor.visited) {
                        neighbor.visited = true;
                        bfs += neighbor.data;
                        q.addLast(neighbor);
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
        Node<E> n = getNode(start);
        if (n != null) {
            q.push(n);
            n.visited = true;
            dfs += n.data;
            while (!q.isEmpty()) {
                LinkedList<Node<E>> neighbors = neighbors(q.peek().data);
                boolean allDone = true;
                for (Node<E> neighbor : neighbors) {
                    if (!neighbor.visited) {
                        neighbor.visited = true;
                        dfs += neighbor.data;
                        q.push(neighbor);
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
        String r = "DiGraph{\n";
        for (Node<E> n : nodes) {
            r += n.data + ": " + n.neighbors + "\n";
        }
        return r + '}';
    }

}
