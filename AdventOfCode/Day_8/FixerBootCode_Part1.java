package AdventOfCode.Day_8;

import AdventOfCode.ReadFile;

import java.util.ArrayList;

public class FixerBootCode_Part1 extends ReadFile {
    public static void main(String[] args) {
        ArrayList<String> dataOfFile = getDataOfFile("/Day_8/BootCode.txt");

        startProgram(dataOfFile);

    }

    public static void startProgram(ArrayList<String> dataOfFile) {

        ArrayList<Integer> usedIndexes = new ArrayList<>();
        String operation = "";
        int accumulatorValue = 0;
        int numberValue = 0;

        for (int counter = 0; counter < dataOfFile.size(); counter += 0) {
            operation = dataOfFile.get(counter).split(" ")[0];
            numberValue = Integer.parseInt(dataOfFile.get(counter).split(" ")[1]);
            if (!operation.equals(dataOfFile.get(dataOfFile.size() - 1)) & !usedIndexes.contains(counter)) {
                switch (operation) {
                    case "nop": {
                        usedIndexes.add(counter);
                        counter++;
                        break;
                    }
                    case "acc": {
                        accumulatorValue += numberValue;
                        usedIndexes.add(counter);
                        counter++;
                        break;
                    }
                    case "jmp": {
                        usedIndexes.add(counter);
                        counter += numberValue;
                        break;
                    }
                }
            } else {
                System.out.println("Accumulator value = " + accumulatorValue);
                break;
            }
        }

    }
}
