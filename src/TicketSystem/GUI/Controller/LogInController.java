package TicketSystem.GUI.Controller;

import TicketSystem.BE.User;
import TicketSystem.GUI.Model.AppModel;
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
import java.util.ResourceBundle;


public class LogInController extends BaseController implements Initializable {

    private AppModel model;
    private User user;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField userNameTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new AppModel();
    }

    public void handleLogIn(ActionEvent actionEvent) {
        String password = passwordTxt.getText();
        String username = userNameTxt.getText();

        if (password == "admin" && username == "admin") {
            showAdminWindow();
        }

        if (password == "customer" && username == "customer") {
            showCustomerWindow();
        }

        if (password == "planner" && username == "planner") {
            showEventPlanner();}

        else{

        }
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


}