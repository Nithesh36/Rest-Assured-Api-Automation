package Pojo;

public class SecondaryAddress {

//    "city": "Chennai",
//            "State": "Tamil Nadu",
//            "Country": "India",
//            "PinCode": 600100
private String city;
    private String State;
    private String Country;
    private int PinCode;

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        State = state;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setPinCode(int pinCode) {
        PinCode = pinCode;
    }


    public String getCity() {
        return city;
    }

    public String getState() {
        return State;
    }

    public String getCountry() {
        return Country;
    }

    public int getPinCode() {
        return PinCode;
    }
}
