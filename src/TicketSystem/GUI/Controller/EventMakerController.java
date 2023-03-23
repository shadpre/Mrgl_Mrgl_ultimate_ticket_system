package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Model.EventMakerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EventMakerController {
    private EventMakerModel eventMakerModel;
    @FXML
    private Button cancelBtn, createEventBtn, uploadPicBtn;
    @FXML
    private ImageView eventPicture;
    @FXML
    private TextField txtHeadline, txtDescription, txtTickets, txtAddress;

    public void handleUploadPicture(ActionEvent actionEvent) {
    }

    public void handleCreateEvent(ActionEvent actionEvent) {
        String headline = txtHeadline.getText();
        String description = txtDescription.getText();
        // int datePicker =
        String address = txtAddress.getText();
        int tickets = Integer.parseInt(txtHeadline.getText());

        Stage stage = (Stage) createEventBtn.getScene().getWindow();
        stage.close();
    }

    public void handleCancelBtn(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}