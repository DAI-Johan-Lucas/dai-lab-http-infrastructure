package server.API.data;

import io.javalin.http.Context;
import server.API.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressController {
    public void getAll(Context ctx) {
        List<Address> addresses = new ArrayList<>();

        try {
            ResultSet rs = Database.executeQuery("SELECT * FROM address");
            while (rs.next()) {
                addresses.add(new Address(rs.getInt("id"), rs.getString("street"),
                        rs.getString("npa"), rs.getString("city"),
                        rs.getString("country")));
            }
            ctx.json(addresses);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
