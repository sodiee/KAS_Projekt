package Application.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Participant extends APerson {
    private String companyName;
    private int companyPhoneNumber;
    private ArrayList<Companion> relatedCompanion;

    public Participant(String name, String address, String country, int phoneNumber) {
        super(name, address, country, phoneNumber);
    }
    public Participant(String name, String address, String country, int phoneNumber, String companyName, int companyPhoneNumber) {
        super(name, address, country, phoneNumber);
        this.companyName = companyName;
        this.companyPhoneNumber = companyPhoneNumber;
        relatedCompanion = new ArrayList<>();
    }

    public void addRelatedCompanion(Companion companion) {
        relatedCompanion.add(companion);
    }

    public ArrayList<Companion> getRelatedCompanion(){return relatedCompanion;}
    public void registerToConference(){}
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(int companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }
}
