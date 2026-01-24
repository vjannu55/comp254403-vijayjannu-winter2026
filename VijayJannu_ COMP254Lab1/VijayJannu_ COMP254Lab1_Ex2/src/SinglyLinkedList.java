public class SinglyLinkedList<E> {

    static class Node<E> {
        E element;
        Node<E> next;

        Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }

    private Node<E> head = null;

    public void addFirst(E e) {
        head = new Node<>(e, head);
    }

    public Node<E> getHead() {
        return head;
    }

    // 🔹 SWAP NODES METHOD
    public void swapNodes(Node<E> node1, Node<E> node2) {

        if (node1 == node2) return;

        Node<E> prev1 = null, prev2 = null, curr = head;

        while (curr != null && (prev1 == null || prev2 == null)) {
            if (curr.next == node1) prev1 = curr;
            if (curr.next == node2) prev2 = curr;
            curr = curr.next;
        }

        if (node1 == head) prev1 = null;
        if (node2 == head) prev2 = null;

        if (node1 == head) head = node2;
        else prev1.next = node2;

        if (node2 == head) head = node1;
        else prev2.next = node1;

        Node<E> temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    }

    public void display() {
        Node<E> curr = head;
        while (curr != null) {
            System.out.print(curr.element + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
