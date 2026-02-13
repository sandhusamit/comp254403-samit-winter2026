/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  // make an array of size n with random doubles
  private static int[] randomArray(int n, long seed) {
    Random r = new Random(seed);
    int[] x = new int[n];
    for (int i = 0; i < n; i++)
      x[i] = r.nextInt();
    return x;
  }

  // time prefixAverage1
  private static long timeUnique1(int[] x) {
    long start = System.nanoTime();
    unique1(x);
    return System.nanoTime() - start;
  }

  // time prefixAverage2
  private static long timeUnique2(int[] x) {
    long start = System.nanoTime();
    unique2(x);
    return System.nanoTime() - start;
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  public static void main(String[] args) {

    int n = 1000;      // starting size (small because O(n^2))
    int trials = 10;

    if (args.length > 0)
      trials = Integer.parseInt(args[0]);
    if (args.length > 1)
      n = Integer.parseInt(args[1]);

    int start = n;

    System.out.println("Testing Unique2 (O(n))");
    for (int t = 0; t < trials; t++) {
      int[] x = randomArray(n, 12345L);
      long elapsed = timeUnique2(x);
      System.out.printf("n: %8d  time: %8.3f ms%n", n, elapsed / 1_000_000.0);
      n *= 2;
    }

    System.out.println("\nTesting Unique1 (O(n^2))");
    n = start;
    for (int t = 0; t < trials; t++) {
      int[] x = randomArray(n, 12345L);
      long elapsed = timeUnique1(x);
      System.out.printf("n: %8d  time: %8.3f ms%n", n, elapsed / 1_000_000.0);
      n *= 2;
    }
  }

}
