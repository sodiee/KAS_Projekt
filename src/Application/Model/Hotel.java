package Application.Model;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private int daysRent;
    private ArrayList<HotelExtraChoices> extraChoices;
    private HotelExtraChoices hotelExtraChoices;
    private ArrayList<Participant> hRooms;
    private double priceSingle;
    private double priceDouble;

    public Hotel(String hotelName, double priceSingle, double priceDouble) {
        this.hotelName = hotelName;
        this.extraChoices = new ArrayList<>();
        this.hRooms = new ArrayList<>();
        this.priceSingle = priceSingle;
        this.priceDouble = priceDouble;
    }
    public HotelExtraChoices createHotelExtraChoices(String name, double price) {
        hotelExtraChoices = new HotelExtraChoices(name, price);
        extraChoices.add(hotelExtraChoices);
        return hotelExtraChoices;
    }

    public void registerParticipantToRoom(Participant participant){
        hRooms.add(participant);
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

    public HotelExtraChoices getHotelExtraChoices() {
        return hotelExtraChoices;
    }

    public void setHotelExtraChoices(HotelExtraChoices hotelExtraChoices) {
        this.hotelExtraChoices = hotelExtraChoices;
    }

    public ArrayList<Participant> gethRooms() {
        return hRooms;
    }

    public void sethRooms(ArrayList<Participant> hRooms) {
        this.hRooms = hRooms;
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

