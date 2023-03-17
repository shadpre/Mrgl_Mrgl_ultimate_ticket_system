package TicketSystem.BE;

public class Customer {
    private int ID;
    private String Name;
    private String EMail;

    public Customer(int ID, String name, String EMail) {
        this.ID = ID;
        Name = name;
        this.EMail = EMail;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEMail() {
        return EMail;
    }
}
