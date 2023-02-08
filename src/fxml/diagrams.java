package fxml;

import Controllers.DBHandler;
import Main.Main;
import Variables.Herb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class diagrams {
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


    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    public LineChart<?, ?> lineChart;

    @FXML
    public CategoryAxis xLine;

    @FXML
    public NumberAxis yLine;

    @FXML
    public CategoryAxis xBar;

    @FXML
    public NumberAxis yBar;


    public void ageOfClients (){
        XYChart.Series series1 = new XYChart.Series<>();
        XYChart.Series series2 = new XYChart.Series<>();
        XYChart.Series series3 = new XYChart.Series<>();
        XYChart.Series series4 = new XYChart.Series<>();
        xBar.setLabel("Clients");
        yBar.setLabel("Age");
        series1.setName("<26");
        series2.setName("<51");
        series3.setName("<76");
        series4.setName("<101");
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        int count1 = 25;
        int count2 = 50;
        int count3 = 75;
        int count4 = 100;
        List<Integer> ageListing = DBHandler.readDataClient();
        for (int i = 0; i < ageListing.size(); i++) {
            if (ageListing.get(i) > 0  && ageListing.get(i) <= count1){
                sum1++;
            }
            if (ageListing.get(i) > count1  && ageListing.get(i) <= count2){
                sum2++;
            }
            if (ageListing.get(i) > count2  && ageListing.get(i) <= count3){
                sum3++;
            }
            if (ageListing.get(i) > count3  && ageListing.get(i) <= count4){
                sum4++;
            }
            series1.getData().add(new XYChart.Data("younger than 25", sum1));
            series2.getData().add(new XYChart.Data("25-50 years old", sum2));
            series3.getData().add(new XYChart.Data("51-75 years old", sum3));
            series4.getData().add(new XYChart.Data("76-100 years old", sum4));
        }

        barChart.getData().add(series1);
        barChart.getData().add(series2);
        barChart.getData().add(series3);
        barChart.getData().add(series4);
    }


    public XYChart.Series quantityOfHerbs (List<Herb> herbsList){
        XYChart.Series series1 = new XYChart.Series<>();
        List<Integer> dataHolder = DBHandler.readDataHerb();
        xLine.setLabel("Herbs");
        yLine.setLabel("Quantity");
        series1.setName("Quantity of Herbs");
        for (int i = 0; i < dataHolder.size(); ++i) {
            series1.getData().add(new XYChart.Data(herbsList.get(i).getName(), dataHolder.get(i)));

        }
        return series1;
    }


    public void initialize(){
     lineChart.getData().addAll(quantityOfHerbs(Main.herbs));
     ageOfClients();
    }
}
