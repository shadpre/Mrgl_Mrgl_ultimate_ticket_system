package TicketSystem.GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import TicketSystem.GUI.Model.EventPosterModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import TicketSystem.GUI.Model.AppModel;



public class EventPosterController {

    @FXML
    private Button BuyBtn;

    @FXML
    private Label dateLbl, headlineLbl, placeLbl, startLbl, ticketLeftLbl, totalTicketLbl;

    @FXML
    private TextArea descriptionField;
    @FXML
    private ImageView posterImg;

    private EventPosterModel eventPosterModel;

    private AppModel model;

    public void setData (EventPosterModel eventPosterModel){

        this.eventPosterModel = eventPosterModel;
        headlineLbl.setText(eventPosterModel.getHeadline());
        dateLbl.setText(eventPosterModel.getDate());
        placeLbl.setText(eventPosterModel.getPlace());
        startLbl.setText(String.valueOf(eventPosterModel.getStartTime()));
        ticketLeftLbl.setText(String.valueOf(eventPosterModel.getTicketsLeft()));
        totalTicketLbl.setText(String.valueOf(eventPosterModel.getTotalTickets()));
        descriptionField.setText(eventPosterModel.getDescription());
        Image image = new Image(getClass().getResourceAsStream(eventPosterModel.getPosterImg()));
        posterImg.setImage(image);



    }






}
