package fxml;

import Controllers.DBControllerRecipe;
import Variables.Herb;
import Variables.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class recipesDB {

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
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        @FXML
        private TableView<Recipe> tableviewRecipes;

        @FXML
        private TableColumn<Recipe, String> toName;

        @FXML
        private TableColumn<Recipe, List<Herb>> toComposition;

        @FXML
        private TableColumn<Recipe, LocalDate> toDateDue;

        @FXML
        private TableColumn<Recipe, String> toProperties;

        @FXML
        private TableColumn<Recipe, String> toLimitations;

        @FXML
        private TableColumn<Recipe, String> toRestrictions;

        @FXML
        void recipeAddNewRecipeButton(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("addrecipes.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        void recipeDeleteRecipeButton(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("deleterecipe.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    public void initialize() {
        List<Recipe> recipes = DBControllerRecipe.readData();
        toName.setCellValueFactory(new PropertyValueFactory<Recipe, String>("Name"));
        toComposition.setCellValueFactory(new PropertyValueFactory<Recipe, List<Herb>>("Composition"));
        toDateDue.setCellValueFactory(new PropertyValueFactory<Recipe, LocalDate>("DateDue"));
        toProperties.setCellValueFactory(new PropertyValueFactory<Recipe, String>("Properties"));
        toLimitations.setCellValueFactory(new PropertyValueFactory<Recipe, String>("Limitations"));
        toRestrictions.setCellValueFactory(new PropertyValueFactory<Recipe, String>("Restrictions"));
        TableView.TableViewSelectionModel<Recipe> selectionModel = tableviewRecipes.getSelectionModel();
        tableviewRecipes.getItems().addAll(recipes);;


    }



}



