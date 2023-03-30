package TicketSystem.GUI.Controller;

import TicketSystem.BE.Event;
import TicketSystem.GUI.Model.AppModel;
import TicketSystem.GUI.Model.EventMakerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventMakerController {

    private AppModel appModel;
    private final List<Image> images = new ArrayList<>();
    @FXML
    private Label ticketsSoldLbl2, createdByLbl;
    @FXML
    private DatePicker dpDateStart, dpDateEnd;
    @FXML
    private Button cancelBtn, createEventBtn, uploadPicBtn;
    @FXML
    private ImageView eventPicture;
    @FXML
    private TextField txtHeadline, txtDescription, txtTickets, txtLocation, txtTicketsAvail;

    public void handleUploadPicture(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select image files");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images",
                "*.png", "*.jpg", "*.gif", "*.tif", "*.bmp"));
        List<File> files = fileChooser.showOpenMultipleDialog(new Stage());

        if (!files.isEmpty())
        {
            files.forEach((File f) ->
            {
                images.add(new Image(f.toURI().toString()));
            });
            eventPicture.setImage((Image) images);
        }
    }

    public void handleCreateEvent(ActionEvent actionEvent) {
        String headline = txtHeadline.getText();
        String description = txtDescription.getText();
        //LocalDateTime dateStart = dpDateStart.getValue().atTime();
        //LocalDateTime dateEnd = dpDateEnd.getValue().atTime();
        String location = txtLocation.getText();
        int ticketsAvailable = Integer.parseInt(txtTicketsAvail.getText());
        int ticketsSold = Integer.parseInt(ticketsSoldLbl2.getText());
        String createdBy = createdByLbl.getText();

        Stage stage = (Stage) createEventBtn.getScene().getWindow();
        stage.close();
    }

    public void handleCancelBtn(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}