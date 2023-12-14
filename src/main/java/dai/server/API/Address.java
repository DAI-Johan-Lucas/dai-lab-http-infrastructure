package dai.server.API;

public class Address {
    private int id;
    private String street;
    private String npa;
    private String city;
    private String country;

    public Address(int id, String street, String npa, String city, String country) {
        this.id = id;
        this.street = street;
        this.npa = npa;
        this.city = city;
        this.country = country;
    }
}
