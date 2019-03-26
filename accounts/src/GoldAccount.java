// GoldAccount class

public class GoldAccount extends Account {

    // CONSTRUCTOR
    // constructor methods sets attributes defined by superclass
    public GoldAccount() {
        name = "Gold";
        packageCost = 60.00;
        phoneCostDaytime = 0.00;
        phoneCostOther = 0.00;
        tvChannels = 230;
        includedBroadband = 2000;
        extraBroadbandCost = 0.10;
        spotifyIncluded = true;
        musicOnDemandIncluded = true;
    }

}
