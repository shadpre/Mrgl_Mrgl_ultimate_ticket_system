package TicketSystem.BE;

import java.time.*;

public class Event {
    private int ID;
    private String Name;
    private String Description;
    private String EventStart;
    private String EventEnd;
    private String Location;
    private int MaxTickets;
    private int SoldTickets;
    private int CreatedBy;

    private boolean Approved;
    private String Date;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setEventStart(String eventStart) {
        EventStart = eventStart;
    }

    public void setEventEnd(String eventEnd) {
        EventEnd = eventEnd;
    }

    public void setDate(String date){Date = date;}

    public String getDate() {
        return Date;
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

    public Event(int ID, String name, String description, String eventStart, String eventEnd, String location, int maxTickets, int soldTickets, int createdBy, boolean approved, String date) {
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
        Date = date;
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

    public String getEventStart() {
        return EventStart;
    }

    public String getEventEnd() {
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
