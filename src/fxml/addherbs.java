package fxml;

import Controllers.DBControllerHerb;
import Main.Main;
import Variables.Herb;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class addherbs {

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

    String name;
    Integer quantity;
    LocalDate dateOfPurchase;
    String properties;
    String limitations;
    String restrictions;

        @FXML
        private TextField herbNameTextField;

        @FXML
        private TextField herbQuantityTextField;

        @FXML
        private DatePicker herbDateOfPurchaseDatePicker;

        @FXML
        private TextField herbPropertiesTextField;

        @FXML
        private TextField herbLimitationsTextField;

        @FXML
        private TextField herbRestrictionsTextField;

        @FXML
        private Label exceptionLabel;

        @FXML
        void addHerbsButton(ActionEvent event) {
            try {
                name = herbNameTextField.getText();
                quantity = Integer.parseInt(herbQuantityTextField.getText());
                dateOfPurchase = herbDateOfPurchaseDatePicker.getValue();
                properties = herbPropertiesTextField.getText();
                limitations = herbLimitationsTextField.getText();
                restrictions = herbRestrictionsTextField.getText();
                Herb herb = new Herb(name, quantity, dateOfPurchase, properties, limitations, restrictions);
                DBControllerHerb.saveDate(herb);
                Main.herbs.add(herb);
                root = FXMLLoader.load(getClass().getResource("herbsDB.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            catch (NumberFormatException e){
                exceptionLabel.setText("Enter only numbers into quantity!");
            }

            catch (Exception e) {
                exceptionLabel.setText("Error");
            }


        }


}








