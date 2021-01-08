package AdventOfCode.Day_9;

import AdventOfCode.ReadFile;

import java.util.ArrayList;

public class InvalidAnswerFinder extends ReadFile {
    private static final int preambleLength = 25;

    public static void main(String[] args) {
        ArrayList<String> listOfValues = getDataOfFile("/Day_9/Numbers.txt");
        ArrayList<Long> listOfNumbers = new ArrayList<>();

        listOfValues.forEach(a -> listOfNumbers.add(Long.parseLong(a)));

        findNotUsedNumber(listOfNumbers);
    }

    private static void findNotUsedNumber(final ArrayList<Long> listOfValues) {
        ArrayList<Long> correctAnswers = new ArrayList<>();


        for (int i = 0; i < listOfValues.size() - preambleLength; i++) {
            for (int j = i; j < i + preambleLength; j++) {
                for (int k = j + 1; k < i + preambleLength; k++) {
                    long var1 = listOfValues.get(j);
                    long var2 = listOfValues.get(k);
                    long sum = listOfValues.get(i + preambleLength);
                    if(sum == var1 + var2){
                        correctAnswers.add(sum);
                        break;
                    }
                }
            }
        }

        System.out.println("Values of numbers which are not valid:");
        System.out.println(getAllWrongAnswers(correctAnswers, listOfValues));
    }

    private static ArrayList<Long> getAllWrongAnswers(ArrayList<Long> correctAnswers, ArrayList<Long> allNumbers){
        ArrayList<Long> wrongAnswers = new ArrayList<>(allNumbers);
        ArrayList<Long> firstPreambleLengthNumbers = new ArrayList<>();

        for (int i = 0; i < preambleLength; i++) {
            firstPreambleLengthNumbers.add(allNumbers.get(i));
        }


        // Remove first "preambleLength" numbers and get sums numbers which are not valid
        wrongAnswers.removeAll(correctAnswers);
        wrongAnswers.removeAll(firstPreambleLengthNumbers);

        return wrongAnswers;
    }


}




