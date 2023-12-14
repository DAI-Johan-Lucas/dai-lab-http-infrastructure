package dai.server.API;

import io.javalin.http.Context;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class PersonController {
    private List<Person> family = new ArrayList<Person>();
    public void getAll(Context ctx) {
//        try {
//            ResultSet rs = Database.executeQuery("SELECT * FROM employe");
//            while (rs.next()) {
//                employees.add(new Employe(rs.getString("idlogin"), rs.getString("mdplogin"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("datenaissance"), rs.getDate("datedebutcontrat"), rs.getString("fonction"), rs.getString("numtelephone"), rs.getString("typepermis"), rs.getInt("fk_adresse"), rs.getInt("fk_decheterie")));
//            }
//            ctx.json(employees);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public void getOne(Context ctx) {
        Person p = new Person("john", "Doe", new Date(345323), "0794532123",
                new Address(1, "steet", "1456", "modern city", "Suisse"));
        ctx.json(p);
//        try {
//            ResultSet rs = Database.executeQuery("SELECT * FROM employe WHERE idlogin = '" + ctx.pathParam("idlogin") + "'");
//            rs.next();
//            Employe employe = new Employe(rs.getString("idlogin"), rs.getString("mdplogin"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("datenaissance"), rs.getDate("datedebutcontrat"), rs.getString("fonction"), rs.getString("numtelephone"), rs.getString("typepermis"), rs.getInt("fk_adresse"), rs.getInt("fk_decheterie"));
//            ctx.json(employe);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public void create(Context ctx) {
//        try {
//            Employe employe = ctx.bodyAsClass(Employe.class);
//            String sql = "INSERT INTO employe VALUES ('" + employe.idlogin + "', '" + employe.mdplogin + "', '" + employe.nom + "', '" + employe.prenom + "', '" + employe.datenaissance + "', '" + employe.datedebutcontrat + "', '" + employe.fonction + "', '" + employe.numtelephone + "', '" + employe.typepermis + "', " + employe.fk_adresse + ", " + employe.fk_decheterie + ")";
//            int affectedRows = Database.executeUpdate(sql);
//            if (affectedRows > 0) {
//                ctx.status(201);
//            } else {
//                ctx.status(500).result("Failed to create employee");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            ctx.status(500).result(e.getMessage());
//        }
    }
    public void update(Context ctx) {
//        try {
//            Employe employe = ctx.bodyAsClass(Employe.class);
//            String sql = "UPDATE employe SET mdplogin = '" +
//                    employe.mdplogin + "', nom = '" + employe.nom + "', prenom = '" + employe.prenom + "', datenaissance = '" + employe.datenaissance + "', datedebutcontrat = '" + employe.datedebutcontrat + "', fonction = '" + employe.fonction + "', numtelephone = '" + employe.numtelephone + "', typepermis = '" + employe.typepermis + "', fk_adresse = " + employe.fk_adresse + ", fk_decheterie = " + employe.fk_decheterie + " WHERE idlogin = '" + ctx.pathParam("idlogin") + "'";
//            int affectedRows = Database.executeUpdate(sql);
//            if (affectedRows > 0) {
//                ctx.status(204);
//            } else {
//                ctx.status(500).result("Failed to update employee");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            ctx.status(500).result(e.getMessage());
//        }
    }
    public void delete(Context ctx) {
//        try {
//            String sql = "DELETE FROM employe WHERE idlogin = '" + ctx.pathParam("idlogin") + "'";
//            int affectedRows = Database.executeUpdate(sql);
//            if (affectedRows > 0) {
//                ctx.status(204);
//            } else {
//                ctx.status(500).result("Failed to delete employee");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            ctx.status(500).result(e.getMessage());
//        }
    }
}
