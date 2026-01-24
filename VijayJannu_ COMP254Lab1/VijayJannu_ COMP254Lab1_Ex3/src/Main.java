public class Main {
    public static void main(String[] args) {

        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        CircularlyLinkedList<Integer> cloned = list.clone();

        cloned.display(); // Output: 10 20 30
    }
}
