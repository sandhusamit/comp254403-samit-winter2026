import java.util.Random;

class PrefixAverage {

  /** ===============================
   * Helpers for Exercise 2 Testing
   * =============================== */

  // make an array of size n with random doubles
  private static double[] randomArray(int n, long seed) {
    Random r = new Random(seed);
    double[] x = new double[n];
    for (int i = 0; i < n; i++)
      x[i] = r.nextDouble();
    return x;
  }

  // time prefixAverage1
  private static long timePrefix1(double[] x) {
    long start = System.nanoTime();
    prefixAverage1(x);
    return System.nanoTime() - start;
  }

  // time prefixAverage2
  private static long timePrefix2(double[] x) {
    long start = System.nanoTime();
    prefixAverage2(x);
    return System.nanoTime() - start;
  }

  /** ==================================
   * Prefix Average Algorithms
   * ================================== */

  /** O(n^2) version */
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];
    for (int j = 0; j < n; j++) {
      double total = 0;
      for (int i = 0; i <= j; i++)
        total += x[i];
      a[j] = total / (j + 1);
    }
    return a;
  }

  /** O(n) version */
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];
    double total = 0;
    for (int j = 0; j < n; j++) {
      total += x[j];
      a[j] = total / (j + 1);
    }
    return a;
  }

  /** ==================================
   * NEW MAIN — Experimental Analysis
   * ================================== */
  public static void main(String[] args) {

    int n = 1000;      // starting size (small because O(n^2))
    int trials = 10;

    if (args.length > 0)
      trials = Integer.parseInt(args[0]);
    if (args.length > 1)
      n = Integer.parseInt(args[1]);

    int start = n;

    System.out.println("Testing prefixAverage2 (O(n))");
    for (int t = 0; t < trials; t++) {
      double[] x = randomArray(n, 12345L);
      long elapsed = timePrefix2(x);
      System.out.printf("n: %8d  time: %8.3f ms%n", n, elapsed / 1_000_000.0);
      n *= 2;
    }

    System.out.println("\nTesting prefixAverage1 (O(n^2))");
    n = start;
    for (int t = 0; t < trials; t++) {
      double[] x = randomArray(n, 12345L);
      long elapsed = timePrefix1(x);
      System.out.printf("n: %8d  time: %8.3f ms%n", n, elapsed / 1_000_000.0);
      n *= 2;
    }
  }
}
