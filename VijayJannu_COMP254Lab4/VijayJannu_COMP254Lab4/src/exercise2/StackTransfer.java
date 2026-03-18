package exercise2;

// Import Stack class
import java.util.Stack;

public class StackTransfer {

    // Method to transfer elements from Stack S to Stack T
    public static void transfer(Stack<Integer> S, Stack<Integer> T) {

        // Continue until Stack S becomes empty
        while(!S.isEmpty()) {

            // Remove element from Stack S
            int element = S.pop();

            // Insert that element into Stack T
            T.push(element);

        }

    }

    public static void main(String[] args) {

        // Create two stacks S and T
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();

        // Push elements into Stack S
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

        // Call transfer method
        transfer(S,T);

        // Display Stack T after transfer
        System.out.println("Stack T after transfer: " + T);

    }
}