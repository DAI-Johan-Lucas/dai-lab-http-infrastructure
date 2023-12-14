package dai.server.API;

import java.sql.Date;

public class Person {
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String phone;
    private Address address;

    public Person(){ }

    public Person(String firstname, String lastname, Date birthdate, String phone, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
