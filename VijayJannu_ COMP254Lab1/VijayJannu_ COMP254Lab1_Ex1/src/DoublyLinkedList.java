public class DoublyLinkedList<E> {

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, trailer.prev, trailer);
        trailer.prev.next = newest;
        trailer.prev = newest;
        size++;
    }

    // 🔹 CONCATENATION METHOD
    public void concatenate(DoublyLinkedList<E> M) {
        if (M.size == 0) return;

        Node<E> lastL = this.trailer.prev;
        Node<E> firstM = M.header.next;

        lastL.next = firstM;
        firstM.prev = lastL;

        this.trailer = M.trailer;
        this.size += M.size;
    }

    public void display() {
        Node<E> current = header.next;
        while (current != trailer) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
}
