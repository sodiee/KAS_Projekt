package Application.Controller;

import Application.Model.*;
import Storage.Storage;

import java.util.ArrayList;

public class Controller {

    /**
     * Returns the total price of the gicen CPD.
     * @param conferenceParticipantData
     * @return
     */
    public static double getPris(ConferenceParticipantData conferenceParticipantData) {
        double totalPris = conferenceParticipantData.getTotalPrice();
        return totalPris;
    }

    /**
     * Creates a participant without a company
     *
     * @param name
     * @param adress
     * @param country
     * @param phoneNumber
     * @return participant without company
     */
    public static Participant createParticipant(String name, String adress, String country, int phoneNumber) {
        Participant participant = new Participant(name, adress, country, phoneNumber);
        Storage.addParticipant(participant);
        return participant;
    }

    /**
     * Create a participant with to a company
     *
     * @param name
     * @param adress
     * @param country
     * @param phoneNumber
     * @param companyName
     * @param companyPhoneNumber
     * @return participant without company
     */
    public static Participant createParticipant(String name, String adress, String country, int phoneNumber, String companyName, int companyPhoneNumber) {
        Participant participant = createParticipant(name, adress, country, phoneNumber);
        participant.setCompanyName(companyName);
        participant.setCompanyPhoneNumber(companyPhoneNumber);
        Storage.addParticipant(participant);
        return participant;
    }

    /**
     * Creates a ConferenceParticipantData(tilmelding)
     *
     * @param conference
     * @param participant
     * @param hotel
     * @param companion
     * @param lecturer
     * @param daysAtConference
     * @return
     */
    public static ConferenceParticipantData createConferenceParticipantData(Conference conference, Participant participant, Hotel hotel, Companion companion, boolean lecturer, int daysAtConference, ArrayList<HotelExtraChoices> hotelExtraChoices) {
        ConferenceParticipantData cpd = new ConferenceParticipantData(conference, participant, hotel, companion, lecturer, daysAtConference, hotelExtraChoices);
        if (!conference.getListOfParticipants().contains(participant)) {
            Controller.addParticipantToConference(participant, conference);
            Storage.addParticipant(participant);
            if (hotel != null) {
                hotel.addParticipantToHotel(participant);
            }
        }
        return cpd;
    }

    /**
     * Creates a new conference
     *
     * @param location
     * @param startDate
     * @param endDate
     * @param pricePerDay
     * @param name
     * @return conference
     */
    public static Conference createConference(String location, String startDate, String endDate, double pricePerDay, String name) {
        Conference conference = new Conference(location, startDate, endDate, pricePerDay, name);
        Storage.addConference(conference);
        return conference;
    }

    /**
     * Returns a list of created conferences.
     *
     * @return
     */
    public static ArrayList<Conference> getConferences() {
        return Storage.getConferences();
    }

    /**
     * Adds a participant to a conference
     *
     * @param participant
     * @param conference
     */
    public static void addParticipantToConference(Participant participant, Conference conference) {
        conference.addParticipantToConference(participant);
    }

    public static void addParticipant(Participant p) {
        Storage.addParticipant(p);
    }

    /**
     * Returns list of participants to conference.
     *
     * @param conference
     * @return
     */
    public static ArrayList<Participant> getListOfParticipant(Conference conference) {
        return conference.getListOfParticipants();
    }

    /**
     * Registers a companion to it's related participant.
     *
     * @param companion
     * @param participant
     */
    public static void addCompanionToParticipant(Companion companion, Participant participant) {
        participant.addRelatedCompanion(companion);
    }

    /**
     * Returns a list of participants
     *
     * @return
     */
    public static ArrayList<Participant> getParticipants() {
        return Storage.getParticipant();
    }

    /**
     * Creates a new hotel
     *
     * @param hotelName
     * @param priceSingle
     * @param priceDouble
     * @return
     */
    public static Hotel createHotel(String hotelName, double priceSingle, double priceDouble) {
        Hotel hotel = new Hotel(hotelName, priceSingle, priceDouble);
        Storage.addHotel(hotel);
        return hotel;
    }

    /**
     * returns a list of all created hotels
     *
     * @return
     */
    public static ArrayList<Hotel> getHotels() {
        return Storage.getHotel();
    }

    public static ArrayList<Participant> getListofParticipantsInHotel(Hotel hotel) {
        return hotel.getParticipantsInHotel();
    }

    /**
     * creates a hotelExtraChoice
     *
     * @param name
     * @param price
     * @param hotel
     * @return
     */
    public static HotelExtraChoices createHotelExtraChoices(String name, double price, Hotel hotel) {
        return hotel.createHotelExtraChoices(name, price);
    }

    public static ArrayList<CompanionActivity> getActivitylist() {
        return Storage.getActivities();
    }

    public static void addCompanion(Companion companion) {
        Storage.addCompanion(companion);
    }

    public static ArrayList<Companion> getCompanions() {
        return Storage.getCompanion();
    }

    public static ArrayList<Companion> getCompanionsAtActivity(CompanionActivity companionActivity) {
        return companionActivity.getCompanionAtActivity();
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Conference havOgHimmel = Controller.createConference("Odense Universitet", "18-05-2023", "20-05-2023", 1500, "Hav og Himmel");

        CompanionActivity egeskov = new CompanionActivity("Egeskov", "Egeskov slot", 75, "19/5-2022");
        CompanionActivity trapholt = new CompanionActivity("Trapholt Museum", "Kolding", 200, "20/5.2022");
        CompanionActivity byrundtur = new CompanionActivity("Byrundtur", "Odense", 125, "18/5-2022");

        Hotel denHvideSvane = createHotel("Den Hvide Svane", 1050, 1250);
        havOgHimmel.getListOfHotels().add(denHvideSvane);
        Controller.createHotelExtraChoices("Bad", 0, denHvideSvane);
        Controller.createHotelExtraChoices("Morgenmad", 0, denHvideSvane);
        Controller.createHotelExtraChoices("Wifi", 50, denHvideSvane);

        Participant finnMadsen = new Participant("Finn Madsen", "S??ren Frichs Vej 51K", "Denmark", 39184617);
        Participant nielsPetersen = new Participant("Niels Petersen", "??rhusvej 20", "Denmark", 39184910);
        Participant peterSommer = new Participant("Peter Sommer", "Randervej 5", "Denmark", 48197528);
        Participant loneJensen = new Participant("Lone Jensen", "??lborgvej 4", "Sverige", 48190347);

        Companion mieSommer = new Companion("Mie Sommer", "Randersvej 5", "Denmark", 19378583);
        egeskov.addCompanionToActivity(mieSommer);
        trapholt.addCompanionToActivity(mieSommer);
        Companion janMadsen = new Companion("Jan Madsen", "??lborgvej 4", "Sverige", 18593901);
        egeskov.addCompanionToActivity(janMadsen);
        byrundtur.addCompanionToActivity(janMadsen);

        Controller.createConferenceParticipantData(havOgHimmel, finnMadsen, null, null, false, 3, null);
        Controller.createConferenceParticipantData(havOgHimmel, nielsPetersen, denHvideSvane, null, false, 3, null);
        Controller.createConferenceParticipantData(havOgHimmel, peterSommer, denHvideSvane, mieSommer, false, 3, null);
        Controller.createConferenceParticipantData(havOgHimmel, loneJensen, denHvideSvane, janMadsen, true, 3, null);
    }

    public static void init() {

        initStorage();

    }
}
