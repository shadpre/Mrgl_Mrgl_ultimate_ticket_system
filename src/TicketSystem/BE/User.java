package TicketSystem.BE;

public class User {

    private int ID;


    private String Name;
    private String Login;
    private String Password;

    private int IsSpecial;
    private int IsSysAdmin;


    public User(int ID, String name, String login, String password, int isSysAdmin, int isSpecial) {
        this.ID = ID;
        Name = name;
        Login = login;
        Password = password;
        IsSysAdmin = isSysAdmin;
        IsSpecial = isSpecial;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setIsSpecial(int isSpecial) {
        IsSpecial = isSpecial;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public int getIsSpecial() {
        return IsSpecial;
    }


}

