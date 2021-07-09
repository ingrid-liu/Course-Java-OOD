public class Node<E> {
    public E val;
    public Node<E> next;

    public Node() {
        this.val = null;
        this.next = null;
    }

    public Node(E val) {
        this.val = val;
        this.next = null;
    }

    public Node(E val, Node<E> next) {
        this.val = val;
        this.next = next;
    }

    public String toString(){
        return this.val + " ";
    }

    public E getVal() {
        return this.val;
    }


    public Node<E> getNext() {
        return this.next;
    }
}
