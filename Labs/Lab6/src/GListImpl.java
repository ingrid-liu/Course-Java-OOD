public class GListImpl<G> implements GList<G>{
    G val;
    GListImpl<G> innerList;

    public GListImpl(G val) {
        this.val = val;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 815acbf4a521a2d69448a6e416ea914539534e61
    public GListImpl(G val, GListImpl<G> innerList) {
        this.val = val;
        this.innerList = innerList;
    }

    @Override
    public GList<G> add(G val) {
        if (innerList == null) {
            innerList = new GListImpl<>(val);
            return innerList;
        }
        return innerList.add(val);
    }

    @Override
    public int size() {
        if (innerList == null) {
            return 1;
        }
        int sizeOfInner = innerList.size();
        return 1 + sizeOfInner;
    }

    @Override
    public G getVal(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("The index is invalid");
        }
        if (index == 0) {
            return val;
        } else {
            return innerList.getVal(index-1);
        }
    }

    @Override
    public GList<G> getNext() {
        if (this.size() == 1) {
            return null;
        } else {
            return innerList;
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int find(G val) {

        int index = 0;
        int size = this.size();
        while (index < size) {
            if (getVal(0) == val) {
                return index;
            } else {
                index++;
                innerList.find(val);
            }
        }
        return -1;
    }

    public GListImpl<G> removeHead(boolean doRemove) {
        if (doRemove) {
            return this.innerList;
        } else {
            return this;
        }
    }

    @Override
    public GListImpl<G> remove(int index) throws IllegalArgumentException {
        if (index == 0) {
            return removeHead(true); // do want to remove the head
        } else {
            innerList = innerList.remove(index-1);
            return removeHead(false); // don't want to remove the head
        }
    }

    @Override
    public String toString() {
        if (innerList == null) {
            return val + " ";
        }
        String fromInnerList = innerList.toString();
        return this.val + " " + fromInnerList;
    }



}
