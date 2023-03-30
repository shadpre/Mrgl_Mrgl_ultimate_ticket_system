package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Model.AppModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import TicketSystem.GUI.Model.EventPosterModel;


public class CustomerController extends BaseController implements Initializable {

    @FXML
    private GridPane gridCustomer;
    @FXML
    private ScrollPane scrollCustomer;
    private AppModel model;



    private List<EventPosterModel> events = new ArrayList<>();

    private List<EventPosterModel> getData(){
        List<EventPosterModel> events = new ArrayList<>();

        EventPosterModel eventPosterModel;

        eventPosterModel = new EventPosterModel();
        eventPosterModel.setHeadline("Fotball Denmark vs. France");
        eventPosterModel.setDate("12/05-23");
        eventPosterModel.setStartTime(19.00);
        eventPosterModel.setPlace("Sp. Kirkevej 103, Esbjerg");
        eventPosterModel.setDescription("Come and watch the game in the bar");
        eventPosterModel.setTotalTickets(200);
        eventPosterModel.setTicketsLeft(112);
        eventPosterModel.setPosterImg("data/img/DKvsFR.jpg");
        events.add(eventPosterModel);

        return events;
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        events.addAll(getData());
        int column = 1;
        int row = 1;

        try{
            for(int i =0; i < events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("TicketSystem/GUI/View/EventPoster.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventPosterController eventPosterController = fxmlLoader.getController();
                eventPosterController.setData(events.get(i));

                if (column == 1){
                    column = 0;
                    row++;

                }

                gridCustomer.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        
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

            BaseController controller = loader.getController();
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }
    }
}
