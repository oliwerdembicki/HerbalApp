package fxml;

import Controllers.DBControllerRecipe;
import Main.Main;
import Variables.Herb;
import Variables.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;

public class addrecipes  {


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

    String name;
    LocalDate dateDue;
    String properties;
    String limitations;
    String restrictions;
    List<Herb> herbsComboBoxList = new ArrayList<>();

    @FXML
    private TextField recipeNameTextField;

    @FXML
    private DatePicker recipeDateDueDatePicker;

    @FXML
    private TextField recipePropertiesTextField;

    @FXML
    private TextField recipeLimitationsTextField;

    @FXML
    private TextField recipeRestrictionsTextField;

    @FXML
    private Label exceptionLabel;

    @FXML
    public ComboBox<Herb> recipeSelectComboBox1;

    @FXML
    public ComboBox<Herb> recipeSelectComboBox2;

    @FXML
    public ComboBox<Herb> recipeSelectComboBox3;

    @FXML
    public ComboBox<Herb> recipeSelectComboBox4;


    public void initialize(){
        recipeSelectComboBox1.getItems().addAll(Main.herbs);
        recipeSelectComboBox2.getItems().addAll(Main.herbs);
        recipeSelectComboBox3.getItems().addAll(Main.herbs);
        recipeSelectComboBox4.getItems().addAll(Main.herbs);
    }

    @FXML
    void addRecipeButton(ActionEvent event) {
        try {
            if (recipeSelectComboBox1.getSelectionModel().getSelectedItem() != null) {
                herbsComboBoxList.add(recipeSelectComboBox1.getSelectionModel().getSelectedItem());
            }
            if (recipeSelectComboBox2.getSelectionModel().getSelectedItem() != null) {
                herbsComboBoxList.add(recipeSelectComboBox2.getSelectionModel().getSelectedItem());
            }
            if (recipeSelectComboBox3.getSelectionModel().getSelectedItem() != null) {
                herbsComboBoxList.add(recipeSelectComboBox3.getSelectionModel().getSelectedItem());
            }
            if (recipeSelectComboBox4.getSelectionModel().getSelectedItem() != null) {
                herbsComboBoxList.add(recipeSelectComboBox4.getSelectionModel().getSelectedItem());
            }

            name = recipeNameTextField.getText();
            dateDue = recipeDateDueDatePicker.getValue();
            properties = recipePropertiesTextField.getText();
            limitations = recipeLimitationsTextField.getText();
            restrictions = recipeRestrictionsTextField.getText();
            Recipe recipe = new Recipe(name, herbsComboBoxList, dateDue, properties, limitations, restrictions);
            DBControllerRecipe.saveDate(recipe);
            Main.recipes.add(recipe);
            root = FXMLLoader.load(getClass().getResource("recipesDB.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            exceptionLabel.setText("Error");
            e.printStackTrace();
        }


    }

}








