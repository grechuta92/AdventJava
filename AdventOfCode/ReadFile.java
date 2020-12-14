package AdventOfCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public static ArrayList<Integer> getDataOfFile(String path) throws FileNotFoundException {
        final Path pathVariable = Paths.get("/Users/user/Desktop/Programowanie/Java/Adventofcode/src/" + path);
        ArrayList<Integer> listOfNumbers;

        try (var in = new Scanner(
                new FileInputStream(String.valueOf(pathVariable)), StandardCharsets.UTF_8)) {
            listOfNumbers = readData(in);
        }
        return listOfNumbers;
    }

    private static ArrayList<Integer> readData(Scanner in) {
        var numbers = new ArrayList<Integer>();
        while (in.hasNext()) {
            numbers.add(in.nextInt());
        }
        return numbers;
    }
}
