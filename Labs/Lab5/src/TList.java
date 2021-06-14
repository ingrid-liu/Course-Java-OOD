public interface TList {
    /*
    TList objectName = new TListImpl();
    Return typeTList;
     */
    boolean add(String val); // Add val to end of list. Any String is OK
    String get(int index); // index is from 0 to n-1
    boolean isEmpty();
    String remove(int index); // index is from 0 to n-1
    // TNode removeStr(String str); // Not required; only for test. Plz ignore this part.
    int size();
    // TList oddWords(TList sentence); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.
    TList oddWords(); // Returns list of odd numbered words only

    // TList evenWords(TList sentence); // original, incorrect signature
    // The following may return a new list or modify the original, either is OK
    // position 0 is even, position 1 is odd, etc.
    TList evenWords(); // Returns list of even numbered words only
}
