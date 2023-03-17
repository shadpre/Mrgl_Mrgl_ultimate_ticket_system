package TicketSystem.BE;

public class User {

    private int ID;
    private String Name;
    private String Login;
    private String Password;
    private boolean IsSysAdmin;

    public User(int ID, String name, String login, String password, boolean isSysAdmin) {
        this.ID = ID;
        Name = name;
        Login = login;
        Password = password;
        IsSysAdmin = isSysAdmin;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public boolean isSysAdmin() {
        return IsSysAdmin;
    }
}
