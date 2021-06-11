public interface SList {
    /*
    SList objectName = new SListImpl();
    Return type SList;
     */
    boolean add(String val); // Add val to end of list. Any String is OK
    String get(int index); // index is from 0 to n-1
    boolean isEmpty();
    String remove(int index); // index is from 0 to n-1
    int size();
    // SList oddWords(SList sentence); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.
    SList oddWords(); // Returns list of odd numbered words only

    // SList evenWords(SList sentence); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.
    SList evenWords(); // Returns list of even numbered words only
}
