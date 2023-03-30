package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Model.UserModel;
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

public class AdminController implements Initializable {

    private UserModel userModel;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            userModel = new UserModel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void handleAdmingPage(ActionEvent actionEvent) {
    }

    public void handleAddPlanner(ActionEvent actionEvent) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/CreatePlanner.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("EASV Events");
                stage.show();

                BaseController controller = loader.getController();
                controller.setUserModel(userModel);
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "");
                alert.showAndWait();
            }
    }


    public void handleDeleteUser(ActionEvent actionEvent) {
    }

    public void handleCreateAEvent(ActionEvent actionEvent) {
    }

    public void handleUpdateAEvent(ActionEvent actionEvent) {
    }

    public void handleDeleteAEvent(ActionEvent actionEvent) {
    }

    public void handleShowPlanners(ActionEvent actionEvent) {
    }

    public void handleShowAEvent(ActionEvent actionEvent) {
    }

    public void handleCancel(ActionEvent actionEvent) {
    }

    public void handleApprove(ActionEvent actionEvent) {
    }

    public void handleConfirm(ActionEvent actionEvent) {
    }

    public void handleAllAEvents(ActionEvent actionEvent) {
    }

    public void handleAllPlanners(ActionEvent actionEvent) {
    }

    public void handleAllCustomers(ActionEvent actionEvent) {
    }
}
