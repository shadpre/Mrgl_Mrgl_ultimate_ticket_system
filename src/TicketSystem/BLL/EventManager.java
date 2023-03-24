package TicketSystem.BLL;

import TicketSystem.BE.Event;
import TicketSystem.BE.User;
import TicketSystem.DAL.db.EventsDAO_DB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EventManager {

    private EventsDAO_DB eventsDAO_db;

    public EventManager() throws SQLException, IOException {
        eventsDAO_db = new EventsDAO_DB();
    }

    public List<User> getAllEvents() throws Exception {
        return eventsDAO_db.getAllEvents();
    }

    public Event createEvent(String headline, String description, String address, int tickets) {
        return null; // needs to return DB
    }
}
