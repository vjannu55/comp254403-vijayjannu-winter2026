package exercise1;

// Import LinkedList class from Java library
import java.util.LinkedList;

public class TestPositionalList {

    // Method to find the index of a given element in the list
    public static int indexOf(LinkedList<String> list, String element) {

        // Start index from 0
        int index = 0;

        // Loop through each element in the list
        for(String e : list) {

            // Check if the current element matches the target element
            if(e.equals(element)) {

                // If found, return the current index
                return index;
            }

            // Move to next index
            index++;
        }

        // If element not found, return -1
        return -1;
    }

    public static void main(String[] args) {

        // Create a LinkedList object
        LinkedList<String> list = new LinkedList<>();

        // Add elements into the list
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // Call the indexOf method to find position of element "C"
        int result = indexOf(list,"B");

        // Print the result
        System.out.println("Index of element B = " + result);

    }
}