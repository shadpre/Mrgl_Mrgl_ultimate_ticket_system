package TicketSystem.BE;

import java.time.*;

public class Event {
    private int ID;
    private String Name;
    private String Description;
    private LocalDateTime EventStart;
    private LocalDateTime EventEnd;
    private String Location;
    private int MaxTickets;
    private int SoldTickets;
    private int CreatedBy;

    public Event(int ID, String name, String description, LocalDateTime eventStart, LocalDateTime eventEnd, String location, int maxTickets, int soldTickets, int createdBy) {
        this.ID = ID;
        Name = name;
        Description = description;
        EventStart = eventStart;
        EventEnd = eventEnd;
        Location = location;
        MaxTickets = maxTickets;
        SoldTickets = soldTickets;
        CreatedBy = createdBy;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public LocalDateTime getEventStart() {
        return EventStart;
    }

    public LocalDateTime getEventEnd() {
        return EventEnd;
    }

    public String getLocation() {
        return Location;
    }

    public int getMaxTickets() {
        return MaxTickets;
    }

    public int getSoldTickets() {
        return SoldTickets;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }
}
