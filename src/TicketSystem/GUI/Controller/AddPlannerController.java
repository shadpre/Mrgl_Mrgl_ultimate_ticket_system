package TicketSystem.GUI.Controller;

import TicketSystem.BE.User;
import TicketSystem.DAL.db.UsersDAO_DB;
import TicketSystem.GUI.Model.AppModel;
import TicketSystem.GUI.Model.UserModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntBinaryOperator;

public class AddPlannerController implements Initializable {
    @FXML
    private Button addPlanner;

    @FXML
    private Button cancelAddPlanner;

    @FXML
    private TextField plannerLogin;

    @FXML
    private TextField plannerName;

    @FXML
    private TextField plannerPass;

    private AdminController adminController;
    private LogInController logInController;

    private UsersDAO_DB usersDAO_db;
    private UserModel userModel;
    private AppModel appModel;



    @Override
    //Initialize Method, instanciating Controllers and Models for use.

    public void initialize(URL location, ResourceBundle resources) {

        try{
            userModel = new UserModel();
            adminController = new AdminController();
            logInController = new LogInController();
            usersDAO_db = new UsersDAO_DB();

            this.userModel = userModel;
            this.usersDAO_db = usersDAO_db;
            this.adminController = adminController;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    //Method for adding a planner, it uses a show-alert method if something is wrong.
    public void handleAddPlanner(ActionEvent actionEvent) {

            String name = plannerName.getText();
            String login = plannerLogin.getText();
            String password = plannerPass.getText();
            int isSysAdmin = 0;
            int isSpecial = 2;
            boolean isUsernameAvailable = true;




        for (User user : userModel.getUsersForCheck()) {
            if (user.getLogin().equals(login)) {
                isUsernameAvailable = false;
                break;
            }
        }

        if (isUsernameAvailable) {
            try {
                userModel.createPlanner(name, login, password, isSysAdmin, isSpecial);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logInController.showAlert("Username already Exist");
        }

        Stage stage = (Stage) addPlanner.getScene().getWindow();
        stage.close();

    }




    public void handleCancelAddPlanner(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelAddPlanner.getScene().getWindow();
        stage.close();
    }
}
