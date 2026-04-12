public class Driver {

    public static void main(String[] args) {

        SortedTableMap<Integer, String> map = new SortedTableMap<>();

        // Insert test data
        map.put(2, "A");
        map.put(5, "B");
        map.put(8, "C");
//        map.put(12, "D");

        // Test cases
        System.out.println("Testing containsKey:\n");

        System.out.println("Key 2 exists? " + map.containKey(2)); // true

        System.out.println("Key 6 exists? " + map.containKey(6)); // false
        System.out.println("Key 10 exists? " + map.containKey(10)); // false

        // Edge case: null value
        map.put(12, null);

        /*
        Using .get(key) is problematic because the map can still store a key value with a key that has a null value.
        Ex: (12, null) map.get(12) -> returns null but even if theres no key 12, then still we get null. So theres no way to
        really know if its there or not without the method I just created (containKey)
         */
        System.out.println("\nTesting null value case (Why you cant use .get(key):");
        System.out.println("Key 12 exists? " + map.containKey(12)); // true
        System.out.println("Value at key 12: " + map.get(12));       // null --


        // Compare with get()
        System.out.println("\nComparing with get():");
        System.out.println("get(6): " + map.get(6));   // null (not found)
        System.out.println("get(12): " + map.get(12)); // null (exists but value is null)
    }

}
