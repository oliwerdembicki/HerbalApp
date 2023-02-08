package fxml;

import Controllers.DBControllerGeneral;
import Main.Main;
import Variables.General;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class deletegeneral {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToClients (ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("clientDB.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void switchToMain (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToHerbs (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("herbsDB.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToRecipes (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("recipesDB.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToDatabase (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("generalDB.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToStatistics (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToAssign (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("assignpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void initialize () {
        generalDeleteComboBox.getItems().addAll(Main.generals);


    }

    @FXML
    private ComboBox<General> generalDeleteComboBox;


    public void generalDeleteButton(ActionEvent event) throws IOException {
        try {

            if (generalDeleteComboBox.getItems() != null) {
                General selectedGeneral = generalDeleteComboBox.getSelectionModel().getSelectedItem();
                DBControllerGeneral.deleteDate(selectedGeneral);
                Main.generals.remove(selectedGeneral);
                generalDeleteComboBox.getItems().clear();
                generalDeleteComboBox.getItems().addAll(Main.generals);
                root = FXMLLoader.load(getClass().getResource("generalDB.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
