public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        SinglyLinkedList.Node<Integer> node1 = list.getHead().next;       // 2
        SinglyLinkedList.Node<Integer> node2 = list.getHead().next.next; // 3

        list.swapNodes(node1, node2);
        list.display();  // Output: 1 3 2 4 5
    }
}
