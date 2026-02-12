import java.util.Random;

public class PrefixAverageExperiment {

    // ---------- Algorithms ----------
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

    // ---------- Helper for Input ----------
    public static double[] generateArray(int n) {
        Random r = new Random();
        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            data[i] = r.nextDouble();
        }
        return data;
    }

    // ---------- Experiment Runner ----------
    public static void runExperiment(int startN, int trials) {

        int n = startN;
        int start = n;

        // Test prefixAverage2 first
        System.out.println("Testing prefixAverage2 (O(n))...");
        for (int t = 0; t < trials; t++) {
            double[] x = generateArray(n);

            long startTime = System.currentTimeMillis();
            prefixAverage2(x);
            long endTime = System.currentTimeMillis();

            long elapsed = endTime - startTime;
            System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));

            n *= 2;
        }

        // Test prefixAverage1 next
        System.out.println("\nTesting prefixAverage1 (O(n^2))...");
        n = start;

        for (int t = 0; t < trials; t++) {
            double[] x = generateArray(n);

            long startTime = System.currentTimeMillis();
            prefixAverage1(x);
            long endTime = System.currentTimeMillis();

            long elapsed = endTime - startTime;
            System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));

            n *= 2;
        }
    }
}
