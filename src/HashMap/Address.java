package HashMap;

public class Address {
    protected String country;
    protected String city;
    Address address;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
