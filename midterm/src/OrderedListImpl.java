public class OrderedListImpl<E extends Comparable<E>> implements OrderedList<E> {

  Node<E> head;

  public OrderedListImpl(int capacity) throws IllegalArgumentException {
    if (capacity < 0) throw new IllegalArgumentException("The capacity can't be negative: " + capacity);
    this.head = null;
  }


  @Override
  public E getMax() {
    if (this.head == null) return null;
    Node<E> curr = this.head, max = this.head;
    while (curr.next != null) {
      if (curr.val.compareTo(curr.next.val) > 0 ) {
        max = curr.next;
        curr = curr.next;
      }
    }
    return max.val;
  }

  @Override
  public void add(E val) {
    if (this.head == null) {
      this.head = new Node<>(val);
    }

    if (val.compareTo(this.head.val) <0 ){
    }

    Node<E> dummy = null;
    if (val.compareTo(this.head.val) > 0) {
      dummy.next = head.next;
    }
    Node<E> curr = dummy.next;
    while (val.compareTo(curr.val) >=0) {
      curr = curr.next;
    }
    Node temp = curr.next;
    curr.next.val = val;
    curr.next.next = temp;
    this.head = dummy.next;

  }

  private int size() {
    int counter = 0;
    Node<E> currentPtr = head;
    while (currentPtr != null) {
      counter++;
      currentPtr = currentPtr.next;
    }
    return counter;
  }


  @Override
  public OrderedList merge(OrderedList other) {
    if (!(other instanceof OrderedList)) {
      throw new IllegalArgumentException("The added object is not a OrderedList" + other.getClass());
    }

    int newSize = this.size() + ((OrderedListImpl<?>) other).size();
    OrderedListImpl mergedList = new OrderedListImpl(newSize);
    mergedList = (OrderedListImpl) other;
    Node curr = this.head;

    while (curr.next != null) {
      mergedList.add((Comparable) curr.val);
      curr = curr.next;
    }
    mergedList.add((Comparable) curr.val);

    return mergedList;
  }

  @Override
  public void resize(int newCapacity) {
    if (this.size() <= newCapacity) {
      // do nothing
    } else{
      Node<E> dummy = head;
      Node<E> tail = dummy;
      for (int i = newCapacity - 1; i > 0; i--) {
        tail = tail.next;
      }
      tail.next = null;
      this.head = dummy;
    }

  }


  @Override
  public String toString() {
  StringBuilder res = new StringBuilder();
  Node<E> currentPtr = head;
  res.append("[");
  while (currentPtr != null) {
    res.append(currentPtr);
    currentPtr = currentPtr.next;
  }
  res.append("]");
  return res.toString();
  }



  public Node<E> getHead() {
    return head;
  }

  public void setHead(Node<E> head) {
    this.head = head;
  }


}
