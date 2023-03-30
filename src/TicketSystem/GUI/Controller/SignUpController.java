package TicketSystem.GUI.Controller;

import TicketSystem.BE.User;
import TicketSystem.GUI.Model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController extends BaseController implements Initializable {
    private UserModel userModel;
    private LogInController logInController;

    @FXML
    private Button cancelCustomerSignup;

    @FXML
    private TextField customerLogin;

    @FXML
    private TextField customerName;

    @FXML
    private TextField customerPassword;

    @FXML
    private Button customerSignup;
    public void handleCustomerSignup(ActionEvent actionEvent) {

        //our information for the creation.

        String name = customerName.getText();
        String login = customerLogin.getText();
        String password = customerPassword.getText();
        int isSysAdmin = 0;
        int isSpecial = 3;
        boolean isUsernameAvailable = true;

        //checking we don't already have a user like that.

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

        Stage stage = (Stage) customerSignup.getScene().getWindow();
        stage.close();
    }

    public void handleCancelCustomerSignup(ActionEvent actionEvent) {

        Stage stage = (Stage) cancelCustomerSignup.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            userModel = new UserModel();
            this.userModel = userModel;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
