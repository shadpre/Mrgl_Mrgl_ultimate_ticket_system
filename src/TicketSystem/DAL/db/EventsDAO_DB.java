package TicketSystem.DAL.db;

import TicketSystem.BE.Event;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventsDAO_DB {
    private DatabaseConnector databaseConnector;

    public EventsDAO_DB() throws IOException {
        databaseConnector = new DatabaseConnector();
    }

    public List<Event> getAllEvents() throws Exception {

        ArrayList<Event> allEvents = new ArrayList<>();


        try (Connection conn = databaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM dbo.Events;";


            ResultSet resultSet = stmt.executeQuery(sql);

            // Loop through rows from the database result set
            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String description = resultSet.getString("Description");
                LocalDateTime eventStart = resultSet.getTimestamp("EventStart").toLocalDateTime();
                LocalDateTime eventEnd = resultSet.getTimestamp("EventEnd") != null ? resultSet.getTimestamp("EventEnd").toLocalDateTime() : null;
                String location = resultSet.getString("Location");
                int maxTickets = resultSet.getInt("MaxTickets");
                int soldTickets = resultSet.getInt("SoldTickets");
                int createdBy = resultSet.getInt("CreatedBy");
                boolean approved = resultSet.getBoolean("Approved");


                Event events = new Event(id, name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy, approved);

                allEvents.add(events);
            }

            return allEvents;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Could not get events from database", ex);
        }

    }

    public Event createEvent(String name, String description, LocalDateTime eventStart, LocalDateTime eventEnd, String location, int maxTickets,
                             int soldTickets, String createdBy, Boolean approved) throws Exception {
        String sql = "INSERT INTO Event (name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy, Approved)VALUES (?,?,?,?,?,?,?,?,?);";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, name);
            statement.setString(2, description);
            //statement.setDate(3, eventStart);
            //statement.setDate(4, eventEnd);
            statement.setString(5, location);
            statement.setInt(6, maxTickets);
            statement.setInt(7, soldTickets);
            statement.setString(8, createdBy);

            statement.executeUpdate();
            //giving an ID value to the song we create.
            ResultSet rs = statement.getGeneratedKeys();
            int id = 0;

            if(rs.next());{
                id = rs.getInt(1);
            }

            //Event event = new Event(id, name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy);
            //return event;
        }
        catch (SQLException exc){
            exc.printStackTrace();
            throw new Exception("Could not create song", exc);

        }
        return null; // delete this later
    }
}
