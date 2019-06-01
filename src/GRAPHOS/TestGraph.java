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

/**
 *
 * @author Julio Arriaga
 */
public class TestGraph {

    public static void main(String[] args) {
        DiGraph<Integer> g = new DiGraph<>();
        System.out.println("Testing DiGraph");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Adding " + i);
            g.addNode(i);
            System.out.println("Graph: " + g.toString());
        }
        System.out.println("");

        System.out.println("Trying to add 1 again...");
        g.addNode(1);
        System.out.println("Graph: " + g.toString());

        System.out.println("\nAdding edges");
        System.out.println("Adding 1-1");
        g.addEdge(1, 1);
        System.out.println("Graph: " + g.toString());
        System.out.println("");

        System.out.println("Adding 1-2");
        g.addEdge(1, 2);
        System.out.println("Graph: " + g.toString());
        System.out.println("");

        System.out.println("Adding 2-1");
        g.addEdge(2, 1);
        System.out.println("Graph: " + g.toString());
        System.out.println("");

        System.out.println("Adding 1-3");
        g.addEdge(1, 3);
        System.out.println("Graph: " + g.toString());
        System.out.println("");

        System.out.println("Adding 3-4");
        g.addEdge(3, 4);
        System.out.println("Graph: " + g.toString());
        System.out.println("");

        System.out.println("Adding 5-2");
        g.addEdge(5, 2);
        System.out.println("Graph: " + g.toString());
        System.out.println("");

        System.out.println("Adding 6-7");
        g.addEdge(6, 7);
        System.out.println("Graph: " + g.toString());
        System.out.println("");

        System.out.println("BFS from 1:" + g.BFS(1));
        System.out.println("BFS from 2:" + g.BFS(2));
        System.out.println("BFS from 3:" + g.BFS(3));

        System.out.println("DFS from 4:" + g.DFS(4));
        System.out.println("DFS from 5:" + g.DFS(5));
        System.out.println("DFS from 6:" + g.DFS(6));

        System.out.println("");

        System.out.println("Removing edge 1-3");
        g.deleteEdge(1, 3);
        System.out.println("Graph:" + g.toString());
        System.out.println("");

        System.out.println("Removing edge 1-5");
        g.deleteEdge(1, 5);
        System.out.println("Graph:" + g.toString());
        System.out.println("");

        System.out.println("Removing node 2");
        g.deleteNode(2);
        System.out.println("Graph:" + g.toString());
    }

}