package TicketSystem.GUI.Controller;

import TicketSystem.BE.User;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    private UserModel userModel;

    private ObservableList<User> getUsersForCheck;

    @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User, String> tableName;
    @FXML
    private TableColumn<User, String> tableLogin;
    @FXML
    private TableColumn<User, String> tablePassword;

    public AdminController() {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            userModel = new UserModel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        tableName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        tableLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        tablePassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));


        tableUsers.setItems(userModel.getUsersForCheck());

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
    }

    public void handleUpdateAEvent(ActionEvent actionEvent) {
    }

    public void handleDeleteAEvent(ActionEvent actionEvent) {
    }

    public void handleShowPlanners(ActionEvent actionEvent) {
    }

    public void handleShowAEvent(ActionEvent actionEvent) {
    }

    public void handleCancel(ActionEvent actionEvent) {
    }

    public void handleApprove(ActionEvent actionEvent) {
    }

    public void handleConfirm(ActionEvent actionEvent) {
    }

    public void handleAllAEvents(ActionEvent actionEvent) {
    }

    public void handleAllPlanners(ActionEvent actionEvent) throws Exception {
       getPlanners();
    }

    public void handleAllCustomers(ActionEvent actionEvent) throws Exception {

        getCustomers();
    }


    public void confirmationUserDeletion() throws Exception {

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
            if (deletedUser.getIsSpecial() == 2){
                userModel.deleteUser(deletedUser);
                getPlanners();
            }

            else if(deletedUser.getIsSpecial() == 3){
                userModel.deleteUser(deletedUser);
                getCustomers();
            }

        } else {

        }
    }


    public void getCustomers() throws Exception {

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


}
