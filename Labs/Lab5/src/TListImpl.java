/**
 * This class implements a TList that creates a list with element in type T.
 *
 * @author Xiaoying 'Ingrid' Liu
 * @version 1.0
 */

public class TListImpl<T> implements TList<T> {

    /**
     * This defines the 'head' argument of the TList.
     */
    public TNode<T> head;

    /**
     * This constructs a TListImpl with non parameter.
     */
    public TListImpl() {
        this.head = null;
    }

    /**
     * This constructs a TListImpl with a specified val and TNode.
     *
     * @param newNode a TNode in T type
     */
    public TListImpl(TNode<T> newNode) {
        this.head = newNode;
    }

    /**
     * The add method can take a value in T type and add it to the TListImpl.
     *
     * @param val a value of the Node in T type.
     * @return true if added successful, false otherwise
     */
    @Override
    public boolean add(T val) {
        if (head == null) {
            head = new TNode<>(val, null);
            return true;
        }
        TNode<T> currentPtr = head;
        while (currentPtr.next != null) {
            currentPtr = currentPtr.next;
        }
        currentPtr.next = new TNode<>(val, null);
        return true;
    }

    /**
     * The get method takes an integer as an index and
     * return the value of that index in the TList.
     *
     * @param index index of the TList
     * @return the Node's value in T type
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        TNode<T> currentPtr = head;
        while (currentPtr != null && pos != index) {
            pos++;
            currentPtr = currentPtr.next;
        }
        assert currentPtr != null;
        return currentPtr.val;
    }

    /**
     * The isEmpty method checks whether the TList is null or not.
     *
     * @return true if is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * The remove() method takes an integer as an index and
     * remove the node in that index from the TList.
     *
     * @param index in the TList
     * @return the current Node's value in T type
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index should be from 0 to n-1");
        }
        int pos = 0;
        TNode<T> currentPtr = head;
        TNode<T> prevPtr = null;
        while (pos != index) {
            pos++;
            prevPtr = currentPtr;
            currentPtr = currentPtr.next;
        }
        if (prevPtr == null) {
            head = currentPtr.next;
            return currentPtr.val;
        }

        prevPtr.next = currentPtr.next;
        return currentPtr.val;
    }

    /**
     * The size() method returns an integer which is the size of the TList.
     *
     * @return an int of the NList's size
     */
    @Override
    public int size() {
        int counter = 0;
        TNode<T> currentPtr = head;
        while (currentPtr != null) {
            counter++;
            currentPtr = currentPtr.next;
        }
        return counter;
    }

    /**
     * The oddTs() method returns a TList with the Node in odd index.
     *
     * @return TList
     */
    @Override
    public TList<T> oddTs() {
        if(head==null){
            throw new IllegalArgumentException(
                    "The list is empty, so there's no oddWords");
        }
        TNode<T> currentPtr = head.next;
        TListImpl<T> oddList = new TListImpl<>();

        while (currentPtr != null ) {
            oddList.add(currentPtr.val);
            if (currentPtr.next != null && currentPtr.next.next != null) {
                currentPtr = currentPtr.next.next;
            }else {
                break;
            }
        }
        return oddList;
    }


    /**
     * The evenTs method returns a TList with the Node in even index.
     *
     * @return Tlist
     */
    @Override
    public TList<T> evenTs() {
        if(head==null){
            throw new IllegalArgumentException("The list is empty, so there's no evenWords");
        }
        TNode<T> currentPtr = head;
        TListImpl<T> evenList = new TListImpl<>();

        while (currentPtr != null ) {
            evenList.add(currentPtr.val);
            if (currentPtr.next != null && currentPtr.next.next != null) {
                currentPtr = currentPtr.next.next;
            }else {
                break;
            }
        }
        return evenList;
    }

    /**
     * The toString() method returns a string of the expression of the TList.
     *
     * @return String the expression of the TListImpl
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        TNode<T> currentPtr = head;

        while (currentPtr != null) {
            res.append(currentPtr);
            currentPtr = currentPtr.next;
        }

        return res.toString();
    }
}
