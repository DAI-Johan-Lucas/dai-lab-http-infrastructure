package dai.server.API;

import java.sql.*;

public class Database {
    private static final String DATABASE_URL = "jdbc:postgresql://host.docker.internal:55055/dai?currentSchema=dai-lab-http-infrastructure";
    private static final String DATABASE_USER = "dai";
    private static final String DATABASE_PASSWORD = "dai";

    private static Connection connection;

    private Database() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }


    public static ResultSet executeQuery(String query)throws SQLException, ClassNotFoundException {
        if (connection == null) {
            new Database();
        }

        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int executeUpdate(String query)throws SQLException, ClassNotFoundException {
        if (connection == null) {
            new Database();
        }

        try {
            Statement stmt = connection.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}