package TicketSystem.BE;

import java.time.LocalDateTime;


public class Ticket {
    private String ID;
    private int CustomerID;
    private int EventID;
    private LocalDateTime CreatedTime;
    private boolean IsUsed;
    private int SoldBy;

    public Ticket(String ID, int customerID, int eventID, LocalDateTime createdTime, boolean isUsed, int soldBy) {
        this.ID = ID;
        CustomerID = customerID;
        EventID = eventID;
        CreatedTime = createdTime;
        IsUsed = isUsed;
        SoldBy = soldBy;
    }

    public String getID() {
        return ID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public int getEventID() {
        return EventID;
    }

    public LocalDateTime getCreatedTime() {
        return CreatedTime;
    }

    public boolean isUsed() {
        return IsUsed;
    }

    public int getSoldBy() {
        return SoldBy;
    }
}
