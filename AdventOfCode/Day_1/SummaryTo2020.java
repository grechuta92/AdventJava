package AdventOfCode.Day_1;

import AdventOfCode.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class SummaryTo2020 extends ReadFile {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> listOfNumbers;

        listOfNumbers = getDataOfFile("AdventOfCode/Day_1/puzzleInput");

        printMultiplicationOfNumbers(listOfNumbers);
    }


    private static void printMultiplicationOfNumbers(final ArrayList<Integer> listOfNumbers) {
        ArrayList<Integer> multiplicationList = new ArrayList<>();

        multiplicationList.add(findNumbers(listOfNumbers));

        System.out.println(multiplicationList);

    }

    private static Integer findNumbers(final ArrayList<Integer> listOfNumbers) {
        for(Integer var1: listOfNumbers){
            for(Integer var2: listOfNumbers){
                for(Integer var3: listOfNumbers){
                    if (var1 + var2 + var3 == 2020){
                        return var1 * var2 * var3;
                    }
                }
            }
        }
        return null;
    }



}