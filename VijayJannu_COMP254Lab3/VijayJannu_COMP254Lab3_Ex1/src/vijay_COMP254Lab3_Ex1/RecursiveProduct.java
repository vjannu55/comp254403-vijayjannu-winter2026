package vijay_COMP254Lab3_Ex1;

import java.util.Scanner;

public class RecursiveProduct {

    // Recursive method
    public static int multiply(int m, int n) {

        if (m == 0) {   // Base case
            return 0;
        }

        return n + multiply(m - 1, n);  // Recursive case
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Recursive Product Calculator ===");

        System.out.print("Enter first positive integer: ");
        int m = sc.nextInt();

        System.out.print("Enter second positive integer: ");
        int n = sc.nextInt();

        int result = multiply(m, n);

        System.out.println("Product = " + result);

        sc.close();
    }
}
