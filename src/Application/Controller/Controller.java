package Application.Controller;

import Application.Model.*;
import Storage.Storage;

import java.util.ArrayList;

public class Controller {
    /**
     * Creates a participant without a company
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
     * Creates a ConferenceParticipantData(tilmelding), if the participant is added to the conference.
     * @param conference
     * @param participant
     * @param hotel
     * @param companion
     * @param lecturer
     * @param daysAtConference
     * @return
     */
    public static void createConferenceParticipantData(Conference conference, Participant participant, Hotel hotel, Companion companion, boolean lecturer, int daysAtConference){
        if (conference.getListOfParticipants().contains(participant)) {
            ConferenceParticipantData conferenceParticipantData = new ConferenceParticipantData(conference, participant, hotel, companion, lecturer, daysAtConference);
        }
    }

    /**
     * Creates a new conference
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
     * @return
     */
    public static ArrayList<Conference> getConferences(){
        return Storage.getConferences();
    }

    /**
     * Adds a participant to a conference
     * @param participant
     * @param conference
     */
    public static void addToConferenceAndCreateCPD(Participant participant, Conference conference) {
        conference.addParticipantToConference(participant);
    }

    /**
     * Creates a companion
     * @param name
     * @param address
     * @param country
     * @param phoneNumber
     * @return companion
     */
    public static Companion createCompanion(String name, String address, String country, int phoneNumber){
        Companion companion = new Companion(name, address, country, phoneNumber);
        return companion;
    }

    /**
     * Registers a companion to it's related participant.
     * @param companion
     * @param participant
     */
    public static void addCompanionToParticipant(Companion companion, Participant participant){
        participant.addRelatedCompanion(companion);
    }

    /**
     * Returns a list of participants
     * @return
     */
    public static ArrayList<Participant> getParticipants() {
        return Storage.getParticipant();
    }

    /**
     * Creates a new hotel
     * @param hotelName
     * @param priceSingle
     * @param priceDouble
     * @return
     */
    public static Hotel createHotel(String hotelName, double priceSingle, double priceDouble){
        Hotel hotel = new Hotel(hotelName, priceSingle, priceDouble);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHotels(){
        return Storage.getHotel();
    }

    /**
     * creates a hotelExtraChoice
     * @param name
     * @param price
     * @param hotel
     * @return
     */
    public static HotelExtraChoices createHotelExtraChoices(String name, double price, Hotel hotel){
        return hotel.createHotelExtraChoices(name, price);
    }

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Conference havOgHimmel = Controller.createConference("Odense Universitet", "18-05-2023", "20-05-2023", 1500, "Hav og Himmel");
        Storage.addConference(havOgHimmel);

        Participant finnMadsen = new Participant("Finn Madsen", "Søren Frichs Vej 51K", "Denmark", 39184617);
        Storage.addParticipant(finnMadsen);

        Controller.createConferenceParticipantData(havOgHimmel, finnMadsen, null, null, false, 3);

        Hotel denHvideSvane = new Hotel("Den Hvide Svane", 1050, 1200);
        Storage.addHotel(denHvideSvane);

        Participant nielsPetersen = new Participant("Niels Petersen", "Århusvej 20", "Denmark", 39184910);
        Controller.createConferenceParticipantData(havOgHimmel, nielsPetersen, denHvideSvane, null, false, 3);
        Storage.addParticipant(nielsPetersen);

        CompanionActivity egeskov = new CompanionActivity("Egeskov", "Egeskov slot", 75, "19/5-2022");
        CompanionActivity trapholt = new CompanionActivity("Trapholt Museum", "Kolding", 200, "20/5.2022");
        Participant peterSommer = new Participant("Peter Sommer", "Randervej 5", "Denmark", 48197528);
        Storage.addParticipant(peterSommer);
        Companion mieSommer = new Companion("Mie Sommer", "Randersvej 5", "Denmark", 19378583);
        Storage.addCompanion(mieSommer);
        Controller.createConferenceParticipantData(havOgHimmel, peterSommer, denHvideSvane, mieSommer, false, 3);
        Controller.createHotelExtraChoices("Wifi", 50, denHvideSvane);
        mieSommer.addCompanionActivity(egeskov);
        mieSommer.addCompanionActivity(trapholt);
        Controller.createConferenceParticipantData(havOgHimmel, peterSommer, denHvideSvane, mieSommer, false, 3);


        Participant loneJensen = new Participant("Lone Jensen", "Ålborgvej 4", "Sverige", 48190347);
        Storage.addParticipant(loneJensen);
        Companion janMadsen = new Companion("Jan Madsen", "Ålborgvej 4", "Sverige", 18593901);
        Storage.addCompanion(janMadsen);
        Controller.createHotelExtraChoices("Wifi", 50, denHvideSvane);
        CompanionActivity byrundtur = new CompanionActivity("Byrundtur", "Odense", 125, "18/5-2022");
        janMadsen.addCompanionActivity(egeskov);
        janMadsen.addCompanionActivity(byrundtur);
        Controller.createConferenceParticipantData(havOgHimmel, loneJensen, denHvideSvane, janMadsen, true, 3);
    }

    public static void init() {

        initStorage();

    }
}
