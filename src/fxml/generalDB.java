package fxml;


import Controllers.DBControllerGeneral;
import Variables.General;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.List;
import javafx.scene.control.TableColumn;


public class generalDB {

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
        public TableView<General> tableviewGeneral;

        @FXML
        private TableColumn<General, String> toNameAndSurname;

        @FXML
        private TableColumn<General, String> toContact;

        @FXML
        private TableColumn<General, String> toAssignedHerb;

        @FXML
        private TableColumn<General, String> toAssignedRecipe;

        @FXML
        private TableColumn<General, String> toAssignedIllnesses;


        @FXML
        void generalAssignDeleteButton(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("deletegeneral.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }

    public void initialize() {
        List<General> generals = DBControllerGeneral.readData();
        toNameAndSurname.setCellValueFactory(new PropertyValueFactory<General, String>("NameAndSurname"));
        toContact.setCellValueFactory(new PropertyValueFactory<General, String>("Contact"));
        toAssignedHerb.setCellValueFactory(new PropertyValueFactory<General, String>("AssignedHerb"));
        toAssignedRecipe.setCellValueFactory(new PropertyValueFactory<General, String>("AssignedRecipe"));
        toAssignedIllnesses.setCellValueFactory(new PropertyValueFactory<General, String>("Illnesses"));
        TableView.TableViewSelectionModel<General> selectionModel = tableviewGeneral.getSelectionModel();
        tableviewGeneral.getItems().clear();
        tableviewGeneral.getItems().addAll(generals);


    }

}





