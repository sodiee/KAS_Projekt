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
        if (!conference.getListOfParticipants().contains(participant)) {
            ConferenceParticipantData conferenceParticipantData = new ConferenceParticipantData(conference, participant, hotel, companion, lecturer, daysAtConference);
            if (hotel == null) {

            } else {
                hotel.addParticipantToHotel(participant);
            }
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
    public static void addToConference(Participant participant, Conference conference) {
        conference.addParticipantToConference(participant);
    }

    /**
     * Returns list of participants to conference.
     * @param conference
     * @return
     */
    public static ArrayList<Participant> getListOfParticipant(Conference conference){return conference.getListOfParticipants();}

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

    /**
     * returns a list of all created hotels
     * @return
     */
    public static ArrayList<Hotel> getHotels(){
        return Storage.getHotel();
    }

    public static ArrayList<Participant> getListofParticipantsInHotel(Hotel hotel){
        return hotel.getParticipantsInHotel();
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

    public static ArrayList<CompanionActivity> getActivitylist(){
        return Storage.getActivities();
    }

    public static ArrayList<Companion> getCompanions(){
        return Storage.getCompanion();
    }

    public static ArrayList<Companion> getCompanionsAtActivity(CompanionActivity companionActivity){
        return companionActivity.getCompanionAtActivity();
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
        havOgHimmel.getListOfHotels().add(denHvideSvane);

        Participant nielsPetersen = new Participant("Niels Petersen", "Århusvej 20", "Denmark", 39184910);
        Controller.createConferenceParticipantData(havOgHimmel, nielsPetersen, denHvideSvane, null, false, 3);
        Storage.addParticipant(nielsPetersen);
        denHvideSvane.addParticipantToHotel(nielsPetersen);

        CompanionActivity egeskov = new CompanionActivity("Egeskov", "Egeskov slot", 75, "19/5-2022");
        Storage.addActivities(egeskov);
        CompanionActivity trapholt = new CompanionActivity("Trapholt Museum", "Kolding", 200, "20/5.2022");
        Storage.addActivities(trapholt);
        Participant peterSommer = new Participant("Peter Sommer", "Randervej 5", "Denmark", 48197528);
        Storage.addParticipant(peterSommer);
        denHvideSvane.addParticipantToHotel(peterSommer);
        Companion mieSommer = new Companion("Mie Sommer", "Randersvej 5", "Denmark", 19378583);
        Storage.addCompanion(mieSommer);
        Controller.createConferenceParticipantData(havOgHimmel, peterSommer, denHvideSvane, mieSommer, false, 3);
        Controller.createHotelExtraChoices("Wifi", 50, denHvideSvane);
        egeskov.addCompanionToActivity(mieSommer);
        trapholt.addCompanionToActivity(mieSommer);
        Controller.createConferenceParticipantData(havOgHimmel, peterSommer, denHvideSvane, mieSommer, false, 3);


        Participant loneJensen = new Participant("Lone Jensen", "Ålborgvej 4", "Sverige", 48190347);
        Storage.addParticipant(loneJensen);
        denHvideSvane.addParticipantToHotel(loneJensen);
        Companion janMadsen = new Companion("Jan Madsen", "Ålborgvej 4", "Sverige", 18593901);
        Storage.addCompanion(janMadsen);
        Controller.createHotelExtraChoices("Wifi", 50, denHvideSvane);
        CompanionActivity byrundtur = new CompanionActivity("Byrundtur", "Odense", 125, "18/5-2022");
        Storage.addActivities(byrundtur);
        egeskov.addCompanionToActivity(janMadsen);
        byrundtur.addCompanionToActivity(janMadsen);
        Controller.createConferenceParticipantData(havOgHimmel, loneJensen, denHvideSvane, janMadsen, true, 3);
    }

    public static void init() {

        initStorage();

    }
}
