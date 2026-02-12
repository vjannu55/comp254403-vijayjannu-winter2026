import java.util.Arrays;
import java.util.Random;

public class UniquenessExperiment {

    // ---------------- Exercise 3 Requirement ----------------
    // Find largest n such that algorithm runs in <= 1 minute
    public static final long TIME_LIMIT_MS = 60000;

    // Generate random array (mostly unique)
    public static int[] generateArray(int n) {
        Random r = new Random();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = r.nextInt(Integer.MAX_VALUE);
        }
        return data;
    }

    // Time unique1 (O(n^2))
    public static long timeUnique1(int n) {
        int[] data = generateArray(n);
        long start = System.currentTimeMillis();
        Uniqueness.unique1(data);
        long end = System.currentTimeMillis();
        return end - start;
    }

    // Time unique2 (O(n log n))
    public static long timeUnique2(int n) {
        int[] data = generateArray(n);
        long start = System.currentTimeMillis();
        Uniqueness.unique2(data);
        long end = System.currentTimeMillis();
        return end - start;
    }

    // Binary Search to find maximum n such that time <= 1 minute
    public static int findMaxN(boolean useUnique1, int low, int high) {

        int best = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            long timeTaken;
            if (useUnique1) {
                timeTaken = timeUnique1(mid);
                System.out.println("unique1 -> n=" + mid + " time=" + timeTaken + " ms");
            } else {
                timeTaken = timeUnique2(mid);
                System.out.println("unique2 -> n=" + mid + " time=" + timeTaken + " ms");
            }

            if (timeTaken <= TIME_LIMIT_MS) {
                best = mid;       // mid works, store it
                low = mid + 1;    // try bigger
            } else {
                high = mid - 1;   // too slow, reduce
            }
        }

        return best;
    }

    // MAIN METHOD (Run this file)
    public static void main(String[] args) {



        // unique1 is slow, keep upper bound smaller
        System.out.println("\nFinding max n for unique1 (<= 1 minute)...");
        int max1 = findMaxN(true, 1, 50000);
        System.out.println("Max n for unique1 in 1 minute: " + max1);

        // unique2 is faster, can go larger
        System.out.println("\nFinding max n for unique2 (<= 1 minute)...");
        int max2 = findMaxN(false, 1, 2000000);
        System.out.println("Max n for unique2 in 1 minute: " + max2);

    }
}

// Uniqueness class (combined inside same file)
class Uniqueness {

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++)
                if (data[j] == data[k])
                    return false;   // found duplicate pair
        return true;                // all unique
    }

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);
        Arrays.sort(temp);
        for (int j = 0; j < n - 1; j++)
            if (temp[j] == temp[j + 1])
                return false;       // found duplicate pair
        return true;                // all unique
    }
}
