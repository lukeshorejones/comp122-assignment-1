// Average class
// calculates the game's average score

/*
 * There are 216 (6^3) possible rolls in the game.
 * This is the product of the number of states of each die
 * The average score, as calculated by this class, is 31.74537037037037.
 * This code is easily modified to calculate the average number of points
 * where one dice has faces 2, 3, 4, 5, 6 and 6 again.
 * Line 27 can be changed from:
 * rolls = new ThreeDiceScorer(d1, d2, d3);
 * to:
 * rolls = new ThreeDiceScorer(Math.max(d1 + 1, 6), Math.max(d2 + 1, 6), Math.max(d3 + 1, 6));
 * This increases each roll by one, except a roll of 6, which is not increased.
 * (But, of course, a roll of 5 is still increased to 6)
 * The new average in this case is 91.16203703703704.
 */

import java.util.Scanner;

public class Average {

    // METHODS
    // main method simulates the three dice game
    public static void main(String[] args) {

        ThreeDiceScorer rolls;
        int maxRoll = 6;
        int totalScore = 0;

        // three loops, one for each die - cover each combination of rolls
        for (int d1 = 0; d1 <= maxRoll; d1++) {
            for (int d2 = 0; d2 <= maxRoll; d2++) {
                for (int d3 = 0; d3 <= maxRoll; d3++) {
                    // create a ThreeDiceScorer for this combination
                    rolls = new ThreeDiceScorer(d1, d2, d3);

                    // get the score for this combination and add to total
                    rolls.setScore();
                    totalScore += rolls.getScore();
                }
            }
        }

        // calculate average by dividing total by the number of combinations
        // the number of combinations is equal to 6^3 (as described above)
        // finally, print the result
        double avgScore = (double)(totalScore) / Math.pow(maxRoll, 3);
        System.out.println("The average score is " + avgScore + ".");

    }

}
