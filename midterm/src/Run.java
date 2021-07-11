// One run of the game.
// You are allowed to make whatever change you want to this class.

import java.util.Comparator;

public class Run implements Comparable<Run>{
// public class Run {
  private int id; // the id of the gameplay
  private int score; // the score of this run

  public Run(int id, int score) {
    this.id = id;
    this.score = score;
  }

  @Override
  public int compareTo(Run another){
    if (this.score > another.score) return 1;
    if (this.score == another.score) return 0;
    else return -1;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String toString(){
    // [(4, 14) (4, 15) (4, 16) (4, 18) (4, 22)]
    return "(" + this.id + ", " + this.score + ")";
  }

}
