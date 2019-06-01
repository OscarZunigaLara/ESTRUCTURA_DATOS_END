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
import java.util.Objects;

/**
 *
 * @author Julio Arriaga
 */
public class Node<E> {

    E data;
    boolean visited;
    LinkedList<Node<E>> neighbors;

    public Node(E data) {
        this.data = data;
        visited = false;
        neighbors = new LinkedList<>();
    }

    public void addNeighbor(Node<E> neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public void deleteNeighbor(Node<E> neighbor) {
        neighbors.remove(neighbor);
    }

    public LinkedList<Node<E>> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.data);
        return hash;
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
        final Node<?> other = (Node<?>) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

}