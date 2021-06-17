public interface TList<T> {
    boolean add(T val); // Add val to end of list. Any T (type) is OK
    T get(int index); // index is from 0 to n-1
    boolean isEmpty();
    T remove(int index); // index is from 0 to n-1
    int size();
    // SList oddTs(TList); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.
    TList<T> oddTs(); // Returns list of odd numbered Ts only
    // TList evenTs(TList); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.
    TList<T> evenTs(); // Returns list of even numbered Ts only
}
