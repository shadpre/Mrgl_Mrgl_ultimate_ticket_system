package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Model.AppModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

private AppModel model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new AppModel();
    }

    public void setModel(AppModel model){
        this.model = model;

    }
}
