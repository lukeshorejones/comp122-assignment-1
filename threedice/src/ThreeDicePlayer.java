// ThreeDicePlayer class
// holds a player's array of rolls (ThreeDiceScorers), plus points and wins

public class ThreeDicePlayer {

    // ATTRIBUTES
    private ThreeDiceScorer[] rolls; // array of dice rolls
    private int rounds; // total number of rounds in the game
    private int points = 0; // running total of this player's scores
    private int wins = 0; // number of rounds won

    // CONSTRUCTOR
    // constructor method calls ThreeDiceScorer constructor
    public ThreeDicePlayer(int rs) {
        rounds = rs;
        rolls = new ThreeDiceScorer[rounds];
    }

    // METHODS
    // accessor method returns total points
    public int getTotalPoints() {
        return points;
    }

    // accessor method returns average points
    public double getAveragePoints() {
        // a round count of 0 is treated as 1 to avoid division by 0
        // when rounds = 0, points = 0, so the average should also be 0
        return ((double)(points) / Math.max(rounds, 1));
    }

    // accessor method returns wins
    public int getWins() {
        return wins;
    }

    // in the below accessors we pass an index for the array of ThreeDiceScorers
    // they call a corresponding method in the desired ThreeDiceScorer

    // accessor method takes round # and returns a ThreeDiceScorer's die1
    public int getDie1(int r) {
        return rolls[r].getDie1();
    }

    // accessor method takes round # and returns a ThreeDiceScorer's die2
    public int getDie2(int r) {
        return rolls[r].getDie2();
    }

    // accessor method takes round # and returns a ThreeDiceScorer's die3
    public int getDie3(int r) {
        return rolls[r].getDie3();
    }

    // accessor method takes round # and returns a ThreeDiceScorer's score
    public int getScore(int r) {
        return rolls[r].getScore();
    }

    // mutator method takes a round #, min and max and sets a ThreeDiceScorer
    public void roll(int r, int min, int max) {
        rolls[r] = new ThreeDiceScorer((int)(Math.ceil(min + Math.random()*max - 1)),
                                       (int)(Math.ceil(min + Math.random()*max - 1)),
                                       (int)(Math.ceil(min + Math.random()*max - 1)));
        rolls[r].setScore();
        points += rolls[r].getScore();
    }

    // mutator method adds 1 to wins
    public void incWins() {
        wins++;
    }

}
