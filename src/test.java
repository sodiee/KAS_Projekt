import Application.Model.*;

public class test {
    public static void main(String[] args) {
        /*CompanionActivity aktivitet = new CompanionActivity("Løbetur", "Århus", 200, "2 timer");
        CompanionActivity aktivitet1 = new CompanionActivity("Løbetur", "Århus", 250, "2 timer");
        Companion companion = new Companion("Surma", "Vibyvej 5", "Denmark", 12345678);
        Participant participant = new Participant("Rasmus", "Randervej 50", "Danmark", 12345678);
        Conference konference = new Conference("strandvejen 23", "23/11-2022", "26/11-2022", 1500, "navnHelvede");
        Hotel hotel = new Hotel("hejHotel", 3, 1050, 1250);
        hotel.createHotelExtraChoices("Wi-Fi og bad", 200);
        ConferenceParticipantData tilmelding = new ConferenceParticipantData(participant, hotel, companion, true, 3);
        System.out.println(tilmelding.getTotalPrice()); */
        System.out.println("Case 1:");
        Conference havOgHimmel = new Conference("I himlen", "18-05-2022", "20-05-2022", 1500, "Hav og himmel");
        Participant finnMadsen = new Participant("Finn Madsen", "Søren Frichs 2", "Danmark", 12345678);
        ConferenceParticipantData c1 = new ConferenceParticipantData(havOgHimmel, finnMadsen, null, null, false, 3);
        System.out.println(c1.getTotalPrice());

        System.out.println("Case 2:");
        Participant nielsPetersen = new Participant("Niels Petersen", "Søren Frichs 3", "Danmark", 12345678);
        Hotel denHvideSvane = new Hotel("Den hvide svane", 1050, 1250);
        ConferenceParticipantData c2 = new ConferenceParticipantData(havOgHimmel, nielsPetersen, denHvideSvane, null, false, 3);
        System.out.println(c2.getTotalPrice());

        System.out.println("Case 3");
        Participant peterSommer = new Participant("Peter Sommer", "Søren Frichs 4", "Somalia", 12345678);
        Companion mieSommer = new Companion("Mie Sommer", "Søren Frichs 4", "Somalia", 12345679);
        CompanionActivity aktivitet = new CompanionActivity("Egeskov slot", "Egeskov", 75, "2 timer");
        CompanionActivity aktivitet1 = new CompanionActivity("Trapholt", "Kolding", 200, "2 timer");
        mieSommer.addCompanionActivity(aktivitet);
        mieSommer.addCompanionActivity(aktivitet1);
        var ex = denHvideSvane.createHotelExtraChoices("Wifi", 50);
        ConferenceParticipantData c3 = new ConferenceParticipantData(havOgHimmel, peterSommer, denHvideSvane, mieSommer, false, 3);
        c3.addExtraChoices(ex);
        System.out.println(c3.getTotalPrice());

        System.out.println("Case 4");
        Participant loneJensen = new Participant("Lone Jensen", "Søren Frichs 5", "Somalia", 12345677);
        Companion janMadsen = new Companion("Jan Madsen", "Søren Frichs 5", "Somalia", 12345677);
        CompanionActivity aktivitet2 = new CompanionActivity("Byrundtur", "Odense", 125, "Et par timer");
        janMadsen.addCompanionActivity(aktivitet2);
        janMadsen.addCompanionActivity(aktivitet);
        ConferenceParticipantData c4 = new ConferenceParticipantData(havOgHimmel, loneJensen, denHvideSvane, janMadsen, true, 3);
        c4.addExtraChoices(ex);
        System.out.println(c4.getTotalPrice());
    }
}
