package esparaquia.Json2java.model;

public class Address {
    //Atributes for the values of Address (street, city and zip) as a part of
    String street;
    String city;
    String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    //Create a constructor
    public Address() {}

    //Create another constructor (via Generate -> constructor)
    public Address(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
