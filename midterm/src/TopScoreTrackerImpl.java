public class TopScoreTrackerImpl implements TopScoreTracker {
  Run player;
  // time is limited, my thought is to add Run (not integer sCore to the OrderedList
  // and compare the Run.score later
  OrderedList<Run> monthlyRecord;
  OrderedList<Run> yearlyRecord;


  public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
    // time is limited, my thought is to add Run (not integer score to the OrderedList
      this.monthlyRecord.resize(monthlyTopN);
      this.yearlyRecord.resize(yearlyTopM);
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




}
