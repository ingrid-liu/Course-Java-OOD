public class Node<E>{
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
        StringBuilder res = new StringBuilder();
        if (this.val == null) {
            res.append("?");
        } else {
           // res.append(" ");
            res.append((String)this.val);   // todo right?
        }

        return res.toString();
    }

    public E getVal() {
        return this.val;
    }


    public Node<E> getNext() {
        return this.next;
    }

//    @Override
//    public int compareTo(Node<E> another) {
//        if ((Integer)this.val > (Integer)another.val) return 1;
//        else return -1;
//    }


//    public int compareTo(Node<E> another){
//        // compare Node.val
//        if (this.val > another.val) return 1;
//        else return -1;
//        //obj.compareTo(otherObj) >/< 0
//
//    }




}
