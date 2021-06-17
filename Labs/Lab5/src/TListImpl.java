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
    private TNode<T> head;

    /**
     * This constructs a TListImpl with non parameter.
     */
    public TListImpl<T>() {
        this.head = new TNode<T>();
    }

    /**
     * This constructs a TListImpl with a specified val and TNode.
     * @param val xxxxxxxxxxxx
     * @param n xxxxxxxxxx
     */
    public TListImpl(T val, TNode<T> n) {
        this.val = val;
        this.head = n;
    }

    /**
     * The add method can take a val and add it to the TListImpl. //todo right?
     * @param val xxxxxxxxxxxx
     * @return xxxxxxxxxxxx
     */
    @Override
    public boolean add(T val) {         // todo change T to String or Object it will stop complaining
        if (head == null) {
            head = new TNode<T>(val, null);        // todo I should pass TNode a String val here (also line24:(
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
        assert currentPtr != null;      // todo Q: hint me to add this. can I do without it?
        return currentPtr.val;
        // todo ↑ should I define currentPtr as currentPtr<T>???
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * xxxxxxxxxxxx
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

    @Override
    public TList oddWords() {
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


    // todo try solve it with Hashtable
    @Override
    public TList evenWords() {
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







//public class TListImpl<T> implements TList<T>{
//    private TNode<T> head;
//
//    public TListImpl() {             // todo once add <T> it complains:(
//        this.head = new TNode<T>();
//    }
//
//    @Override
//    public boolean add(T val) {
//        return false;
//    }
//
//    @Override
//    public T get(int index) {
//        return null;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public T remove(int index) {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public TList oddTs() {
//        return null;
//    }
//
//    @Override
//    public TList evenTs() {
//        return null;
//    }
//}