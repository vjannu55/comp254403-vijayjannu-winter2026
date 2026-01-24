public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> L = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> M = new DoublyLinkedList<>();

        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        M.addLast(4);
        M.addLast(5);

        L.concatenate(M);

        L.display();   // Output: 1 2 3 4 5
    }
}
