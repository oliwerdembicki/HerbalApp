package fxml;

import Controllers.DBControllerHerb;
import Variables.Herb;
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


public class herbsDB {

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
        private TableView<Herb> tableviewHerbs;

        @FXML
        private TableColumn<Herb, String> toName;

        @FXML
        private TableColumn<Herb, Integer> toQuantity;

        @FXML
        private TableColumn<Herb, LocalDate> toDateOfPurchase;

        @FXML
        private TableColumn<Herb, String> toProperties;

        @FXML
        private TableColumn<Herb, String> toLimitations;

        @FXML
        private TableColumn<Herb, String> toRestrictions;

        @FXML
        void herbsAddNewHerbButton(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("addherbs.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        @FXML
        void herbsDeleteHerbButton(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("deleteherb.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }


    public void initialize() {
        List<Herb> herbs = DBControllerHerb.readData();
        toName.setCellValueFactory(new PropertyValueFactory<Herb, String>("Name"));
        toQuantity.setCellValueFactory(new PropertyValueFactory<Herb, Integer>("Quantity"));
        toDateOfPurchase.setCellValueFactory(new PropertyValueFactory<Herb, LocalDate>("DateOfPurchase"));
        toProperties.setCellValueFactory(new PropertyValueFactory<Herb, String>("Properties"));
        toLimitations.setCellValueFactory(new PropertyValueFactory<Herb, String>("Limitations"));
        toRestrictions.setCellValueFactory(new PropertyValueFactory<Herb, String>("Restrictions"));


        TableView.TableViewSelectionModel<Herb> selectionModel = tableviewHerbs.getSelectionModel();
        tableviewHerbs.getItems().addAll(herbs);

    }




}






