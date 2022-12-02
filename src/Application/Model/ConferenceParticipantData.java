package Application.Model;

import java.util.ArrayList;

public class ConferenceParticipantData {
    private Participant participant;
    private Hotel hotel;
    private ArrayList<HotelExtraChoices> hotelExtraChoices;
    private Companion companion;
    private boolean lecturer;
    private Conference conference;
    private int daysAtConference;
    private double totalPrice;

    public ConferenceParticipantData(Conference conference, Participant participant, Hotel hotel, Companion companion, boolean lecturer, int daysAtConference) {
        this.conference = conference;
        this.participant = participant;
        this.hotel = hotel;
        this.companion = companion;
        this.lecturer = lecturer;
        this.daysAtConference = daysAtConference;
        hotelExtraChoices = new ArrayList<>();
    }

    public void addExtraChoices(HotelExtraChoices extraChoices) {
        hotelExtraChoices.add(extraChoices);
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        if (!this.lecturer) {
            totalPrice += conference.getPricePerDay() * daysAtConference;
        }
        var daysToStay = daysAtConference - 1;
        if (hotel != null)
            totalPrice += totalPriceExtra() * daysToStay;
        if (hotel != null) {
            if (companion == null)
                totalPrice += hotel.getPriceSingle() * daysToStay;
            else totalPrice += hotel.getPriceDouble() * daysToStay;
        }
        if (companion != null) {
            totalPrice += companion.getTotalPriceOfActivities();
        }
        

        return totalPrice;
    }

    private double totalPriceExtra() {
        double res = 0;
        for (var ex : hotelExtraChoices)
            res += ex.getPrice();
        return res;
    }

}
