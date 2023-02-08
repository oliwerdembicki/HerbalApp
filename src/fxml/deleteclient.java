package fxml;

import Controllers.DBControllerClient;
import Main.Main;
import Variables.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.ComboBox;


public class deleteclient {

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
        clientsDeleteClientsComboBox.getItems().addAll(Main.clients);
    }


        @FXML
        private ComboBox<Client> clientsDeleteClientsComboBox;

        @FXML
        void clientsDeleteClientsButton(ActionEvent event) {

            try {

                if (clientsDeleteClientsComboBox.getItems() != null) {
                    Client selectedClient = clientsDeleteClientsComboBox.getSelectionModel().getSelectedItem();
                    DBControllerClient.deleteDate(selectedClient);
                    Main.clients.remove(selectedClient);
                    clientsDeleteClientsComboBox.getItems().clear();
                    clientsDeleteClientsComboBox.getItems().addAll(Main.clients);
                    root = FXMLLoader.load(getClass().getResource("clientDB.fxml"));
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


