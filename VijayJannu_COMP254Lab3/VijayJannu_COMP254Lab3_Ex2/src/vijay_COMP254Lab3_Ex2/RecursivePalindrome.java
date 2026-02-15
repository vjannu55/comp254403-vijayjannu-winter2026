package vijay_COMP254Lab3_Ex2;

import java.util.Scanner;

public class RecursivePalindrome {

    public static boolean isPalindrome(String s) {

        if (s.length() <= 1) {
            return true;
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Palindrome Checker ===");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("It is NOT a palindrome.");
        }

        sc.close();
    }
}
