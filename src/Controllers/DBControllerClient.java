package Controllers;

import Variables.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBControllerClient {


    private static final String CONN = "jdbc:sqlite:HerbsAndClients.db";


    public static void saveDate(Client client) {

        String insertSQL = "INSERT INTO Client (Name, Surname, DateOfBirth, PhoneNumber, Mail, PreviousIllness, CurrentIllness) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getDateOfBirth().toString());
            preparedStatement.setInt(4, client.getPhoneNumber());
            preparedStatement.setString(5, client.getMail());
            preparedStatement.setString(6, client.getPreviousIllness());
            preparedStatement.setString(7, client.getCurrentIllness());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Client> readData() {
        List<Client> clients = new ArrayList<>();

        String selectSQL = "SELECT * FROM Client;";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                LocalDate dateOfBirth = LocalDate.parse(resultSet.getString("DateOfBirth"));
                Integer phoneNumber = resultSet.getInt("PhoneNumber");
                String mail = resultSet.getString("Mail");
                String previousIllness = resultSet.getString("PreviousIllness");
                String currentIllness = resultSet.getString("CurrentIllness");
                Client client = new Client(name, surname, dateOfBirth, phoneNumber, mail, previousIllness, currentIllness);
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return clients;
    }



    public static void deleteDate(Client client) {

        String deleteSQL = "DELETE FROM Client WHERE (Name, Surname) = (?, ?);";

        try {
            Connection connection = DriverManager.getConnection(CONN);
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
