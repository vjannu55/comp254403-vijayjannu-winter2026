package EX1;

import java.util.Random;

public class TestLoadFactor {

    public static void main(String[] args) {

        int n = 10000;
        double[] loadFactors = {0.25, 0.5, 0.75, 0.9};

        for (double lf : loadFactors) {

            CustomHashMap<Integer, Integer> map =
                    new CustomHashMap<>(16, lf);

            long start = System.nanoTime();

            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                int key = rand.nextInt(100000);
                map.put(key, i);
            }

            long end = System.nanoTime();

            System.out.println("Load Factor: " + lf +
                    " | Time: " + (end - start)/1e6 + " ms" +
                    " | Size: " + map.size());
        }
    }
}
