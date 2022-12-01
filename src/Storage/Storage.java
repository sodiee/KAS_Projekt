package Storage;

import Application.Model.*;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Participant> participants = new ArrayList<>();

    private static ArrayList<CompanionActivity> activities = new ArrayList<>();
    private static ArrayList<Companion> companions = new ArrayList<>();
    private static ArrayList<Hotel> hotels = new ArrayList<>();
    private static ArrayList<Conference> conferences = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Participant> getParticipant() {
        return new ArrayList<Participant>(participants);
    }

    public static void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public static void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Companion> getCompanion() {
        return companions;
    }

    public static void addCompanion(Companion companion) {
        companions.add(companion);
    }

    public static void removeCompanion(Companion companion){companions.remove(companion);}

    // -------------------------------------------------------------------------

    public static ArrayList<Hotel> getHotel() {return hotels;}

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {hotels.remove(hotel);}

    // -------------------------------------------------------------------------

    public static ArrayList<Conference> getConferences() {return conferences;}

    public static void addConference(Conference conference) {conferences.add(conference);}

    public static void removeConference(Conference conference) {conferences.remove(conference);}

    // -------------------------------------------------------------------------

    public static ArrayList<CompanionActivity> getActivities() {return activities;}
    public static void addActivities(CompanionActivity companionActivity) {activities.add(companionActivity);}

    // -------------------------------------------------------------------------
}
/*
    private static ArrayList<Participant> makeParticipant() {
        ArrayList<Participant> list = new ArrayList<>();
        for (Participant p : list) {
            String name = p.getName();
            String adress = p.getAddress();
            String country = p.getCountry();
            int phoneNumber = p.getPhoneNumber();

            Participant participant = new Participant(name, adress, country, phoneNumber);
            list.add(p);
            //System.out.println(name);
        }
        return list;
    }*/

