package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Controller.EventPosterController;
import TicketSystem.GUI.Model.AppModel;
import TicketSystem.GUI.Model.EventPosterModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController extends BaseController implements Initializable {
    private AppModel model;

    @FXML
    private VBox vboxGrid;

    @FXML
    private GridPane gridCustomer;



    private List<EventPosterModel> events = new ArrayList<>();

    private List<EventPosterModel> getData(){
        List<EventPosterModel> events = new ArrayList<>();
        EventPosterModel eventPosterModel;

        eventPosterModel = new EventPosterModel();
        eventPosterModel.setName("Ticket # 1");
        events.add(eventPosterModel);

        eventPosterModel = new EventPosterModel();
        eventPosterModel.setName("Ticket # 2");
        events.add(eventPosterModel);

        eventPosterModel = new EventPosterModel();
        eventPosterModel.setName("Ticket # 3");
        events.add(eventPosterModel);

        return events;


    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void handleCustomerAllEvents(ActionEvent actionEvent) {

        events.addAll(getData());
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < events.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/TicketSystem/GUI/View/EventPoster.fxml"));
                VBox box = fxmlLoader.load();
                EventPosterController eventPosterController = fxmlLoader.getController();
                eventPosterController.setData(events.get(i));

                if (column == 1){
                    column = 0;
                    row++;
                }

                gridCustomer.add(box, column++, row);
                GridPane.setMargin(box, new Insets(10));

                // set Grid With
                gridCustomer.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridCustomer.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridCustomer.setMaxWidth(Region.USE_PREF_SIZE);

                // set Grid Height
                gridCustomer.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridCustomer.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridCustomer.setMaxHeight(Region.USE_PREF_SIZE);


            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


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
