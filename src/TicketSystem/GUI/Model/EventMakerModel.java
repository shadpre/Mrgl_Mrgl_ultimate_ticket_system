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

    public ObservableList<Event> getObservableEvents() {
        return events;
    }

    public void createEvent(String name, String description, LocalDateTime eventStart, LocalDateTime eventEnd, String location, int maxTickets,
                            int soldTickets, String createdBy) throws Exception{
        Event event = eventManager.createEvent(name, description, eventStart, eventEnd, location, maxTickets, soldTickets, createdBy);
        events.add(event);
    }
}
