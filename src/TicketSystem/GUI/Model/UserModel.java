package TicketSystem.GUI.Model;

import TicketSystem.BE.User;
import TicketSystem.BLL.UserManager;
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

}