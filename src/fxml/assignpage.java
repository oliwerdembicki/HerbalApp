package fxml;

import Controllers.DBControllerGeneral;
import Main.Main;
import Variables.Client;
import Variables.General;
import Variables.Herb;
import Variables.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;


public class assignpage {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

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

    String nameAndSurname;
    String contact;
    String assignedHerb;
    String assignedRecipe;
    String Illnesses;

    @FXML
    public ComboBox<Client> generalSelectComboBoxClient;

    @FXML
    public ComboBox<Herb> generalSelectComboBoxHerb;

    @FXML
    public Label exceptionLabel;

    @FXML
    public ComboBox<Recipe> generalSelectComboBoxRecipe;

    public void initialize(){
        generalSelectComboBoxClient.getItems().addAll(Main.clients);
        generalSelectComboBoxHerb.getItems().addAll(Main.herbs);
        generalSelectComboBoxRecipe.getItems().addAll(Main.recipes);
    }

    public String getContactMethod() {
        for (int i = 0; i < Main.clients.size(); i++) {
            contact += Main.clients.get(i).getPhoneNumber() + " " + Main.clients.get(i).getMail();

        }
        return contact;
    }

    public String getNameAndSurnameMethod() {
        for (int i = 0; i < Main.clients.size(); i++) {
            nameAndSurname += Main.clients.get(i).getName() + " " + Main.clients.get(i).getSurname();
        }

        return nameAndSurname;
    }


    @FXML
    void generalAssignButton(ActionEvent event) {

        try {

            if (generalSelectComboBoxClient.getItems() != null) {
                nameAndSurname = General.parseIntoStringClient(generalSelectComboBoxClient.getSelectionModel().getSelectedItem());
                contact = General.parseIntoStringContact(generalSelectComboBoxClient.getSelectionModel().getSelectedItem());
                Illnesses = General.parseIntoStringIllnesses(generalSelectComboBoxClient.getSelectionModel().getSelectedItem());
            } else if (generalSelectComboBoxClient.getItems() == null) {
                exceptionLabel.setText("Please choose a client!");
            }

            if (generalSelectComboBoxRecipe.getSelectionModel().getSelectedItem() != null) {
                assignedRecipe = generalSelectComboBoxRecipe.getSelectionModel().getSelectedItem().getName();
            }

            if (generalSelectComboBoxHerb.getItems() != null) {
                assignedHerb = generalSelectComboBoxHerb.getSelectionModel().getSelectedItem().getName();

            }else if (generalSelectComboBoxHerb == null){
                exceptionLabel.setText("Error, please select an herb!");

            }
                General general = new General(nameAndSurname, contact, assignedHerb, assignedRecipe, Illnesses);
                DBControllerGeneral.saveDate(general);
                Main.generals.add(general);
                root = FXMLLoader.load(getClass().getResource("generalDB.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


            } catch(Exception e){
                e.printStackTrace();
                exceptionLabel.setText("select the client and herb");
            }


        }


    }












