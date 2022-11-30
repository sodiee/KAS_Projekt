package Application.Model;

public class CompanionActivity {
    private String activityName;
    private String activityLocation;
    private int activityPrice;
    private String activityDate;

    public CompanionActivity(String activityName, String activityLocation, int activityPrice, String activityDate) {
        this.activityName = activityName;
        this.activityLocation = activityLocation;
        this.activityPrice = activityPrice;
        this.activityDate = activityDate;
    }
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public int getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(int activityPrice) {
        this.activityPrice = activityPrice;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }
}
