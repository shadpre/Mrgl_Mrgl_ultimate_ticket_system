package TicketSystem.DAL.db;

import TicketSystem.BE.Event;
import TicketSystem.BE.User;

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
                String eventStart = resultSet.getString("EventStart");
                String eventEnd = resultSet.getString("EventEnd");
                String location = resultSet.getString("Location");
                int maxTickets = resultSet.getInt("MaxTickets");
                int soldTickets = resultSet.getInt("SoldTickets");
                int createdBy = resultSet.getInt("CreatedBy");
                boolean approved = resultSet.getBoolean("Approved");
                String date = resultSet.getString("Date");


                Event events = new Event(id, name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy, approved, date);

                allEvents.add(events);
            }

            return allEvents;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Could not get events from database", ex);
        }

    }

    public Event createEvent(String name, String description, String eventStart, String eventEnd, String location, int maxTickets,
                             int soldTickets, int createdBy, Boolean approved, String date) throws Exception {
        String sql = "INSERT INTO Events (name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy, Approved, date)VALUES (?,?,?,?,?,?,?,?,?,?);";

        try(Connection connection = databaseConnector.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, eventStart);
            statement.setString(4, eventEnd);
            statement.setString(5, location);
            statement.setInt(6, maxTickets);
            statement.setInt(7, soldTickets);
            statement.setInt(8, createdBy);
            statement.setBoolean(9, approved);
            statement.setString(10,date);

            statement.executeUpdate();
            //giving an ID value to the song we create.
            ResultSet rs = statement.getGeneratedKeys();
            int id = 0;

            if(rs.next());{
                id = rs.getInt(1);
            }

            Event event = new Event(id, name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy, approved, date);
            return event;
        }
        catch (SQLException exc){
            exc.printStackTrace();
            throw new Exception("Could not create song", exc);

        }
        //return null; // delete this later
    }

    public void deleteEvent(Event event) throws Exception {

        try(Connection connection = databaseConnector.getConnection()){

            String sql = "DELETE FROM dbo.Events WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, event.getID());

            statement.executeUpdate();
        }
        catch (SQLException exc){
            exc.printStackTrace();
            throw new Exception("Could not delete event", exc);
        }

    }
    public void updateEventApproval(Event event, boolean approval) throws Exception {

        String sql = "UPDATE Events SET  Approved=? WHERE ID = ?";

        try (Connection conn = databaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Bind parameters
            stmt.setBoolean(1,approval );
            stmt.setInt(2, event.getID());

            stmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Could not change Approval", ex);
        }
    }
}
