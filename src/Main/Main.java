package Main;

import Controllers.DBControllerClient;
import Controllers.DBControllerGeneral;
import Controllers.DBControllerHerb;
import Controllers.DBControllerRecipe;
import Variables.Client;
import Variables.General;
import Variables.Herb;
import Variables.Recipe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.List;

public class Main extends Application {

    public static List<Client> clients = DBControllerClient.readData();
    public static List<Herb> herbs = DBControllerHerb.readData();
    public static List<Recipe> recipes = DBControllerRecipe.readData();
    public static List<General> generals = DBControllerGeneral.readData();

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(clients);
        System.out.println(herbs);
        System.out.println(recipes);
        launch(args);
    }
}
