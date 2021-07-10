import com.sun.security.jgss.GSSUtil;

public class OrderedListImpl<E extends Comparable<E>> implements OrderedList<E> {

  Node<E> head;
  int capacity;

  public OrderedListImpl(int capacity) throws IllegalArgumentException {
    if (capacity < 0) throw new IllegalArgumentException("The capacity can't be negative: " + capacity);
    this.head = null;
    this.capacity = capacity;
  }


  @Override
  public E getMax() {
    if (this.head == null) return null;
    // if we assume the list is always ordered in nondecreasing order
    Node<E> curr = this.head;
    while (curr.next != null ) curr = curr.next;
    return curr.val;
  }

  @Override
  public void add(E val) {
    Node<E> curr = this.head;
    Node<E> newNode = new Node<E>(val);
    Node<E> pre = new Node<E>(null, curr);

    // 1. when the list is empty
    if (this.head == null) {
      this.head = new Node<>(val, null);
      return;
    }

    // 2. when the list is not empty && not full: compare the val and insert a node
    if (!isFull()) {
      if (newNode.val.compareTo(curr.val) < 0) {
        pre.next = newNode;
        newNode.next = this.head;
        this.head = pre.next;
      }
      while (curr.next != null && newNode.val.compareTo(curr.val) > 0) {
        curr = curr.next;
        pre = pre.next;
      }
      if (newNode.val.compareTo(curr.val) <= 0) {
        // System.out.println("when target position has a node");
        Node<E> temp = curr;
        pre.next = newNode;
        newNode.next = temp;
      } else if (curr.next == null){
        // System.out.println("target position is null");
        curr.next = newNode;
      }
    }

    // 3. when the list is  full: (1)cut head (2)move forward (3)call add->when it's not full
    else {
      OrderedListImpl<E> newOrderedList = new OrderedListImpl<>(this.capacity);
      newOrderedList.head = this.head.next;
      // System.out.println("new list: " + newOrderedList.toString());
      newOrderedList.add(val);
      this.head = newOrderedList.head;
    }
  }

  private boolean isFull() {

    if (this.capacity <= this.size()) {
      return true;
    } else return false;
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
//    if (!(other instanceof OrderedList)) {
//      throw new IllegalArgumentException("The added object is not a OrderedList" + other.getClass());
//    }
    //todo Question: do I need to deal with this and other's E type is different or not?
    int newCapacity = (this.capacity + ((OrderedListImpl<?>) other).capacity);
    OrderedList<E> mergedList = new OrderedListImpl<>(newCapacity);


    Node<E> thisCurr = this.head;
    Node<E> otherCurr = ((OrderedListImpl<E>) other).head;

    //mergedList = (OrderedListImpl<E>) other;  // ※ I shouldn't assign other to mergedList, I should add node by node!!
    while (otherCurr != null) {
      mergedList.add(otherCurr.val);
      otherCurr = otherCurr.next;
    }
    while (thisCurr.next != null) {
      mergedList.add(thisCurr.val);
      thisCurr = thisCurr.next;
    }
    mergedList.add(thisCurr.val);

    return mergedList;
  }

  @Override
  public void resize(int newCapacity) {
    // 1. new size = original size
    if (this.size() == newCapacity) return;
    // 2. new size > original size: add null node
    if (this.size() < newCapacity){
      OrderedList<E> mergedList = new OrderedListImpl<>(newCapacity);

      this.capacity = newCapacity;    // so interesting!!(๑•̀ㅂ•́)و✧
      this.merge(mergedList);
    }
    // 3. new size < original size: maintain from the tail
    if (this.size() > newCapacity){

      this.capacity = newCapacity;
      Node<E> dummy = new Node<>(null, head);
      Node<E> tail = dummy;
      for (int i = capacity; i > 0; i--) {
        tail = tail.next;
      } // until now, head & tail's distance is capacity;

      while(tail.next != null) {
        dummy = dummy.next;
        tail = tail.next;
      }
      this.head = dummy.next;
    }
  }


  @Override
  public String toString() {

  StringBuilder res = new StringBuilder();
  Node<E> currentPtr = head;
  res.append("[");
  int counter = 0;
  while (currentPtr != null) {
    res.append(currentPtr.val.toString() + " ");
    counter++;
    currentPtr = currentPtr.next;
  }
  if (counter < this.capacity) {
    for (int i = (this.capacity - counter); i > 0; i--){
      res.append(new Node<>().toString() + " ");
    }
  }
  // todo Question: smarter way to trim the tailing whitespace?
  // res.toString().stripTrailing();
  // res.toString().replaceAll("[ \t]+$", "");
  StringBuilder res2 = new StringBuilder();
  res2.append(res.toString().stripTrailing());

  res2.append("]");
  return res2.toString();
  }



  public Node<E> getHead() {
    return head;
  }

  public void setHead(Node<E> head) {
    this.head = head;
  }
  public static void main(String[] args) {
    System.out.println("main function in OrderedListImpl runs...");

    System.out.println("\n****** constructor *******");
    OrderedList<Integer> test1 = new OrderedListImpl<>(3);
    System.out.println(test1.toString());

    System.out.println("\n****** add method *******");
    OrderedList<Integer> test2 = new OrderedListImpl<>(3);
    test2.add(2);
    System.out.println(test2.toString());
    test2.add(7);
    System.out.println(test2.toString());
    test2.add(5);
    System.out.println(test2.toString());

    test2.add(3);
    System.out.println(test2.toString());

    System.out.println("Now the Max is: " + test2.getMax());

    System.out.println("\n********** merge method ***************");
    OrderedList<Integer> list1 = new OrderedListImpl<Integer>(3);
    OrderedList<Integer> list2 = new OrderedListImpl<Integer>(4);

    list1.add(5);
    list1.add(2);
    list2.add(3);
    list2.add(8);
    list2.add(1);
    System.out.println("list1: " + list1.toString());
    System.out.println("list2: " + list2.toString());
    OrderedList<Integer> list3 = list1.merge(list2);
    System.out.println("After merging: " + list3.toString());

    System.out.println("\n********** merge empty method***************");
    OrderedList<Integer> list4 = new OrderedListImpl<Integer>(3);
    OrderedList<Integer> list5 = new OrderedListImpl<Integer>(4);

    list4.add(5);
    list4.add(2);

    System.out.println("list1: " + list4.toString());
    System.out.println("list2: " + list5.toString());
    OrderedList<Integer> list6 = list4.merge(list5);
    System.out.println("After merging: " + list6.toString());



    System.out.println("\n********** resize method ***************");
    list3.resize(7);
    System.out.println(list3.toString());

    list3.resize(8);
    System.out.println(list3.toString());

    list3.resize(3);
    System.out.println(list3.toString());

  }

}
