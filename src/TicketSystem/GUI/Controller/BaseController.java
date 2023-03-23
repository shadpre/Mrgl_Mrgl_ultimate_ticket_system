package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Model.AppModel;

public abstract class BaseController {
private AppModel model;

    public void setModel(AppModel model){
        this.model = model;
    }
}
