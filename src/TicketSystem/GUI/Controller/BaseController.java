package TicketSystem.GUI.Controller;

import TicketSystem.GUI.Model.AppModel;
import TicketSystem.GUI.Model.EventMakerModel;
import TicketSystem.GUI.Model.UserModel;

public abstract class BaseController {
private AppModel model;
private UserModel userModel;



private EventMakerModel eventMakerModel;

    public void setModel(AppModel appModel){
        this.model = model;
    }

    public void setUserModel(UserModel userModel){this.userModel = userModel;}

    public EventMakerModel getModel(){return eventMakerModel;}

    public void setEventModel(EventMakerModel eventMakerModel){this.eventMakerModel = eventMakerModel;}
}
