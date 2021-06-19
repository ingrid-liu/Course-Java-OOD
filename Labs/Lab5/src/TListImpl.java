/**
 * This class is implements a TList that create a list with element in type T.
 * @author Xiaoying 'Ingrid' Liu
 * @version 1.0
 */

/**
 *
 * @param <T> the type of the parameter
 */
public class TListImpl<T> implements TList<T> {
//    public T val;
    public TNode<T> head;

    /**
     * This constructs a TListImpl with non parameter.
     */
    public TListImpl() {
        this.head = null;
    }

    /**
     * This constructs a TListImpl with a specified val and TNode.
     * @param newNode xxxxxxxxxx
     */
    public TListImpl(TNode<T> newNode) {
        this.head = newNode;
    }

    /**
     * The add method can take a val and add it to the TListImpl. //todo right?
     * @param val xxxxxxxxxxxx
     * @return xxxxxxxxxxxx
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
        currentPtr.next = new TNode<T>(val, null);
        return true;
    }

    /**
     * The get method takes an integer as an index and return the value of that index in the TList.
     * @param index xxxxxxxxxxxx
     * @return xxxxxxxxxxxx
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

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     *  remove
     * @param index xxxxxxxxxxxx
     * @return xxxxxxxxxxxx
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
     * size
     * @return
     */
    @Override
    public int size() {
        int counter = 0;
        TNode currentPtr = head;
        while (currentPtr != null) {
            counter++;
            currentPtr = currentPtr.next;
        }
        return counter;
    }

    /**
     * oddTs
     * @return
     */
    @Override
    public TList oddTs() {
        if(head==null){
            throw new IllegalArgumentException("The list is empty, so there's no oddWords");
        }
        TNode<T> currentPtr = head.next;
        TListImpl<T> oddList = new TListImpl<T>();

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
     * evenTs
     * @return
     */
    @Override
    public TList evenTs() {
        if(head==null){
            throw new IllegalArgumentException("The list is empty, so there's no evenWords");
        }
        TNode<T> currentPtr = head;
        TListImpl<T> evenList = new TListImpl<T>();

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
