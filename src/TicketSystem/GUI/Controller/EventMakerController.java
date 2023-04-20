package TicketSystem.GUI.Controller;

import TicketSystem.BE.Event;
import TicketSystem.GUI.Model.AppModel;
import TicketSystem.GUI.Model.EventMakerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EventMakerController extends BaseController implements Initializable {

    private AppModel appModel;

    private EventMakerModel eventMakerModel;

    private final List<Image> images = new ArrayList<>();
    @FXML
    private Label ticketsSoldLbl2, createdByLbl;
    @FXML
    private DatePicker makerDate;
    @FXML
    private Button cancelBtn, createEventBtn, uploadPicBtn;
    @FXML
    private ImageView eventPicture;
    @FXML
    private TextField makerName, makerLocation, makerStart, makerEnd, makerTickets;

    @FXML
    private TextArea makerDescript;

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

    public void handleCreateEvent(ActionEvent actionEvent) throws Exception {

        String name = makerName.getText();
        String description = makerDescript.getText();
        String eventStart = makerStart.getText();
        String eventEnd = makerEnd.getText();
        String location = makerLocation.getText();
        int maxTickets = Integer.parseInt(makerTickets.getText());
        int ticketsSold = 0;
        int createdBy = 1;
        boolean approved = false;
        String date = makerDate.getValue().toString();

        eventMakerModel.createEvent(name, description, eventStart, eventEnd, location, maxTickets, ticketsSold, createdBy, approved, date );

        Stage stage = (Stage) createEventBtn.getScene().getWindow();
        stage.close();
    }

    public void handleCancelBtn(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            eventMakerModel = new EventMakerModel();
            this.eventMakerModel = eventMakerModel;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}