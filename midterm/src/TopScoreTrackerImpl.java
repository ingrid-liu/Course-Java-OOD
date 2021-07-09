public class TopScoreTrackerImpl implements TopScoreTracker, OrderedList<Integer> {
  //Run record;

  OrderedList<Integer> monthlyRecord;
  OrderedList<Integer> yearlyRecord;

  public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
      this.monthlyRecord.resize(monthlyTopN);
      this.monthlyRecord.resize(yearlyTopM);
  }

  @Override
  public void addRun(int m, Run r) {
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
