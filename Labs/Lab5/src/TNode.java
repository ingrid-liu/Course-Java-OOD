/**
 * This class creates a TNode in type T.
 *
 * @author Xiaoying 'Ingrid' Liu
 * @version 1.0
 */

public class TNode<T> {
    public T val;
    public TNode<T> next;

    /**
     * This constructor initialized one node with a null value for its
     * current node and null value for its next.
     */
    public TNode() {
        this.val = null;
        this.next = null;
    }

    /**
     * This constructor initialized one node with its current value and
     * makes its next node as null.
     *
     * @param val current node's value
     */
    public TNode(T val) {
        this.val = val;
        this.next = null;
    }

    /**
     * This constructor initialized one node with its current value and
     * its next value in type T.
     *
     * @param val current node's value
     * @param next next node's value
     */
    public TNode(T val, TNode<T> next) {
        this.val = val;
        this.next = next;
    }

    /**
     * This toString method returns the expression of the current node.
     *
     * @return a string
     */
    public String toString(){
        return this.val + " ";
    }

    /**
     * This getVal method returns the current node's value.
     *
     * @return this.val
     */
    public T getVal() {
        return this.val;
    }

    /**
     * This getNext() method returns the next dode in the TNode.
     *
     * @return this.next
     */
    public TNode<T> getNext() {
        return this.next;
    }
}
