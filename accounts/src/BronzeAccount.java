// BronzeAccount class

public class BronzeAccount extends Account {

    // CONSTRUCTOR
    // constructor methods sets attributes defined by superclass
    public BronzeAccount() {
        name = "Bronze";
        packageCost = 35.00;
        phoneCostDaytime = 0.12;
        phoneCostOther = 0.05;
        tvChannels = 60;
        includedBroadband = 200;
        extraBroadbandCost = 0.20;
        spotifyIncluded = false;
        musicOnDemandIncluded = false;
    }

}
