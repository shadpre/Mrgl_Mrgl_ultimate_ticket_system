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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController extends BaseController implements Initializable {
    private AppModel model;
    private EventMakerModel eventMakerModel;
    private EventPlannerController eventPlannerController;

    @FXML
    private Button customerEvents;

    @FXML
    private Button cancelSignUp;


    @FXML
    private TableColumn<Event, String> customerEnd;

    @FXML
    private TableColumn<Event, String> customerEventName;

    @FXML
    private TableColumn<Event, String> customerLocation;

    @FXML
    private TableColumn<Event, Integer> customerMax;


    @FXML
    private TableColumn<Event, Integer> customerSold;

    @FXML
    private TableColumn<Event, String> customerStart;

    @FXML
    private Button customerUser;

    @FXML
    private Text labelCustomer;

    @FXML
    public TableView<Event> tableCustomer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            eventMakerModel = new EventMakerModel();
            this.eventMakerModel = eventMakerModel;

            getCustomerEvents();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    public void handleCancelSignup(ActionEvent actionEvent) {
    }

    public void handleCustomerEvents(ActionEvent actionEvent) {
        try {

            Event selectedEvent = tableCustomer.getSelectionModel().getSelectedItem();

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

    public void getCustomerEvents() throws Exception {

        //getting the newest list with all users.
        eventMakerModel.getObservableEvents();


        //filtering list to get all planners
        ObservableList<Event> customerEvents = FXCollections.observableArrayList();
        for (Event event : eventMakerModel.getObservableEvents()) {
            if (event.isApproved() == true) {
                customerEvents.add(event);
            }
        }

        //clearing out the table
        tableCustomer.getItems().clear();

        customerMax.setCellValueFactory(new PropertyValueFactory<Event, Integer>("maxTickets"));
        customerSold.setCellValueFactory(new PropertyValueFactory<Event, Integer>("soldTickets"));
        customerStart.setCellValueFactory(new PropertyValueFactory<Event, String>("eventStart"));
        customerEnd.setCellValueFactory(new PropertyValueFactory<Event, String>("eventEnd"));
        customerEventName.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        customerLocation.setCellValueFactory(new PropertyValueFactory<Event, String>("location"));

        //adding the planners to our table.
        tableCustomer.setItems(customerEvents);
    }
}

