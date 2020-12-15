package AdventOfCode.Day_2;

import java.util.ArrayList;

public class ListConverter {
    protected static void convertList(ArrayList<String> list) {
        String[] tempArray = null;
        int first_index = 0;
        int second_index = 0;
        String letter = "";
        String password = "";
        int quantity_of_valid_passwords = 0;

        for (String s : list) {
            tempArray = s.replace(":", "").replace("-", " ").split(" ");
            first_index = Integer.parseInt(tempArray[0]);
            second_index = Integer.parseInt(tempArray[1]);
            letter = tempArray[2];
            password = tempArray[3];

            if (checkIsCorrect(first_index, second_index, letter, password)) {
                quantity_of_valid_passwords++;
            }
        }
        System.out.println("Quantity of valid password is: " + quantity_of_valid_passwords);
    }

    private static boolean checkIsCorrect(int firstIndex, int secondIndex, String letter, String password) {
        String firstLetter = String.valueOf(password.charAt(firstIndex - 1));
        String secondLetter = String.valueOf(password.charAt(secondIndex - 1));

        if (firstLetter.equals(letter) & !secondLetter.equals(letter)) {
            return true;
        } else return (!firstLetter.equals(letter) & secondLetter.equals(letter));
    }
}
