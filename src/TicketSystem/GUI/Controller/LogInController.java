package TicketSystem.GUI.Controller;

import TicketSystem.BE.User;
import TicketSystem.GUI.Model.AppModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LogInController implements Initializable {

    private AppModel model;
    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new AppModel();
    }

    public void handleLogIn(ActionEvent actionEvent) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/EventPlannerView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("EASV Events");
            stage.show();

            MainViewController controller = loader.getController();
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }


    }

    public void handleNewUser(ActionEvent actionEvent) {
    }
}