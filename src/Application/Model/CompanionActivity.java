package Application.Model;

import java.util.ArrayList;

public class CompanionActivity {
    private String activityName;
    private String activityLocation;
    private int activityPrice;
    private String activityDate;
    private ArrayList<Companion> registeredCompanions;

    public CompanionActivity(String activityName, String activityLocation, int activityPrice, String activityDate) {
        this.activityName = activityName;
        this.activityLocation = activityLocation;
        this.activityPrice = activityPrice;
        this.activityDate = activityDate;
        registeredCompanions = new ArrayList<>();
    }
    public int getActivityPrice() {
        return activityPrice;
    }

    public void addCompanionToActivity(Companion companion) {
        registeredCompanions.add(companion);
    }

    public ArrayList<Companion> getCompanionAtActivity(){
        return registeredCompanions;
    }
    public String toString(){
        return activityName;
    }
}
