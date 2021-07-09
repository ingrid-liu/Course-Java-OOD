public class TopScoreTrackerImpl implements TopScoreTracker, OrderedList<Integer> {
  Run player;
  // time is limited, my thought is to add Run (not integer score to the OrderedList
  // and compare the Run.score later
  OrderedList<Integer> monthlyRecord;
  OrderedList<Integer> yearlyRecord;

  public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
    // time is limited, my thought is to add Run (not integer score to the OrderedList
      this.monthlyRecord.resize(monthlyTopN);
      this.monthlyRecord.resize(yearlyTopM);
  }

  @Override
  public void addRun(int m, Run r) {
    // time is limited, my thought is to check the size of the monthlyRecord
    // if it is less than m, then add r. score to the OrderedList monthlyRecord
    //this.monthlyRecord.add(r.score);

  }

  @Override
  public String annualReport() {
    return null;
  }


  public TopScoreTrackerImpl() {
    super();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public Integer getMax() {
    return null;
  }

  @Override
  public void add(Integer val) {

  }

  @Override
  public OrderedList merge(OrderedList other) {
    return null;
  }

  @Override
  public void resize(int newCapacity) {

  }
}
