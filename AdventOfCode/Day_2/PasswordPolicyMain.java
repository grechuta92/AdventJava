package AdventOfCode.Day_2;

import AdventOfCode.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PasswordPolicyMain extends ReadFile {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> listOfVariables;

        listOfVariables = getDataOfFile("Day_2/Passwords.txt");
        ListConverter.convertList(listOfVariables);
    }

}

