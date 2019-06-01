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

/**
 *
 * @author Julio Arriaga
 */
public interface Graph<E> {

    boolean addNode(E element);

    boolean addEdge(E source, E destiny);

    boolean contains(E element);

    boolean deleteNode(E element);

    boolean deleteEdge(E source, E destiny);

    LinkedList neighbors(E element);
}