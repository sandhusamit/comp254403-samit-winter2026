import java.util.Random;

public class TestChainHashMap {

    public static void main(String[] args) {

        int n = 10000; // number of elements
        Random rand = new Random();

        // Create maps with different load factors
        ChainHashMap<Integer, String> mapLow = new ChainHashMap<>(17, 0.5);
        ChainHashMap<Integer, String> mapHigh = new ChainHashMap<>(17, 0.9);

        System.out.println("=== INSERT TEST ===");

        // Test LOW load factor
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(100000);
            mapLow.put(key, "Value" + key);
        }
        long end = System.currentTimeMillis();
        System.out.println("Load Factor 0.5 Time: " + (end - start) + " ms");

        // Test HIGH load factor
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(100000);
            mapHigh.put(key, "Value" + key);
        }
        end = System.currentTimeMillis();
        System.out.println("Load Factor 0.9 Time: " + (end - start) + " ms");

        // -----------------------------
        System.out.println("\n=== SEARCH TEST ===");

        int testKey = rand.nextInt(100000);

        int searches = 10000;

        start = System.nanoTime();
        for (int i = 0; i < searches; i++) {
            mapLow.get(rand.nextInt(100000));
        }
        end = System.nanoTime();
        System.out.println("Search time (0.5): " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < searches; i++) {
            mapHigh.get(rand.nextInt(100000));
        }
        end = System.nanoTime();
        System.out.println("Search time (0.9): " + (end - start));

        // -----------------------------
        System.out.println("\n=== SIZE CHECK ===");
        System.out.println("MapLow size: " + mapLow.size());
        System.out.println("MapHigh size: " + mapHigh.size());

        // -----------------------------
        System.out.println("\n=== REMOVE TEST ===");

        start = System.nanoTime();
        mapLow.remove(testKey);
        end = System.nanoTime();
        System.out.println("Remove time (0.5): " + (end - start) + " ns");

        start = System.nanoTime();
        mapHigh.remove(testKey);
        end = System.nanoTime();
        System.out.println("Remove time (0.9): " + (end - start) + " ns");

        System.out.println("\n=== TEST COMPLETE ===");

        /**
         * In conclusion, the tests show that using a higher load factor (e.g., 0.9 instead of 0.5) can result in faster overall performance for insert, search, size, and remove operations. This is because fewer resizing operations are required, reducing the overhead of rehashing elements.
         *
         * However, a lower load factor generally leads to fewer collisions, since elements are distributed across more available buckets. This can improve the efficiency of search, insert, and remove operations, as fewer elements need to be examined within each bucket.
         *
         * Therefore, there is a trade-off between resizing cost and collision cost. A higher load factor reduces resizing overhead but increases collisions, while a lower load factor reduces collisions but increases the frequency of resizing.
         */
    }
}