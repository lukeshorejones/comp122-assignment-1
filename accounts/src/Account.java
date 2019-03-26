// Account class
// an abstract class which is extended by different tiers

public abstract class Account {

    // ATTRIBUTES
    // all costs are in pounds
    protected String name;
    protected double packageCost;
    protected double phoneCostDaytime;
    protected double phoneCostOther;
    protected int tvChannels;
    protected double includedBroadband;
    protected double extraBroadbandCost;
    protected boolean spotifyIncluded;
    protected boolean musicOnDemandIncluded;

    private double totalPhoneCostDaytime;
    private double totalPhoneCostOther;
    private double totalBroadbandCost;
    private double cost;

    // METHODS
    public String getName() {
        return name;
    }

    public double getPackageCost() {
        return packageCost;
    }

    public double getPhoneCostDaytime() {
        return phoneCostDaytime;
    }

    public double getPhoneCostOther() {
        return phoneCostOther;
    }

    public int getTVChannels() {
        return tvChannels;
    }

    public double getIncludedBroadband() {
        return includedBroadband;
    }

    public double getExtraBroadbandCost() {
        return extraBroadbandCost;
    }

    public boolean getSpotifyIncluded() {
        return spotifyIncluded;
    }

    public boolean getMusicOnDemandIncluded() {
        return musicOnDemandIncluded;
    }

    public double getTotalPhoneCostDaytime() {
        return totalPhoneCostDaytime;
    }

    public double getTotalPhoneCostOther() {
        return totalPhoneCostOther;
    }

    public double getTotalBroadbandCost() {
        return totalBroadbandCost;
    }

    public double getCost() {
        return cost;
    }

    //  calculate the price for the user's daytime phone use from cost per minute and minutes spent
    public void setTotalPhoneCostDaytime(double daytimeMinutes) {
        // p is the value in pence - this is rounded to avoid long floating point results
        double p = Math.round(phoneCostDaytime * daytimeMinutes * 100);
        totalPhoneCostDaytime = p / 100;
    }

    //  calculate the price for the user's non-daytime phone use from cost per minute and minutes spent
    public void setTotalPhoneCostOther(double otherMinutes) {
        double p = Math.round(phoneCostOther * otherMinutes * 100);
        totalPhoneCostOther = p / 100;
    }

    public void setTotalBroadbandCost(double gbUsed) {
        double p = Math.round(Math.max(gbUsed - includedBroadband, 0) * extraBroadbandCost * 100);
        totalBroadbandCost = p / 100;
    }

    // gbUsed - includedBroadband has min value of zero, as you don't save
    // money for using less than the included broadband
    public void setCost() {
        double p = Math.round((packageCost + totalPhoneCostDaytime + totalPhoneCostOther + totalBroadbandCost) * 100);
        cost = p / 100;
    }

}
