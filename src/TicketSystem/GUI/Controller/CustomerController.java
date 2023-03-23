package TicketSystem.GUI.Controller;

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

public class CustomerController implements Initializable {
    private AppModel model;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void handleCustomerAllEvents(ActionEvent actionEvent) {
    }

    public void handleCancelSignup(ActionEvent actionEvent) {
    }

    public void handleCustomerEvents(ActionEvent actionEvent) {
    }

    public void handleCustomerUser(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/AdminView.fxml"));
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
}
