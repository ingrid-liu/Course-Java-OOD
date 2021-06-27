public class GListImpl<G> implements GList<G>{
    G val;
    GListImpl<G> innerList;

    public GListImpl(G val) {
        this.val = val;
    }
    
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
        return null;
    }


    @Override
    public GList<G> getNext() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public int find(G val) {
        return 0;
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
