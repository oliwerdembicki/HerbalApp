package Controllers;

import Variables.Herb;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBControllerHerb {

    private static final String CONN = "jdbc:sqlite:HerbsAndClients.db";


    public static void saveDate(Herb herb) {

        String insertSQL = "INSERT INTO Herb (Name, Quantity, DateOfPurchase, Properties, Limitations, Restrictions) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, herb.getName());
            preparedStatement.setInt(2, herb.getQuantity());
            preparedStatement.setString(3, herb.getDateOfPurchase().toString());
            preparedStatement.setString(4, herb.getProperties());
            preparedStatement.setString(5, herb.getLimitations());
            preparedStatement.setString(6, herb.getRestrictions());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Herb> readData() {
        List<Herb> herbs = new ArrayList<>();

        String selectSQL = "SELECT * FROM Herb;";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                Integer quantity = resultSet.getInt("Quantity");
                LocalDate dateOfPurchase = LocalDate.parse(resultSet.getString("DateOfPurchase"));
                String properties = resultSet.getString("Properties");
                String limitations = resultSet.getString("Limitations");
                String restrictions = resultSet.getString("Restrictions");
                Herb herb = new Herb(name, quantity, dateOfPurchase, properties, limitations, restrictions);
                herbs.add(herb);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return herbs;
    }

    public static void deleteDate(Herb herb) {

        String deleteSQL = "DELETE FROM Herb WHERE Name = ?;";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, herb.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}


