package TicketSystem.DAL.db;

import TicketSystem.BE.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventsDAO_DB {
    private DatabaseConnector databaseConnector;

    public EventsDAO_DB() throws IOException {
        databaseConnector = new DatabaseConnector();
    }

    public List<User> getAllEvents() throws Exception {

        ArrayList<User> allEvents = new ArrayList<>();


        try (Connection conn = databaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM dbo.Users;";


            ResultSet rs = stmt.executeQuery(sql);

            // Loop through rows from the database result set
            while (rs.next()) {


                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String login = rs.getString("Login");
                String password = rs.getString("Password");
                int isSpecial = rs.getInt("isSpecial");

                User users = new User(id, name, login, password, isSpecial);

                allEvents.add(users);
            }

            return allEvents;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Could not get events from database", ex);
        }

    }
}
