package exercise3;

// Import Queue and LinkedList classes
import java.util.LinkedList;
import java.util.Queue;

public class QueueConcatenate {

    // Method to concatenate Queue Q2 into Queue Q1
    public static void concatenate(Queue<Integer> Q1, Queue<Integer> Q2) {

        // Continue until Q2 becomes empty
        while(!Q2.isEmpty()) {

            // Remove element from Q2
            int element = Q2.remove();

            // Add that element to Q1
            Q1.add(element);

        }

    }

    public static void main(String[] args) {

        // Create Queue Q1 and Q2
        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();

        // Insert elements into Q1
        Q1.add(1);
        Q1.add(2);

        // Insert elements into Q2
        Q2.add(3);
        Q2.add(4);

        // Call concatenate method
        concatenate(Q1,Q2);

        // Display results
        System.out.println("Q1 after concatenate: " + Q1);
        System.out.println("Q2 after concatenate: " + Q2);

    }
}