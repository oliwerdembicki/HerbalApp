package Calculations;

import Variables.Client;
import Variables.General;
import Variables.Herb;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StatisticalCalc {


    public static String todaysBirthday(List<Client> clientList) {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        Month month = LocalDate.now().getMonth();

        String client = "";

        for (int i = 0; i < clientList.size(); i++) {
            if (month == clientList.get(i).getDateOfBirth().getMonth()
                    && dayOfMonth == clientList.get(i).getDateOfBirth().getDayOfMonth()) {
                client += clientList.get(i).getName() + " " + clientList.get(i).getSurname() + "\n";
            }
        }
        if (client.isEmpty()) {
            client = "None";
        }
        return client;
    }


    public static String whatToReplenish(List<Herb> herbsList) {
        String quantity = "";
        for (int i = 0; i < herbsList.size(); i++) {
            int grams = 100;
            if (herbsList.get(i).quantity < grams) {
                quantity += herbsList.get(i).getName() + "\n";
            }

        }

        return quantity;
    }






    public static String topPopular(List<Herb> herbsList, List<General> generalList){
        int[] integerList = new int[herbsList.size()];
        String[] herbsTable = new String[herbsList.size()];
        for (int i = 0; i < herbsList.size(); i++) {
            herbsTable[i] = herbsList.get(i).getName();
        }

        String topString = "";
        for (int i = 0; i < generalList.size(); i++) {
            for (int j = 0; j < herbsList.size(); j++) {
                if (generalList.get(i).getAssignedHerb().equals(herbsList.get(j).getName())) {
                    integerList[j]++;
                }
            }
        }

        SelectionSort.sortNumbers(integerList, herbsTable);

        for (int i = herbsTable.length-1; i > herbsTable.length-4; i--) {
            topString = topString + herbsTable[i] + "\n";



        }

        return topString;
    }
}




