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


/**
 * Code for end-of-chapter exercises on asymptotics.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Exercises {

  /** Returns the sum of the integers in given array. */
  public static int example1(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j++)       // loop from 0 to n-1
      total += arr[j];
    return total;
  }

  /** Answer to Lab3 Exercise 1a
   * Big-O Notation for Example 1: O(n)
   * There is only one loop, and wherever theres just one loop, we know its doing set work
   * per iteration - Each iteration ahs the exact amount of work/primitive functions
   */

  /** Returns the sum of the integers with even index in given array. */
  public static int example2(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j += 2)    // note the increment of 2
      total += arr[j];
    return total;
  }
  /** Answer to Lab3 Exercise 1b
   *  Same as exercise 1A - since there is a fixed amount of work being done within ONE loop,
   *  we know that this notation is O(n). Only difference is increment (step size) - which doesnt effect
   *  the fact that the runtime will grow linear with increase of n.
   */


   /** Returns the sum of the prefix sums of given array. */
  public static int example3(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j++)       // loop from 0 to n-1
      for (int k=0; k <= j; k++)    // loop from 0 to j
        total += arr[j];
    return total;
  }

  /** Answer to Lab3 Exercise 1c
   *  Since we have a nested loop of 2 - the notation will be O(n^2). The first loop's runtime,
   *  will also account for the runtime of the loop within. Total runtime will be product of the two n's.
   *  Hence - n^2 - which accounts for one loop within another loop.
   *  total iterations = 1 + 2 + ... + n = n(n+1)/2 ⇒ O(n²)
   */


   /** Returns the sum of the prefix sums of given array. */
  public static int example4(int[] arr) {
    int n = arr.length, prefix = 0, total = 0;
    for (int j=0; j < n; j++) {     // loop from 0 to n-1
      prefix += arr[j];
      total += prefix;
    }
    return total;
  }

  /** Answer to Lab3 Exercise 1d
   * Same as the first two - O(n): Because its only running one loop that has primitive operations within each iteration.
   */

   /** Returns the number of times second array stores sum of prefix sums from first. */
  public static int example5(int[] first, int[] second) { // assume equal-length arrays
    int n = first.length, count = 0;
    for (int i=0; i < n; i++) {     // loop from 0 to n-1
      int total = 0;
      for (int j=0; j < n; j++)     // loop from 0 to n-1
        for (int k=0; k <= j; k++)  // loop from 0 to j
          total += first[k];
      if (second[i] == total) count++;
    }
    return count;
  }

/** Answer to Lab3 Exercise 1e
 *  Since we have to account for 2 loops inside one main loop nested (one loop inside another, inside a main) - its going to be O(n^3). Same explaination
 *  as the example 3. Each runtime must be accounted for (which varies based on n).
 */


 }
