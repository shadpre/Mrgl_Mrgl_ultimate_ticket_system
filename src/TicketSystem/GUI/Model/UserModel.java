package TicketSystem.GUI.Model;

import TicketSystem.BE.User;
import TicketSystem.BLL.UserManager;
import TicketSystem.DAL.db.UsersDAO_DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserModel {
    private ObservableList<User> usersForCheck;
    private UserManager userManager;

    public UserModel() throws Exception {
        userManager = new UserManager();
        usersForCheck = FXCollections.observableArrayList();
        usersForCheck.addAll(userManager.getAllUsers());
    }

    public ObservableList<User> getUsersForCheck() {
        return usersForCheck;
    }

    public ObservableList<User> showList() throws Exception {
        //Update the listview
        usersForCheck.clear();
        usersForCheck.addAll(userManager.getAllUsers());
        return usersForCheck;
    }

    public void createPlanner(String name, String login, String password, int isSysAdmin, int isSpecial) throws Exception {
        User u = userManager.createPlanner(name, login, password, isSysAdmin, isSpecial);

        usersForCheck.add(u);
    }

}