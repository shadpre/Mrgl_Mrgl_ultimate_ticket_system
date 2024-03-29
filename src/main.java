import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    public static void main(String[] args){ launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("TicketSystem/GUI/View/EventMaker.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("TicketSystem/GUI/View/LoginView.fxml"));
        primaryStage.setTitle("Event Planner");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

}