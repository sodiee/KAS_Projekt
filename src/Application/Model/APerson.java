package Application.Model;

public abstract class APerson {
    private String name;
    private String address;
    private String country;
    private int phoneNumber;

    public APerson(String name, String address, String country, int phoneNumber){
        this.name = name;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
