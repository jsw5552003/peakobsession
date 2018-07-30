package peak.app.view;

public class LeaderBoardEntryView {

    String username;

    int fourKMountains = 0;

    int totalMountains = 0;

    float miles = 0.0f;

    int hikes = 0;

    public LeaderBoardEntryView() {
        super();
    }

    public LeaderBoardEntryView(String username, int totalMountains, int fourKMountains, float miles, int hikes) {
        this.username = username;
        this.fourKMountains = fourKMountains;
        this.totalMountains = totalMountains;
        this.miles = miles;
        this.hikes = hikes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFourKMountains() {
        return fourKMountains;
    }

    public void setFourKMountains(int fourKMountains) {
        this.fourKMountains = fourKMountains;
    }

    public void incrementFourKMountains() {
        this.fourKMountains++;
    }

    public int getTotalMountains() {
        return totalMountains;
    }

    public void setTotalMountains(int totalMountains) {
        this.totalMountains = totalMountains;
    }

    public void incrementTotalMountains() {
        this.totalMountains++;
    }

    public float getMiles() {
        return miles;
    }

    public void setMiles(float miles) {
        this.miles = miles;
    }

    public void addMiles(float miles) {
        this.miles = this.miles + miles;
    }

    public int getHikes() {
        return hikes;
    }

    public void setHikes(int hikes) {
        this.hikes = hikes;
    }

    public void incrementHikes() {
        this.hikes++;
    }


}
