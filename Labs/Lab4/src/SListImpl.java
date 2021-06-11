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
        SNode currentPtr = head.next;
        if(currentPtr == null){
            return null;
        }

        SListImpl oddList = new SListImpl();
        if (size() < 2) {
            oddList.add(currentPtr.word);
            return oddList;
        }

        oddList.add(currentPtr.word);
        while (currentPtr.next.next != null ) {
            currentPtr = currentPtr.next.next;
            oddList.add(currentPtr.word);
        }

        return oddList;
    }

    @Override
    public SList evenWords() {
        SNode currentPtr = head;
        if(currentPtr == null){
            return null;
        }

        SListImpl evenList = new SListImpl();
        if (size() < 2) {
            evenList.add(currentPtr.word);
            return evenList;
        }

        evenList.add(currentPtr.word);
        while (currentPtr.next.next != null ) {
            currentPtr = currentPtr.next.next;
            evenList.add(currentPtr.word);
        }
        return evenList;
    }

    public String toString() {
        String res = "";
        SNode currentPtr = head;

        while (currentPtr != null) {
            res = res + currentPtr.toString();
            currentPtr = currentPtr.next;
        }

        return res;
    }
}

