package TicketSystem.GUI.Controller;

import TicketSystem.BE.User;
import TicketSystem.GUI.Model.AppModel;
import TicketSystem.GUI.Model.UserModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class LogInController extends BaseController implements Initializable {

    private AppModel model;
    private User user;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField userNameTxt;

    private UserModel usermodel;

    private ObservableList<User> usersForCheck;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            usermodel = new UserModel();
            model = new AppModel();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model = new AppModel();
    }



        public String logInCheck(String username, String password, ObservableList<User> usersForCheck) {
            for (User user : usersForCheck) {

                if (user.getLogin().equals(username) && user.getPassword().equals(password)) {
                    if (user.getIsSpecial() == 1) {
                        showAdminWindow();
                    }
                    if (user.getIsSpecial() == 2) {

                        showEventPlanner();
                    }

                    if (user.getIsSpecial() == 3) {
                        showCustomerWindow();

                    }

                }
            }

            showAlert("User does not exist");
            return null;
        }

    public void handleNewUser(ActionEvent actionEvent) {


    }


    public void showEventPlanner() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/EventPlannerView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("EASV Events");
            stage.show();

            BaseController controller = loader.getController();
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }
    }

    public void showCustomerWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/CustomerView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("EASV Events");
            stage.show();

            BaseController controller = loader.getController();
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }
    }

    public void showAdminWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/AdminView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("EASV Events");
            stage.show();

            BaseController controller = loader.getController();
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }
    }


    public void handleLogIn(ActionEvent actionEvent) {
        String username = userNameTxt.getText();
        String password = passwordTxt.getText();
        ObservableList<User> usersForCheck = usermodel.getUsersForCheck();
        logInCheck(username, password, usersForCheck);
    }


        public static void showAlert(String message) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }
