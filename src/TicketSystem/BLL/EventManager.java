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

    public Event createEvent(String name, String description, String eventStart, String eventEnd, String location, int maxTickets,
                             int soldTickets, int createdBy, Boolean Approved) throws Exception{
        return eventsDAO_db.createEvent(name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy, Approved);
    }

    public void updateApproval(Event event, boolean approval) throws Exception
    {
        eventsDAO_db.updateEventApproval(event,approval);
    }
}
