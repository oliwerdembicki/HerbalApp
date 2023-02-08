package Controllers;

import Variables.Herb;
import Variables.Recipe;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBControllerRecipe {

    private static final String CONN = "jdbc:sqlite:HerbsAndClients.db";


    public static void saveDate(Recipe recipe) {

        String insertSQL = "INSERT INTO Recipe (Name, Composition, DateDue, Properties, Limitations, Restrictions) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, Recipe.getName());
            preparedStatement.setString(2, Recipe.parseIntoString(recipe.getComposition()));
            preparedStatement.setString(3, Recipe.getDateDue().toString());
            preparedStatement.setString(4, Recipe.getProperties());
            preparedStatement.setString(5, Recipe.getLimitations());
            preparedStatement.setString(6, Recipe.getRestrictions());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Recipe> readData() {
        List<Recipe> recipes = new ArrayList<>();

        String selectSQL = "SELECT * FROM Recipe;";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                List<Herb> composition = Recipe.parseIntoList(resultSet.getString("Composition"));
                LocalDate dateDue = LocalDate.parse(resultSet.getString("DateDue"));
                String properties = resultSet.getString("Properties");
                String limitations = resultSet.getString("Limitations");
                String restrictions = resultSet.getString("Restrictions");
                Recipe recipe = new Recipe(name, composition, dateDue, properties, limitations, restrictions);
                recipes.add(recipe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return recipes;
    }


    public static void deleteDate(Recipe recipe) {

        String deleteSQL = "DELETE FROM Recipe WHERE Name = ?;";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, recipe.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


