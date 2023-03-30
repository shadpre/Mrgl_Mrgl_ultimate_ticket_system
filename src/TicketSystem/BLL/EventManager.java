package TicketSystem.BLL;

import TicketSystem.BE.Event;
import TicketSystem.DAL.db.EventsDAO_DB;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class EventManager {

    private EventsDAO_DB eventsDAO_db;

    public EventManager() throws SQLException, IOException {
        eventsDAO_db = new EventsDAO_DB();
    }

    public List<Event>getAllEvents() throws Exception {
        return eventsDAO_db.getAllEvents();
    }

    public Event createEvent(String name, String description, LocalDateTime eventStart, LocalDateTime eventEnd, String location, int maxTickets,
                             int soldTickets, String createdBy) throws Exception{
        return eventsDAO_db.createEvent(name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy);
    }
}
