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

    private boolean Approved;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setEventStart(LocalDateTime eventStart) {
        EventStart = eventStart;
    }

    public void setEventEnd(LocalDateTime eventEnd) {
        EventEnd = eventEnd;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setMaxTickets(int maxTickets) {
        MaxTickets = maxTickets;
    }

    public void setSoldTickets(int soldTickets) {
        SoldTickets = soldTickets;
    }

    public void setCreatedBy(int createdBy) {
        CreatedBy = createdBy;
    }

    public Event(int ID, String name, String description, LocalDateTime eventStart, LocalDateTime eventEnd, String location, int maxTickets, int soldTickets, int createdBy, boolean approved) {
        this.ID = ID;
        Name = name;
        Description = description;
        EventStart = eventStart;
        EventEnd = eventEnd;
        Location = location;
        MaxTickets = maxTickets;
        SoldTickets = soldTickets;
        CreatedBy = createdBy;
        Approved = approved;
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

    public boolean isApproved() {
        return Approved;
    }

    public void setApproved(boolean approved) {
        Approved = approved;
    }
}
