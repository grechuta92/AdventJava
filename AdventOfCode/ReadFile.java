package AdventOfCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public static ArrayList<String> getDataOfFile(String path)  {

        final Path pathVariable = Paths.get("/Users/user/Desktop/Programowanie/Java/Adventofcode/src/AdventOfCode/" + path);
        ArrayList<String> listOfNumbers;

        try (var in = new Scanner(
                new FileInputStream(String.valueOf(pathVariable)), StandardCharsets.UTF_8)) {
            listOfNumbers = readData(in);
            return listOfNumbers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<String> readData(Scanner in) {
        var numbers = new ArrayList<String>();
        while (in.hasNext()) {
            numbers.add(in.nextLine());
        }
        return numbers;
    }
}
