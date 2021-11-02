import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("OOP_SEM1_GROUP_PROJECT");

        Parent homeRoot = FXMLLoader.load(getClass().getResource("resources/home.fxml"));
        Scene home = new Scene(homeRoot);

        primaryStage.setScene(home);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
