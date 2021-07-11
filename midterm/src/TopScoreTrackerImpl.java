import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.*;

public class TopScoreTrackerImpl implements TopScoreTracker {
  /** solution I: built-in LinkedList Class:*/
//  LinkedList<Run> yearlyRanking = new LinkedList<>();
//  // LinkedList<Run> monthlyRanking;
//  int monthlyTopN;
//  int yearlyTopM;

  /** solution II: OrderedListImpl*/
  OrderedList<Run> yearlyRanking;
  // LinkedList<Run> monthlyRanking;
  int monthlyTopN;
  int yearlyTopM;


  public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
    /** solution I: built-in LinkedList Class:*/
//    this.monthlyTopN = monthlyTopN;
//    this.yearlyTopM = yearlyTopM;
////    this.monthlyRanking = new OrderedListImpl<>(monthlyTopN);
////    this.yearlyRanking = new OrderedListImpl<>(yearlyTopM);

    /** solution II: OrderedListImpl*/
    this.monthlyTopN = monthlyTopN;
    this.yearlyTopM = yearlyTopM;
    yearlyRanking = new OrderedListImpl<>(yearlyTopM);
  }

  @Override
  public void addRun(int m, Run r) {
    //if (m < 1 || m > 12) throw new IllegalArgumentException("Month should between 1-12: " + m);
    /** solution I: built-in LinkedList Class:(still trying) */
//     yearlyRanking.add(r);

    /** solution II: OrderedListImpl*/
    yearlyRanking.add(r);

  }


  @Override
  public String annualReport() {
    /** solution I: built-in LinkedList Class: (still trying) */
//    this.yearlyRanking = yearlyRanking.sort(Comparator.comparing());
//    return this.yearlyRanking.toString();

    /** solution II: OrderedListImpl*/
    return this.yearlyRanking.toString();

  }

  @Override
  public String toString(){
    if (this.yearlyRanking == null) return "[]";
//    return this.Ranking.toString();

    return this.yearlyRanking.toString();
  }

//  @Override
//  public String toString() {
//    //1. Ranking is empty
//    if (this.Ranking == null) return null;
//
//    StringBuilder res = new StringBuilder();
////    Node<Run> currRecord = this.Ranking.head;
////    int counter = 0;
//    //2. Ranking only contains 1 record
////    if (currRecord.next == null) return "[" + currRecord + "]";
//    if (this.Ranking.size() == 1) return "[" + this.Ranking.getFirst() + "]";
//
//
//    //3. Ranking contains more than 1 records
//    res.append("[");
//    Run currRecord = this.Ranking.getFirst();
//    for (int i = 0; i < this.Ranking.size(); i++) {
//      res.append(currRecord.toString()).append(" ");
//    }
////    while (currRecord != null) {
////      res.append(currRecord.toString() + " ");
//////      counter++;
////      currRecord = currRecord.next;
////    }
////    res.append(currRecord.val.toString() + "]");
//
//
//
//    return res.toString();
//  }



  public static void main(String[] args) {
    Run run2 = new Run(4, 16);
    Run run1 = new Run(4, 12);
    System.out.println("run1: " + run1);

    LinkedList<Run> R1 = new LinkedList<>();
    System.out.println(R1);
    R1.add(run1);
    System.out.println(R1);
    R1.add(new Run(4, 22));
    System.out.println(R1);

    System.out.println("************ test ***********");
    TopScoreTracker test = new TopScoreTrackerImpl(2, 5);
    System.out.println("initialized: " + test.toString());
    test.addRun(4, run1);
    System.out.println(test.toString());

    System.out.println("************ Tracker **********");
    TopScoreTracker tracker = new TopScoreTrackerImpl(2, 5);
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

    System.out.println(tracker.annualReport());


  }


}
