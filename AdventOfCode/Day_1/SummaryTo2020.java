package AdventOfCode.Day_1;

import AdventOfCode.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class SummaryTo2020 extends ReadFile {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> listOfNumbers;

        listOfNumbers = getDataOfFile("AdventOfCode/Day_1/puzzleInput");

        printMultiplicationOfNumbers(listOfNumbers);
    }


    private static void printMultiplicationOfNumbers( ArrayList<String> listOfNumbers) {
        ArrayList<Integer> multiplicationList = new ArrayList<>();

        multiplicationList.add(findNumbers(listOfNumbers));

        System.out.println(multiplicationList);

    }

    private static Integer findNumbers( ArrayList<String> listOfNumbers) {
        for(String var1: listOfNumbers){
            for(String var2: listOfNumbers){
                for(String var3: listOfNumbers){
                    if (Integer.parseInt(var1) + Integer.parseInt(var2) + Integer.parseInt(var3) == 2020){
                        return Integer.parseInt(var1) * Integer.parseInt(var2) * Integer.parseInt(var3);
                    }
                }
            }
        }
        return null;
    }



}