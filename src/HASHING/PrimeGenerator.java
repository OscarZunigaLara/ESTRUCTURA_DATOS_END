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
package HASHING;

/**
 *
 * @author Julio Arriaga
 */
public class PrimeGenerator {

    public static int getNextPrime(int size) {
        size = size * 2 + 1;
        while (!isPrime(size)) {
            size = size + 2;
        }
        return size;
    }

    public static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i = i + 6;
        }
        return true;
    }

}