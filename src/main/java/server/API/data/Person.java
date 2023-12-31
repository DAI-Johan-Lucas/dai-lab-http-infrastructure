package server.API.data;

import java.sql.Date;

public class Person {
    private int id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String phone;
    private int fk_address;

    public Person(){ }

    public Person(int id, String firstname, String lastname, Date birthdate, String phone, int address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.fk_address = address;
    }

    public int getId() {
        return id;
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

    public int getAddress() {
        return fk_address;
    }
}
