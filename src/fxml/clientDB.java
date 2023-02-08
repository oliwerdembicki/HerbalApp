package fxml;

import Controllers.DBControllerClient;
import Variables.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class clientDB {

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

        @FXML
        private TableView<Client> tableviewClient;

        @FXML
        private TableColumn<Client, String> toName;

        @FXML
        private TableColumn<Client, String> toSurname;

        @FXML
        private TableColumn<Client, LocalDate> toDateOfBirth;

        @FXML
        private TableColumn<Client, Integer> toPhoneNumber;

        @FXML
        private TableColumn<Client, String> toMail;

        @FXML
        private TableColumn<Client, String> toPreviousIllnesses;

        @FXML
        private TableColumn<Client, String> toCurrentIllnesses;

        @FXML
        void clientsAddNewClientButton(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("addclients.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void clientsDeleteClientsButton(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("deleteclient.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    public void initialize() {
        List<Client> clients = DBControllerClient.readData();
        toName.setCellValueFactory(new PropertyValueFactory<Client, String>("Name"));
        toSurname.setCellValueFactory(new PropertyValueFactory<Client, String>("Surname"));
        toDateOfBirth.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("DateOfBirth"));
        toPhoneNumber.setCellValueFactory(new PropertyValueFactory<Client, Integer>("PhoneNumber"));
        toMail.setCellValueFactory(new PropertyValueFactory<Client, String>("Mail"));
        toPreviousIllnesses.setCellValueFactory(new PropertyValueFactory<Client, String>("PreviousIllness"));
        toCurrentIllnesses.setCellValueFactory(new PropertyValueFactory<Client, String>("CurrentIllness"));

        TableView.TableViewSelectionModel<Client> selectionModel = tableviewClient.getSelectionModel();
        tableviewClient.getItems().addAll(clients);

    }



}





