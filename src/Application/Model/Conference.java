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


    public Conference(String location, String startDate, String endDate, double pricePerDay, String name) {
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        listOfParticipants = new ArrayList<>();
        listOfHotels = new ArrayList<>();
        this.pricePerDay = pricePerDay;
        this.name = name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void addParticipantToConference(Participant participant) {
        if (listOfParticipants.contains(participant)){
            listOfParticipants.add(participant);
        }
    }
    public ArrayList<Participant> getListOfParticipants() {
        return listOfParticipants;
    }

    public ArrayList<Hotel> getListOfHotels() {
        return listOfHotels;
    }

    public String toString() {
        return name;
    }
}
