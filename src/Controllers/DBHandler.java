package Controllers;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private static final String CONN = "jdbc:sqlite:HerbsAndClients.db";

    public static List<Integer> readDataClient() {
        String selectSQL = "SELECT * FROM Client;";
        List<Integer> ageList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        int numberOfYears;

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("DateOfBirth"));
                numberOfYears = today.getYear() - dateOfBirth.getYear();
                ageList.add(numberOfYears);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return ageList;
    }




    public static List<Integer> readDataHerb() {
        List<Integer> quantityList = new ArrayList<>();

        String selectSQL = "SELECT * FROM Herb;";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer quantity = resultSet.getInt("Quantity");
                quantityList.add(quantity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return quantityList;
    }



}

