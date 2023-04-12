package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Model.EventPosterModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EventPosterController {

    @FXML
    private Label ticketLbl;

    private EventPosterModel eventPosterModel;

    public void setData(EventPosterModel eventPosterModel){
        this.eventPosterModel = eventPosterModel;
        ticketLbl.setText(eventPosterModel.getName());
    }

}
