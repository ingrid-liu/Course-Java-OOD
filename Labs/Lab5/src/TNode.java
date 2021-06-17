public class TNode<T> {
    public T val;
    public TNode<T> next;

    public TNode<T>() {
        this.val = null;            // todo
        this.next = null;
    }
    public TNode<T>(T val) {
        this.val = val;
        this.next = null;
    }

    public TNode<T>(T val, TNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public String toString(){
        return this.val + " ";
    }

//    public T getVal() {
//        return val;
//    }
//
//    public TNode<T> getNext() {
//        return next;
    }
}
