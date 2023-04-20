package TicketSystem.GUI.Controller;

import TicketSystem.BE.Event;
import TicketSystem.GUI.Model.AppModel;
import TicketSystem.GUI.Model.EventMakerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventPlannerController extends BaseController implements Initializable {

    private AppModel model;
    private Event event;
    private EventMakerModel eventMakerModel;
    @FXML
    private TableColumn<Event, String> eventEndDate;

    @FXML
    private TableColumn<Event, String> eventLocation;

    @FXML
    private TableColumn<Event, Integer> eventMTickets;

    @FXML
    private TableColumn<Event, String> eventName;

    @FXML
    private TableColumn<Event, String> eventStartDate;

    @FXML
    private TableColumn<Event, Integer> mESoldTickets;

    @FXML
    private TableView<Event> tableEventsPlanner;

    public void handleCreateEvent(ActionEvent actionEvent) {

        showCreateEvent();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/EventMaker.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("EASV Customer Events");
            stage.show();

            BaseController controller = loader.getController();
            controller.setModel(model);

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }


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
            controller.setModel(model);

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            eventMakerModel = new EventMakerModel();
            getApprovedEvents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void showCreateEvent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/EventMaker.fxml"));
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

    public void handleShowEEvent(ActionEvent actionEvent) {
        try {

            Event selectedEvent = tableEventsPlanner.getSelectionModel().getSelectedItem();

            if(selectedEvent != null) {
                eventMakerModel.setSelectedEvent(selectedEvent);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/EventInfo.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("EASV Events");
                stage.show();

                //setting controller and model for new window.

                EventInfoController controller = loader.getController();
                controller.setEventModel(eventMakerModel);
                controller.setUp(eventMakerModel);
            }

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void handleYourEEvent(ActionEvent actionEvent) {
    }

    public void getApprovedEvents() throws Exception {

        //getting the newest list with all users.
        eventMakerModel.getObservableEvents();


        //filtering list to get all planners
        ObservableList<Event> approvedEvents = FXCollections.observableArrayList();
        for (Event event : eventMakerModel.getObservableEvents()) {
            if (event.isApproved() == true) {
                approvedEvents.add(event);
            }
        }

        //clearing out the table
        tableEventsPlanner.getItems().clear();

        eventMTickets.setCellValueFactory(new PropertyValueFactory<Event, Integer>("maxTickets"));
        mESoldTickets.setCellValueFactory(new PropertyValueFactory<Event, Integer>("soldTickets"));
        eventStartDate.setCellValueFactory(new PropertyValueFactory<Event, String>("eventStart"));
        eventEndDate.setCellValueFactory(new PropertyValueFactory<Event, String>("eventEnd"));
        eventName.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        eventLocation.setCellValueFactory(new PropertyValueFactory<Event, String>("location"));

        //adding the planners to our table.
        tableEventsPlanner.setItems(approvedEvents);
    }
}


