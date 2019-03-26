// ThreeDiceScorer class
// extends ThreeDice and scores rolls

public class ThreeDiceScorer extends ThreeDice {

    // ATTRIBUTES
    private int sumOfDice;
    private int score;

    // CONSTRUCTOR
    // constructor calls ThreeDice constructor and sets score
    public ThreeDiceScorer(int s1, int s2, int s3) {
        super(s1, s2, s3);
    }

    // METHODS
    // accessor method returns score
    public int getScore() {
        return score;
    }

    // mutator method sets sumOfDice and score
    public void setScore() {
       sumOfDice = getDie1() + getDie2() + getDie3();
       if (threeSame()) { // simple tests for the type of roll
           score = sumOfDice + 50;
       } else if (runOfThree()) {
           score = sumOfDice + 30;
       } else if (pair()) {
           score = sumOfDice + 20;
       } else {
           score = sumOfDice;
       }
    }

}
