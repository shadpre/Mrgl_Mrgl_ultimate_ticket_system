package TicketSystem.GUI.Controller;

import TicketSystem.BE.Event;
import TicketSystem.BE.User;
import TicketSystem.GUI.Model.EventMakerModel;
import TicketSystem.GUI.Model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController extends BaseController implements Initializable {

    private UserModel userModel;

    private Event event;

    private ObservableList<User> getUsersForCheck;

    private LogInController logInController;

    private EventMakerModel eventMakerModel;
    @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User, String> tableName;
    @FXML
    private TableColumn<User, String> tableLogin;
    @FXML
    private TableColumn<User, String> tablePassword;

    @FXML
    private TableView<Event> tableEvents;

    @FXML
    private TableColumn<Event, Boolean> eventApproval;

    @FXML TableColumn<Event, String> adminTableDate;

    @FXML
    private TableColumn<Event, String> eventEnd;

    @FXML
    private TableColumn<Event, String> eventLocation;

    @FXML
    private TableColumn<Event, String> eventName;

    @FXML
    private TableColumn<Event, String> eventStart;

    @FXML
    private Button approve, cancel;



    public AdminController() {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            userModel = new UserModel();
            eventMakerModel = new EventMakerModel();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //tableName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        //tableLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        //tablePassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));


        //tableUsers.setItems(userModel.getUsersForCheck());

        tableUsers.setVisible(false);

        eventApproval.setCellValueFactory(new PropertyValueFactory<Event, Boolean>("Approved"));
        adminTableDate.setCellValueFactory(new PropertyValueFactory<Event, String>("date"));
        eventStart.setCellValueFactory(new PropertyValueFactory<Event, String>("eventStart"));
        eventEnd.setCellValueFactory(new PropertyValueFactory<Event, String>("eventEnd"));
        eventName.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        eventLocation.setCellValueFactory(new PropertyValueFactory<Event, String>("location"));

        try {
            tableEvents.setItems(eventMakerModel.getObservableEvents());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void handleAdmingPage(ActionEvent actionEvent) {
    }

    public void handleAddPlanner(ActionEvent actionEvent) {

            //opening up our creation window

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/CreatePlanner.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("EASV Events");
                stage.show();

                //setting controller and model for new window.

                BaseController controller = loader.getController();
                controller.setUserModel(userModel);


            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR, "");
                alert.showAndWait();
            }
    }


    public void handleDeleteUser(ActionEvent actionEvent) throws Exception {

        try
        {
        confirmationUserDeletion();
        }

        catch (Exception exc) {
        exc.printStackTrace();
        throw new Exception("Could not delete song", exc);
    }
    }

    public void handleCreateAEvent(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TicketSystem/GUI/View/EventMaker.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("EASV Events");
            stage.show();

            //setting controller and model for new window.

            BaseController controller = loader.getController();
            controller.setEventModel(eventMakerModel);


        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "");
            alert.showAndWait();
        }
    }



    public void handleDeleteAEvent(ActionEvent actionEvent) throws Exception {
        try
        {
            confirmationEventDeletion();
        }

        catch (Exception exc) {
            exc.printStackTrace();
            throw new Exception("Could not delete Event", exc);
        }
    }

    public void handleShowPlanners(ActionEvent actionEvent) {
    }

    public void handleShowAEvent(ActionEvent actionEvent) {
        try {

            Event selectedEvent = tableEvents.getSelectionModel().getSelectedItem();

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

    public void handleCancel(ActionEvent actionEvent) throws Exception {
        this.eventMakerModel = eventMakerModel;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("You are about to delete a Event");
        alert.setContentText("Are you sure you want to delete?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Event deletedEvent = tableEvents.getSelectionModel().getSelectedItem();
            eventMakerModel.deleteEvent(deletedEvent);
            getMissingApproval();
        }
    }

    public void handleApprove(ActionEvent actionEvent) throws Exception {

        Event event = tableEvents.getSelectionModel().getSelectedItem();

        Boolean approval = true;

        eventMakerModel.updateApproval(event, approval);
    }

    public void handleConfirm(ActionEvent actionEvent) throws Exception {
            tableUsers.setVisible(false);
            tableEvents.setVisible(true);
            getMissingApproval();
    }

    public void handleAllAEvents (ActionEvent actionEvent) throws Exception {
                tableUsers.setVisible(false);
                tableEvents.setVisible(true);
                setEventsForShow();

    }

    public void handleAllPlanners (ActionEvent actionEvent) throws Exception {
                tableUsers.setVisible(true);
                tableEvents.setVisible(false);
                getPlanners();
    }

    public void handleAllCustomers (ActionEvent actionEvent) throws Exception {
                tableUsers.setVisible(true);
                tableEvents.setVisible(false);
                getCustomers();
    }
    public void confirmationEventDeletion() throws Exception{
        this.eventMakerModel = eventMakerModel;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("You are about to delete a Event");
        alert.setContentText("Are you sure you want to delete?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Event deletedEvent = tableEvents.getSelectionModel().getSelectedItem();
            eventMakerModel.deleteEvent(deletedEvent);
            setEventsForShow();
        }
    }

    public void confirmationUserDeletion () throws Exception {

                //making an alert box to make sure you don't delete by mistake

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("You are about to delete a User");
                alert.setContentText("Are you sure you want to delete?");
                Optional<ButtonType> result = alert.showAndWait();


                //if you press ok we proceed with deletion.

                if (result.get() == ButtonType.OK) {
                    User deletedUser = tableUsers.getSelectionModel().getSelectedItem();

                    //simple way to update our table after deletion.
                    if (deletedUser.getIsSpecial() == 2) {
                        userModel.deleteUser(deletedUser);
                        getPlanners();
                    } else if (deletedUser.getIsSpecial() == 3) {
                        userModel.deleteUser(deletedUser);
                        getCustomers();
                    }

                } else {

                }
    }


    public void getCustomers () throws Exception {

                //getting newest list and filtering it for all customers.
                userModel.showList();

                ObservableList<User> customers = FXCollections.observableArrayList();
                for (User user : userModel.getUsersForCheck()) {
                    if (user.getIsSpecial() == 3) {
                        customers.add(user);
                    }
                }

                //clearing out and setting cell information
                tableUsers.getItems().clear();

                tableName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
                tableLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
                tablePassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));


                //adding all customers
                tableUsers.setItems(customers);
    }


    public void getPlanners() throws Exception {

        //getting the newest list with all users.
        userModel.showList();


        //filtering list to get all planners
        ObservableList<User> specialUsers = FXCollections.observableArrayList();
        for (User user : userModel.getUsersForCheck()) {
            if (user.getIsSpecial() == 2) {
                specialUsers.add(user);
            }
        }

        //clearing out the table
        tableUsers.getItems().clear();


        //adding value to our table cells.
        tableName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        tableLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        tablePassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));


        //adding the planners to our table.
        tableUsers.setItems(specialUsers);
    }

    public void getMissingApproval() throws Exception {

        //getting the newest list with all users.
        eventMakerModel.getObservableEvents();


        //filtering list to get all planners
        ObservableList<Event> missingApproval = FXCollections.observableArrayList();
        for (Event event : eventMakerModel.getObservableEvents()) {
            if (event.isApproved() == false) {
                missingApproval.add(event);
            }
        }

        //clearing out the table
        tableEvents.getItems().clear();

        eventApproval.setCellValueFactory(new PropertyValueFactory<Event, Boolean>("Approved"));
        adminTableDate.setCellValueFactory(new PropertyValueFactory<Event, String>("date"));
        eventStart.setCellValueFactory(new PropertyValueFactory<Event, String>("eventStart"));
        eventEnd.setCellValueFactory(new PropertyValueFactory<Event, String>("eventEnd"));
        eventName.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        eventLocation.setCellValueFactory(new PropertyValueFactory<Event, String>("location"));

        //adding the planners to our table.
        tableEvents.setItems(missingApproval);
    }

    public void setEventsForShow() throws Exception {

        //getting the newest list with all users.
        eventMakerModel.getObservableEvents();


        //clearing out the table
        tableEvents.getItems().clear();

        eventApproval.setCellValueFactory(new PropertyValueFactory<Event, Boolean>("Approved"));
        adminTableDate.setCellValueFactory(new PropertyValueFactory<Event, String>("date"));
        eventStart.setCellValueFactory(new PropertyValueFactory<Event, String>("eventStart"));
        eventEnd.setCellValueFactory(new PropertyValueFactory<Event, String>("eventEnd"));
        eventName.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        eventLocation.setCellValueFactory(new PropertyValueFactory<Event, String>("location"));

        //adding the planners to our table.
        tableEvents.setItems(eventMakerModel.getObservableEvents());
    }



}
