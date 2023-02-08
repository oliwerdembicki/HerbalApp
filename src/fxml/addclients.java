package fxml;

import Controllers.DBControllerClient;
import Main.Main;
import Variables.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.TextField;


public class addclients {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label exceptionLabel;

    @FXML
    public void switchToClients(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("clientDB.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToHerbs(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("herbsDB.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToRecipes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("recipesDB.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToDatabase(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("generalDB.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToStatistics(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToAssign(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("assignpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    String name;
    String surname;
    Integer phoneNumber;
    LocalDate dateOfBirth;
    String mail;
    String previousIllness;
    String currentIllness;


    @FXML
    private TextField clientNameTextField;

    @FXML
    private TextField clientSurnameTextField;

    @FXML
    private TextField clientPhoneTextField;

    @FXML
    private DatePicker clientDateDatePicker;

    @FXML
    private TextField clientMailTextField;

    @FXML
    private TextField clientPreIllnessTextField;

    @FXML
    private TextField clientCurIllnessTextField;

    @FXML
    void addClientButton(ActionEvent event) {


        try {
            name = clientNameTextField.getText();
            surname = clientSurnameTextField.getText();
            phoneNumber = Integer.parseInt(clientPhoneTextField.getText());
            dateOfBirth = clientDateDatePicker.getValue();
            mail = clientMailTextField.getText();
            previousIllness = clientPreIllnessTextField.getText();
            currentIllness = clientCurIllnessTextField.getText();
            Client client = new Client(name, surname, dateOfBirth, phoneNumber, mail, previousIllness, currentIllness);
            DBControllerClient.saveDate(client);
            Main.clients.add(client);
            root = FXMLLoader.load(getClass().getResource("clientDB.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        } catch (NumberFormatException e) {
            exceptionLabel.setAlignment(Pos.CENTER_RIGHT);
            exceptionLabel.setText("Enter only numbers into phone!");

        } catch (Exception e) {
            exceptionLabel.setText("Error");
        }


    }
}