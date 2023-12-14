package dai.server.API;

import io.javalin.http.Context;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class PersonController {
    private List<Person> family = new ArrayList<Person>();
    public void getAll(Context ctx) {
        try {
            ResultSet rs = Database.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                family.add(new Person(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getDate("birthdate"),
                        rs.getString("phone"), rs.getInt("FK_address")));
            }
            ctx.json(family);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getOne(Context ctx) {
//        Person p = new Person("john", "Doe", new Date(345323), "0794532123",
//                new Address(1, "steet", "1456", "modern city", "Suisse"));
//        ctx.json(p);
        try {
            ResultSet rs = Database.executeQuery("SELECT * FROM person WHERE id = '" + ctx.pathParam("id") + "'");
            rs.next();
            Person person = new Person(rs.getInt("id"), rs.getString("firstname"),
                    rs.getString("lastname"), rs.getDate("birthdate"),
                    rs.getString("phone"), rs.getInt("FK_address"));
            ctx.json(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void create(Context ctx) {
        try {
            Person person = ctx.bodyAsClass(Person.class);
            String sql = "INSERT INTO person VALUES ('" + person.getId() + "', '" + person.getFirstname()
                    + "', '" + person.getLastname() + "', '" + person.getBirthdate() + "', '" + person.getPhone()
                    + "', '" + person.getAddress() + ")";
            int affectedRows = Database.executeUpdate(sql);
            if (affectedRows > 0) {
                ctx.status(201);
            } else {
                ctx.status(500).result("Failed to create person");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500).result(e.getMessage());
        }
    }
    public void update(Context ctx) {
        try {
            Person person = ctx.bodyAsClass(Person.class);
            String sql = "UPDATE person SET firstname = '" + person.getFirstname()
                    + "', lastname = '" + person.getLastname() + "', birthdate = '" + person.getBirthdate()
                    + "', phone = '" + person.getPhone() + "', fk_address = '" + person.getAddress()
                    + " WHERE id = '" + ctx.pathParam("id") + "'";
            int affectedRows = Database.executeUpdate(sql);
            if (affectedRows > 0) {
                ctx.status(204);
            } else {
                ctx.status(500).result("Failed to update person");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500).result(e.getMessage());
        }
    }
    public void delete(Context ctx) {
        try {
            String sql = "DELETE FROM person WHERE id= '" + ctx.pathParam("id") + "'";
            int affectedRows = Database.executeUpdate(sql);
            if (affectedRows > 0) {
                ctx.status(204);
            } else {
                ctx.status(500).result("Failed to delete person");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(500).result(e.getMessage());
        }
    }
}
