// Game class
// simulates the three dice game

import java.util.Scanner;

public class Game {

    // METHODS
    // main method simulates the three dice game
    public static void main(String[] args) {

        int playerCount = 2;
        int rounds = -1;

        // a player is represented by a ThreeDicePlayer
        Scanner input = new Scanner(System.in);
        ThreeDicePlayer[] players = new ThreeDicePlayer[playerCount];
        String winner;

        while (rounds < 0) { // get round value (with input validation)
            System.out.print("Enter the number of rounds: ");
            try {
                rounds = input.nextInt();
                if (rounds < 0) { // user inputs a negative integer
                    System.out.println("\nInput must be a non-negative integer.");
                }
            } catch (Exception e) { // user inputs a non-integer
                rounds = -1;
                System.out.println("\nInput must be a non-negative integer.");
                input.nextLine();
            }
        }

        for (int i = 0; i < playerCount; i++) { // initialise the players
            players[i] = new ThreeDicePlayer(rounds);
        }

        System.out.println("");
        for (int r = 0; r < rounds; r++) { // loop through each round
            for (int i = 0; i < playerCount; i++) {
                players[i].roll(r, 1, 6); // roll for each player
            }

            // decide who wins the round
            if (players[0].getScore(r) > players[1].getScore(r)) {
                winner = "P1 Wins";
                players[0].incWins();
            } else if (players[0].getScore(r) < players[1].getScore(r)) {
                winner = "P2 Wins";
                players[1].incWins();
            } else {
                winner = "Draw";
            }

            // print round results
            System.out.println("ROUND " + (r + 1) + " (" + winner + ")");

            for (int i = 0; i < playerCount; i++) {
                System.out.println("P" + (i + 1) + ": "
                                    + players[i].getDie1(r) + ", "
                                    + players[i].getDie2(r) + ", "
                                    + players[i].getDie3(r) + " ("
                                    + players[i].getScore(r) + " points)");
            }

            System.out.println("");
        }

        // rounds over: decide overall winner (the player with the most points)
        if (players[0].getTotalPoints() > players[1].getTotalPoints()) {
            winner = "P1 Wins";
        } else if (players[0].getTotalPoints() < players[1].getTotalPoints()) {
            winner = "P2 Wins";
        } else {
            winner = "Draw";
        }

        // print overall results
        System.out.println("RESULTS (" + winner + ")");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("P" + (i + 1) + ":\n - Rounds Won: "
                               + players[i].getWins()
                               + "\n - Total Points: "
                               + players[i].getTotalPoints()
                               + "\n - Average Points: "
                               + players[i].getAveragePoints());
            }
    }

}
