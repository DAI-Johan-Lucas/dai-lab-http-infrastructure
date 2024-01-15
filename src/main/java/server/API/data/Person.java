package server.API.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

public class Person {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public int id;
    public String firstname;
    public String lastname;
    public Date birthdate;
    public String phone;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public int fk_address;

    public Person(){ }

    public Person(int id, String firstname, String lastname, Date birthdate, String phone, int fk_address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.fk_address = fk_address;
    }
}
