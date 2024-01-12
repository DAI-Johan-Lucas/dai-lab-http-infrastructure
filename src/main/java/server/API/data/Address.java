package server.API.data;

public class Address {
    public int id;
    public String street;
    public String npa;
    public String city;
    public String country;

    public Address() { }

    public Address(int id, String street, String npa, String city, String country) {
        this.id = id;
        this.street = street;
        this.npa = npa;
        this.city = city;
        this.country = country;
    }
}
