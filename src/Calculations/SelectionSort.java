package Calculations;

public class SelectionSort {

    public static void sortNumbers(int[] integerList, String[] herbsTable) {

        for (int i = 0; i < integerList.length; i++) {
            int minimum = i;
            for (int number = minimum + 1; number < integerList.length; number++) {
                if (integerList[number] < integerList[minimum]) {
                    minimum = number;
                }
            }

            int temporary = integerList[i];
            integerList[i] = integerList[minimum];
            integerList[minimum] = temporary;

            String temporaryString = herbsTable[i];
            herbsTable[i] = herbsTable[minimum];
            herbsTable[minimum] = temporaryString;

        }
    }

}
