package TicketSystem.GUI.Model;

import TicketSystem.BE.Event;
import TicketSystem.BLL.EventManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class EventMakerModel {
    private EventManager eventManager;
    private ObservableList<Event> events;

    public EventMakerModel() throws Exception {
        eventManager = new EventManager();
        events = FXCollections.observableArrayList();
        events.addAll(eventManager.getAllEvents());
    }

    public ObservableList<Event> getObservableEvents() throws Exception {
        events.clear();
        events.addAll(eventManager.getAllEvents());
        return events;
    }

    public void createEvent(String name, String description, String eventStart, String eventEnd, String location, int maxTickets,
                            int soldTickets, int createdBy, Boolean Approved) throws Exception{
        Event event = eventManager.createEvent(name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy, Approved);
        events.add(event);
    }

    public void updateApproval(Event event, boolean approval) throws Exception {
        eventManager.updateApproval(event, approval);
    }
}
