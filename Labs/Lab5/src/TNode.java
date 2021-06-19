/**
 *
 * @param <T>
 */
public class TNode<T> {
    public T val;
    public TNode<T> next;

    /**
     *
     */
    public TNode() {
        this.val = null;
        this.next = null;
    }

    /**
     *
     */
    public TNode(T val) {
        this.val = val;
        this.next = null;
    }

    /**
     *
     */
    public TNode(T val, TNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     *
     */
    public String toString(){
        return this.val + " ";
    }

    /**
     *
     */
    public T getDatatype() {
        return this.val;
    }

    /**
     *
     */
    public TNode<T> getNext() {
        return this.next;
    }
}
