class Exercises {

    /** Returns the sum of the integers in given array. */
    public static int example1(int[] arr) {
        // Exercise 1(a)
        // Time Complexity: O(n)
        // Explanation: The loop runs from 0 to n-1 (n times) and does constant work each time.
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            total += arr[j];
        return total;
    }

    /** Returns the sum of the integers with even index in given array. */
    public static int example2(int[] arr) {
        // Exercise 1(b)
        // Time Complexity: O(n)
        // Explanation: The loop increments by 2, so it runs about n/2 times.
        // Big-Oh ignores constants => O(n).
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2)    // note the increment of 2
            total += arr[j];
        return total;
    }

    /** Returns the sum of the prefix sums of given array. */
    public static int example3(int[] arr) {
        // Exercise 1(c)
        // Time Complexity: O(n^2)
        // Explanation: Nested loops.
        // Outer loop runs n times.
        // Inner loop runs (j+1) times for each j.
        // Total steps = 1 + 2 + 3 + ... + n = n(n+1)/2 => O(n^2)
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            for (int k=0; k <= j; k++)    // loop from 0 to j
                total += arr[j];
        return total;
    }

    /** Returns the sum of the prefix sums of given array. */
    public static int example4(int[] arr) {
        // Exercise 1(d)
        // Time Complexity: O(n)
        // Explanation: Single loop runs n times.
        // Operations inside loop are constant time (prefix update + addition).
        int n = arr.length, prefix = 0, total = 0;
        for (int j=0; j < n; j++) {     // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    /** Returns the number of times second array stores sum of prefix sums from first. */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        // Exercise 1(e)
        // Time Complexity: O(n^4)
        // Explanation:
        // Outer loop i runs n times.
        // Inside it, we compute total using:
        //   j loop runs n times
        //   k loop runs 1 + 2 + ... + n = O(n^2)
        // So inside total computation = O(n * n^2) = O(n^3)
        // Multiply by outer loop n => O(n^4)
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
}
