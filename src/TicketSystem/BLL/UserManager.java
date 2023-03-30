package TicketSystem.BLL;

import TicketSystem.BE.User;
import TicketSystem.DAL.db.UsersDAO_DB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class UserManager {
    private UsersDAO_DB usersDAO_db;

    public UserManager() throws SQLException, IOException {
        usersDAO_db = new UsersDAO_DB();

    }

    public List<User> getAllUsers() throws Exception {
        return usersDAO_db.getAllUsers();
    }

    public User createPlanner(String name, String login, String password, int isSysAdmin, int isSpecial) throws Exception {
        return usersDAO_db.createPlanner(name, login, password, isSysAdmin, isSpecial);
    }

}



