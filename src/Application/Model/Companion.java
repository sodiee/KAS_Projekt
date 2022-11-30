package Application.Model;

import java.util.ArrayList;

public class Companion extends APerson{
    private ArrayList<CompanionActivity> activities;
    public Companion(String name, String address, String country, int phoneNumber) {
        super(name, address, country, phoneNumber);
        this.activities = new ArrayList<>();
    }

    public void registerToActivities(CompanionActivity activity){
        activities.add(activity);
    }

    public ArrayList<CompanionActivity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<CompanionActivity> activities) {
        this.activities = activities;
    }

    public void addCompanionActivity(CompanionActivity companionActivity){
        activities.add(companionActivity);
    }
    public double getTotalPriceOfActivities(){
        double totalPriceOfActivities = 0;
        for(var activity : activities){
            totalPriceOfActivities += activity.getActivityPrice();
        }
        return totalPriceOfActivities;}

    public String toString(){
        return super.getName();
    }
}
