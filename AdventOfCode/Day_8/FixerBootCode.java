package AdventOfCode.Day_8;

import AdventOfCode.ReadFile;

import java.util.ArrayList;

public class FixerBootCode extends ReadFile {
    public static void main(String[] args) {
        startProgram();

    }

    public static void startProgram() {
        ArrayList<String> dataOfFile = getDataOfFile("/Day_8/BootCode.txt");
        ArrayList<Integer> usedIndexes = new ArrayList<>();
        String operation = "";
        int accumulatorValue = 0;
        int counter = 0;
        int numberValue = 0;
        int i = 0;

        while (i < dataOfFile.size() - 1 & !usedIndexes.contains(counter)) {
            operation = dataOfFile.get(counter).split(" ")[0];
            numberValue = Integer.parseInt(dataOfFile.get(counter).split(" ")[1]);
            switch (operation) {
                case "nop": {
                    usedIndexes.add(counter);
                    counter++;
                    i++;
                    break;
                }
                case "acc": {
                    accumulatorValue += numberValue;
                    usedIndexes.add(counter);
                    counter++;
                    i++;
                    break;
                }
                case "jmp": {
                    usedIndexes.add(counter);
                    counter += numberValue;
                    i++;
                    break;
                }
            }
        }
        System.out.println("Accumulator value = " + accumulatorValue);
    }

}
