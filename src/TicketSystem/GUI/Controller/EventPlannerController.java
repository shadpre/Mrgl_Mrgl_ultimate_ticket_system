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

public class EventPlannerController extends BaseController implements Initializable {

    private AppModel appModel;


    public void handleCreateEvent(ActionEvent actionEvent) {
    }

    public void handleDeleteEvent(ActionEvent actionEvent) {
    }

    public void handleUpdateEvent(ActionEvent actionEvent) {
    }

    public void handleUser(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/CustomerView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("EASV Customer Events");
            stage.show();

            BaseController controller = loader.getController();
            controller.setModel(appModel);

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        }
}

