public class CircularlyLinkedList<E> {

    static class Node<E> {
        E element;
        Node<E> next;

        Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (tail == null) {
            newest.next = newest;
            tail = newest;
        } else {
            newest.next = tail.next;
            tail.next = newest;
            tail = newest;
        }
        size++;
    }

    // 🔹 CLONE METHOD
    public CircularlyLinkedList<E> clone() {
        CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
        if (tail == null) return other;

        Node<E> walk = tail.next;
        do {
            other.addLast(walk.element);
            walk = walk.next;
        } while (walk != tail.next);

        return other;
    }

    public void display() {
        if (tail == null) return;
        Node<E> curr = tail.next;
        do {
            System.out.print(curr.element + " ");
            curr = curr.next;
        } while (curr != tail.next);
        System.out.println();
    }
}
