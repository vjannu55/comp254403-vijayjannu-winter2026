public class Main {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        int[] first = {1, 2, 3, 4};
        int[] second = new int[4];

        // Calling example methods
        System.out.println("example1 sum = " + Exercises.example1(arr));
        System.out.println("example2 even index sum = " + Exercises.example2(arr));
        System.out.println("example3 prefix sum total = " + Exercises.example3(arr));
        System.out.println("example4 prefix sum total = " + Exercises.example4(arr));

        // For example5, we need second[] values to compare
        // We'll just put one correct value for testing
        second[0] = Exercises.example4(first); // not same logic but just sample
        System.out.println("example5 count = " + Exercises.example5(first, second));
    }
}
