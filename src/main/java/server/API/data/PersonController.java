package server.API.data;

import io.javalin.http.Context;
import server.API.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonController {
    public void getAll(Context ctx) {
        List<Person> family = new ArrayList<>();

        try(ResultSet rs = Database.executeQuery("SELECT * FROM person ORDER BY id;")) {

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
        try (ResultSet rs = Database.executeQuery("SELECT * FROM person WHERE id = '" + ctx.pathParam("id") + "'")){
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
            String sql = "INSERT INTO person VALUES ('" + person.id + "', '" + person.firstname + "', '"
                    + person.lastname + "', '" + person.birthdate + "', '" + person.phone + "', '"
                    + person.fk_address + "')";
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
            String sql = "UPDATE person SET firstname = '" + person.firstname + "', lastname = '" + person.lastname
                    + "', birthdate = '" + person.birthdate + "', phone = '" + person.phone
                    + "', fk_address = '" + person.fk_address
                    + "' WHERE id = '" + ctx.pathParam("id") + "'";
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
