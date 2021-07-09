import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class SampleGradingTests {
  @Test
  public void TestConstructor1() {
    Assert.assertEquals(new OrderedListImpl<Integer>(3).toString(), "[? ? ?]");
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestConstructor2() {
    Assert.assertEquals(new OrderedListImpl<Integer>(-1).toString(), "[]");
  }

  @Test
  public void TestAdd1() {
    OrderedList<Integer> list = new OrderedListImpl<Integer>(3);
    list.add(2);
    Assert.assertEquals(list.toString(), "[2 ? ?]");
    list.add(7);
    list.add(5);
    Assert.assertEquals(list.toString(), "[2 5 7]");
    list.add(3);
    Assert.assertEquals(list.toString(), "[3 5 7]");
  }

  @Test
  public void TestMax() {
    OrderedList<Integer> list = new OrderedListImpl<Integer>(3);
    Assert.assertEquals(list.getMax(), null);
    list.add(2);
    Assert.assertEquals(list.getMax(), new Integer(2));
    list.add(9);
    Assert.assertEquals(list.getMax(), new Integer(9));
  }

  @Test
  public void TestMerge() {
    OrderedList<Integer> list1 = new OrderedListImpl<Integer>(3);
    OrderedList<Integer> list2 = new OrderedListImpl<Integer>(4);

    list1.add(2);
    list1.add(5);
    list2.add(1);
    list2.add(3);
    list2.add(8);

    OrderedList<Integer> list3 = list1.merge(list2);

    Assert.assertEquals( "[1 2 3 5 8 ? ?]", list3.toString());
  }

  @Test
  public void TestResize() {
    OrderedList<Integer> list = new OrderedListImpl<Integer>(7);
    list.add(2);
    list.add(5);
    list.add(1);
    list.add(3);
    list.add(8);
    Assert.assertEquals( "[1 2 3 5 8 ? ?]", list.toString());
    list.resize(3);
    Assert.assertEquals( "[3 5 8]", list.toString());
  }

  @Test
  public void TestTracker() {
    TopScoreTracker tracker = new TopScoreTrackerImpl(2, 5);
    tracker.addRun(1, new Run(4, 12));
    tracker.addRun(1, new Run(4, 13));
    tracker.addRun(1, new Run(4, 16));
    tracker.addRun(1, new Run(4, 10));
    tracker.addRun(1, new Run(4, 11));
    tracker.addRun(2, new Run(4, 12));
    tracker.addRun(2, new Run(4, 11));
    tracker.addRun(3, new Run(4, 18));
    tracker.addRun(3, new Run(4, 22));
    tracker.addRun(3, new Run(4, 9));
    tracker.addRun(4, new Run(4, 12));
    tracker.addRun(5, new Run(4, 2));
    tracker.addRun(5, new Run(4, 3));
    tracker.addRun(6, new Run(4, 8));
    tracker.addRun(6, new Run(4, 9));
    tracker.addRun(6, new Run(4, 15));
    tracker.addRun(7, new Run(4, 14));
    tracker.addRun(7, new Run(4, 13));
    tracker.addRun(8, new Run(4, 14));
    tracker.addRun(8, new Run(4, 13));
    tracker.addRun(9, new Run(4, 14));
    tracker.addRun(9, new Run(4, 13));
    tracker.addRun(9, new Run(4, 14));
    tracker.addRun(10, new Run(4, 13));
    tracker.addRun(10, new Run(4, 14));
    tracker.addRun(10, new Run(4, 13));

    assertEquals("[(4, 14) (4, 15) (4, 16) (4, 18) (4, 22)]", tracker.annualReport());
  }
}