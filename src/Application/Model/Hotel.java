package Application.Model;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private int daysRent;
    private ArrayList<HotelExtraChoices> extraChoices;
    private ArrayList<Participant> participantsInHotel;
    private double priceSingle;
    private double priceDouble;

    public Hotel(String hotelName, double priceSingle, double priceDouble) {
        this.hotelName = hotelName;
        this.extraChoices = new ArrayList<>(3);
        this.participantsInHotel = new ArrayList<>();
        this.priceSingle = priceSingle;
        this.priceDouble = priceDouble;
    }
    public HotelExtraChoices createHotelExtraChoices(String name, double price) {
        HotelExtraChoices hotelExtraChoices = new HotelExtraChoices(name, price);
        extraChoices.add(hotelExtraChoices);
        return hotelExtraChoices;
    }

    public void registerParticipantToRoom(Participant participant){
        participantsInHotel.add(participant);
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getDaysRent() {
        return daysRent;
    }

    public void setDaysRent(int daysRent) {
        this.daysRent = daysRent;
    }

    public ArrayList<HotelExtraChoices> getExtraChoices() {
        return extraChoices;
    }

    public void setExtraChoices(ArrayList<HotelExtraChoices> extraChoices) {
        this.extraChoices = extraChoices;
    }

    public void addParticipantToHotel(Participant participant){
        participantsInHotel.add(participant);
    }
    public ArrayList<Participant> getParticipantsInHotel() {
        return participantsInHotel;
    }

    public void setParticipantsInHotel(ArrayList<Participant> participantsInHotel) {
        this.participantsInHotel = participantsInHotel;
    }

    public void remove(Participant participant) {
        participantsInHotel.remove(participant);
    }

    public double getPriceSingle() {
        return priceSingle;
    }

    public double getPriceDouble() {
        return priceDouble;
    }
@Override
    public String toString(){return hotelName;}
}

