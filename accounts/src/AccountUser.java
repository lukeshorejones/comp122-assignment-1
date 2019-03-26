// AccountUser class
// the main program

import java.util.Scanner;

public class AccountUser {

    // METHODS
    // main method takes inputs, presents data and gives a recommendation
    public static void main(String[] args) {
        int tierCount = 3;
        int cheapest = 0;

        // account types stored in an array to make the system expandable
        Account[] accounts = new Account[tierCount];
        accounts[0] = new BronzeAccount();
        accounts[1] = new SilverAccount();
        accounts[2] = new GoldAccount();

        // get inputs from the user - see method at the bottom of this file
        int daytimeMinutes = getNonNegativeInt("Please enter the number of daytime minutes used per month: ");
        int otherMinutes = getNonNegativeInt("Please enter the number of non-daytime minutes used per month: ");
        int gbUsed = getNonNegativeInt("Please enter the number of Gigabytes used per month: ");

        for (int i = 0; i < tierCount; i++) { // loop through all tiers
            // calculate costs of this tier for this user
            accounts[i].setTotalPhoneCostDaytime(daytimeMinutes);
            accounts[i].setTotalPhoneCostOther(otherMinutes);
            accounts[i].setTotalBroadbandCost(gbUsed);
            accounts[i].setCost();;

            // we check if this tier is the cheapest tier found so far
            // <= so that we recommend higher tiers in case of ties
            if (accounts[i].getCost() <= accounts[cheapest].getCost()) {
                cheapest = i;
            }

            // print all the info needed
            System.out.println("Account Summary for " + accounts[i].getName() + " Account");
            System.out.println("Package Cost: " + accounts[i].getPackageCost());
            System.out.println("Cost of daytime calls: " + accounts[i].getPhoneCostDaytime() + "/min");
            System.out.println("Cost of evening and weekend calls: " + accounts[i].getPhoneCostOther() + "/min");
            System.out.println("Number of Channels: " + accounts[i].getTVChannels());
            System.out.println("Broadband Included: " + accounts[i].getIncludedBroadband() + "GB");
            System.out.println("Broadband Cost (above included limit): " + accounts[i].getExtraBroadbandCost() + "/GB");
            System.out.println("Total daytime calls cost: " + accounts[i].getTotalPhoneCostDaytime());
            System.out.println("Total evening and weekend calls cost: " + accounts[i].getTotalPhoneCostOther());
            System.out.println("Total (extra) broadband cost: " + accounts[i].getTotalBroadbandCost());
            System.out.println("Total cost: " + accounts[i].getCost());

            // these are only printed if the extras are offered
            if (accounts[i].getSpotifyIncluded()) {
                System.out.println("Spotify Account provided");
            }
            if (accounts[i].getMusicOnDemandIncluded()) {
                System.out.println("Music on Demand provided");
            }
            System.out.println("");
        }
        // print the cheapest account option
        System.out.println(accounts[cheapest].getName() + " Account is cheapest cost.");
    }

    // get an int greater than or equal to 0 from the user, with input validation
    public static int getNonNegativeInt(String msg) {
        Scanner input = new Scanner(System.in);
        int x = -1; // start at -1 so that the while loop is initially true

        while (x < 0) {
            System.out.print(msg);
            try {
                x = input.nextInt();
                if (x < 0) { // user inputs a negative integer
                    System.out.println("\nInput must be a non-negative integer.");
                }
            } catch (Exception e) { // user inputs a non-integer
                x = -1;
                System.out.println("\nInput must be a non-negative integer.");
                input.nextLine();
            }
        }
        return x; // user inputs a non-negative integer
    }

}
