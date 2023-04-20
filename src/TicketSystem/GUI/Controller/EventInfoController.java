package TicketSystem.GUI.Controller;

import TicketSystem.BE.Event;
import TicketSystem.GUI.Model.EventMakerModel;
import TicketSystem.GUI.Model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EventInfoController extends BaseController implements Initializable {

    @FXML
    private Button infoCancel;

    @FXML
    private Button bookTicket;

    @FXML
    private Label infoDate;

    @FXML
    private TextArea textDescript;

    @FXML
    private Label infoEnd;

    @FXML
    private Label infoLoc;

    @FXML
    private Label infoMax;

    @FXML
    private Label infoName;

    @FXML
    private Label infoSold;

    @FXML
    private Label infoStart;

    private CustomerController customerController;

    private EventMakerModel eventMakerModel;

    private UserModel userModel;

    private Event event;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void handleBookTicket(ActionEvent actionEvent) {
    }


    public void setUp(EventMakerModel eventMakerModel) throws Exception {

        this.eventMakerModel = eventMakerModel;
        eventMakerModel.getObservableEvents();

        int ticketsLeft = eventMakerModel.getSelectedEvent().getMaxTickets() - eventMakerModel.getSelectedEvent().getSoldTickets();
        infoName.setText(eventMakerModel.getSelectedEvent().getName());
        textDescript.setText(eventMakerModel.getSelectedEvent().getDescription());
        textDescript.setWrapText(true);
        infoLoc.setText(eventMakerModel.getSelectedEvent().getLocation());
        infoSold.setText(String.valueOf(eventMakerModel.getSelectedEvent().getMaxTickets()));
        infoMax.setText(String.valueOf(ticketsLeft));
        infoDate.setText(eventMakerModel.getSelectedEvent().getDate());
        infoStart.setText(eventMakerModel.getSelectedEvent().getEventStart());
        infoEnd.setText(eventMakerModel.getSelectedEvent().getEventEnd());

    }

    public void handleInfoCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) infoCancel.getScene().getWindow();
        stage.close();
    }
}