package AdventOfCode.Day_6;

import AdventOfCode.ReadFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main extends ReadFile {

    public static void main(String[] args) {
        ArrayList<String> listOfVariables = ReadFile.getDataOfFile("Day_6/SampleAnswers.txt");

        List<String> listWithoutDuplicates = groupAnswers(listOfVariables);

    }


    private static ArrayList<String> groupAnswers(List<String> groupsAnswers) {
        String[] tempLetters = null;
        String tempWord = "";
        HashSet<String> listOfLetters = new HashSet<>();
        for (String var : groupsAnswers) {
            tempLetters = var.split("");
            if (!var.equals("")) {
                tempWord += var;
                for (int i = 0; i < tempLetters.length; i++) {
                    System.out.println("Temp: " +tempLetters[i]);
                    if (!tempWord.contains(var)) {
                        System.out.println("Temp 2: " +tempLetters[i]);

                        tempWord += tempLetters[i];
                    }
                }
            } else {
                tempWord = "";
            }
            System.out.println(tempWord);
        }

        return null;

    }
}

