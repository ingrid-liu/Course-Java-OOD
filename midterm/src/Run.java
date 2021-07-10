// One run of the game.
// You are allowed to make whatever change you want to this class.
public class Run implements Comparable<Run>{
  private int id; // the id of the gameplay
  private int score; // the score of this run

  public Run(int id, int score) {
    this.id = id;
    this.score = score;
  }
  @Override
  public int compareTo(Run another){
    // compare run.score
    if (this.score > another.score) return 1;
    else return -1;
    //obj.compareTo(otherObj) >/< 0

  }
}
