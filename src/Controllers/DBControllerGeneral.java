package Controllers;

import Variables.General;
import Variables.Herb;
import Variables.Recipe;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBControllerGeneral {

    private static final String CONN = "jdbc:sqlite:HerbsAndClients.db";


        public static void saveDate(General general) {

            String insertSQL = "INSERT INTO General (NameAndSurname, Contact, AssignedHerb, AssignedRecipe, Illnesses) VALUES (?, ?, ?, ?, ?);";

            try {
                Connection connection = DriverManager.getConnection(CONN);
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setString(1, general.getNameAndSurname());
                preparedStatement.setString(2, general.getContact());
                preparedStatement.setString(3, general.getAssignedHerb());
                preparedStatement.setString(4, general.getAssignedRecipe());
                preparedStatement.setString(5, general.getIllnesses());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public static List<General> readData() {
            List<General> generals = new ArrayList<>();

            String selectSQL = "SELECT * FROM General;";

            try {
                Connection connection = DriverManager.getConnection(CONN);
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String nameAndSurname = resultSet.getString("NameAndSurname");
                    String contact = resultSet.getString("Contact");
                    String assignedHerb = resultSet.getString("AssignedHerb");
                    String assignedRecipe = resultSet.getString("AssignedRecipe");
                    String illnesses = resultSet.getString("Illnesses");

                    General general = new General(nameAndSurname, contact, assignedHerb, assignedRecipe, illnesses);
                    generals.add(general);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return generals;
        }

    public static void deleteDate(General general) {

        String deleteSQL = "DELETE FROM General WHERE NameAndSurname = ?;";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, general.getNameAndSurname());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
