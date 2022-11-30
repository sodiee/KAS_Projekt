package Application.Model;

import java.util.ArrayList;

public class Conference {
    private String location;
    private String startDate;
    private String endDate;
    private ArrayList<Participant> listOfParticipants;
    private ArrayList<Hotel> listOfHotels;
    private double pricePerDay;
    private String name;
    private Hotel hotel;
    private CompanionActivity activity;
    private ArrayList<CompanionActivity> activities;

    public Conference(String location, String startDate, String endDate, double pricePerDay, String name) {
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        listOfParticipants = new ArrayList<>();
        listOfHotels = new ArrayList<>();
        this.pricePerDay = pricePerDay;
        this.name = name;
    }

    public void createCompanionActivity(String activityName, String activityLocation, int activityPrice, String activityDuration){
        activity = new CompanionActivity(name,activityLocation, activityPrice, activityDuration);
        activities.add(activity);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Participant> getListOfParticipants() {
        return listOfParticipants;
    }

    public void setListOfParticipants(ArrayList<Participant> listOfParticipants) {
        this.listOfParticipants = listOfParticipants;
    }

    public ArrayList<Hotel> getListOfHotels() {
        return listOfHotels;
    }

    public void setListOfHotels(ArrayList<Hotel> listOfHotels) {
        this.listOfHotels = listOfHotels;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public CompanionActivity getActivity() {
        return activity;
    }

    public void setActivity(CompanionActivity activity) {
        this.activity = activity;
    }

    public ArrayList<CompanionActivity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<CompanionActivity> activities) {
        this.activities = activities;
    }

    public void addParticipantToConference(Participant participant) {
        if (listOfParticipants.contains(participant)){
            listOfParticipants.add(participant);
        }
    }

    public String toString() {
        return name;
    }
}
