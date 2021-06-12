public class SListImpl implements SList {
    private SNode head;

    public SListImpl() {
        this.head = null;
    }

    public SListImpl(SNode n) {
        this.head = n;
    }

    @Override
    public boolean add(String word) {
        if (head == null) {
            head = new SNode(word, null);
            return true;
        }
        SNode currentPtr = head;
        while (currentPtr.next != null) {
            currentPtr = currentPtr.next;
        }
        currentPtr.next = new SNode(word, null);
        return true;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        SNode currentPtr = head;
        while (currentPtr != null && pos != index) {
            pos++;
            currentPtr = currentPtr.next;
        }
        assert currentPtr != null;      // todo Q: hint me to add this. can I do without it?
        return currentPtr.word;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index should be from 0 to n-1");
        }
        int pos = 0;
        SNode currentPtr = head;
        SNode prevPtr = null;
        while (pos != index) {
            pos++;
            prevPtr = currentPtr;
            currentPtr = currentPtr.next;
        }
        if (prevPtr == null) {
            head = currentPtr.next;
            return currentPtr.word;
        }

        prevPtr.next = currentPtr.next;
        return currentPtr.word;
    }

    @Override
    public int size() {
        int counter = 0;
        SNode currentPtr = head;
        while (currentPtr != null) {
            counter++;
            currentPtr = currentPtr.next;
        }
        return counter;
    }

    @Override
    public SList oddWords() {
        if(head==null){
            throw new IllegalArgumentException("The list is empty, so there's no oddWords");
        }
        SNode currentPtr = head.next;
        SListImpl oddList = new SListImpl();

        while (currentPtr != null ) {
            oddList.add(currentPtr.word);
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
    public SList evenWords() {
        if(head==null){
            throw new IllegalArgumentException("The list is empty, so there's no evenWords");
        }
        SNode currentPtr = head;
        SListImpl evenList = new SListImpl();

        while (currentPtr != null ) {
            evenList.add(currentPtr.word);
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
        SNode currentPtr = head;

        while (currentPtr != null) {
            res.append(currentPtr);
            currentPtr = currentPtr.next;
        }

        return res.toString();
    }

    /**
     * removeStr: only for test, please ignore this method
     * @param: word
     * @return SNode
     */
    @Override
    public SNode removeStr(String word) {
        SNode dummy = new SNode("\0", null);
        SNode newListPtr = dummy;
        SNode currentPtr = head;

//// Attempt1 (Prof's way:) doesn't work for the last node
//        while(currentPtr != null) {
//            if (currentPtr.word.equals(word)) {
//                System.out.println("MEET TARGET: " + currentPtr.word);
//            }else {
//                newListPtr.next = currentPtr;
//                newListPtr = newListPtr.next;
//                System.out.println("Here2: " + newListPtr.word);
//            }
//            currentPtr = currentPtr.next;
//            System.out.println("Here3: " + currentPtr.word);
//        }
//        System.out.println("Here5: " + newListPtr.word);
//        return dummy.next;

// Attempt2 (Updated:) Q: is it necessary to check whether currentPtr==null
// inside of the while loop?

        while (currentPtr != null){
            if (currentPtr.word.equals(word)) {     //currentPtr.word == word
                currentPtr = currentPtr.next;
            }
            if (currentPtr == null) {
                newListPtr.next = null;
            }else {
                newListPtr.next = currentPtr;
                newListPtr = newListPtr.next;
                currentPtr = currentPtr.next;
            }
        }
        return dummy.next;


    }
}

