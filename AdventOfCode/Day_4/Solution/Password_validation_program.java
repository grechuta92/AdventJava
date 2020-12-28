package AdventOfCode.Day_4.Solution;

import AdventOfCode.ReadFile;

import java.util.*;

public class Password_validation_program extends ReadFile {

    public static void main(String[] args) {

        createGroupedList();

        ArrayList<String> listOfGroupedDocuments = ReadFile.getDataOfFile("/Day_4/Documents_data_converted_copy.txt");
        listOfGroupedDocuments.add(""); // Add one more blank value, to count last document

        int numberOfValidPassportShortCuts = countNumberOfValidPassport(listOfGroupedDocuments);
        int numberOfValidPassportWithRules = countNumberOfValidPassportByRules(listOfGroupedDocuments);


        System.out.println("Number of Valid Passport counted only by shortcuts is: " + numberOfValidPassportShortCuts);
        System.out.println("Number of Valid Passport with specify rules is: " + numberOfValidPassportWithRules);

    }

    private static int countNumberOfValidPassportByRules(final ArrayList<String> listOfGroupedDocuments) {
        boolean isBirthDay = false;
        boolean isYear = false;
        boolean isidExpirationYear = false;
        boolean isHeight = false;
        boolean isHairColour = false;
        boolean isEyeColour = false;
        boolean isPassportId = false;
        boolean isCountryId = true;
        int counterOfRulesValidPassport = 0;

        for (String var : listOfGroupedDocuments) {

            if (!var.isBlank()) {

                String[] coloursOfEye = new String[]{"amb", "blu", "brn", "grn", "gry", "hzl", "oth"};
                String[] tempString = var.split(":");
                String shortCut = tempString[0];
                String value = tempString[1];

                switch (shortCut) {
                    case "byr":
                        if (Integer.parseInt(value) >= 1920 && Integer.parseInt(value) <= 2020) {
                            isBirthDay = true;
                        }
                        break;
                    case "iyr":
                        if (Integer.parseInt(value) >= 2010 && Integer.parseInt(value) <= 2020) {
                            isYear = true;
                        }
                        break;
                    case "eyr":
                        if (Integer.parseInt(value) >= 2020 && Integer.parseInt(value) <= 2030) {
                            isidExpirationYear = true;
                        }
                        break;
                    case "hgt":
                        int hgt;
                        if (value.endsWith("cm")) {
                                hgt = Integer.parseInt(value.replace("cm", ""));
                            if (hgt >= 150 && hgt <= 193) {
                                isHeight = true;
                            }
                        } else if (value.endsWith("in")) {
                            hgt = Integer.parseInt(value.replace("in", ""));
                            if (hgt >= 59 && hgt <= 76) {
                                isHeight = true;
                            }
                        }
                        break;
                    case "hcl":
                        if (value.matches("^#([a-f0-9]{6})$")){
                            isHairColour = true;
                        }

                        break;
                    case "ecl":
                        if (Arrays.stream(coloursOfEye).anyMatch(s -> s.equals(value))) {
                            isEyeColour = true;
                        }
                        break;
                    case "pid":
                        if(value.matches("^([0-9]{9})$"))
                         isPassportId = true;
                        break;
                }
            } else {
                if (isPassportId && isBirthDay && isCountryId && isEyeColour && isHeight && isYear && isidExpirationYear && isHairColour) {
                    counterOfRulesValidPassport++;
                }
                isBirthDay = false;
                isYear = false;
                isidExpirationYear = false;
                isHeight = false;
                isHairColour = false;
                isEyeColour = false;
                isPassportId = false;
            }
        }
        return counterOfRulesValidPassport;
    }

    private static int countNumberOfValidPassport(ArrayList<String> list) {
        String[] informations = new String[]{"ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt"};

        int insideCounter = 0;
        int counter = 0;

        for (String var : list) {
            if (!var.isBlank()) {
                for (int i = 0; i < informations.length; i++) {
                    if (var.substring(0, 3).equals(informations[i])) {
                        insideCounter++;
                    }
                }
            } else {
                if (insideCounter >= 7) {
                    counter++;
                }
                insideCounter = 0;
            }
        }
        return counter;
    }

    private static void createGroupedList() {
        ArrayList<String> list_original = ReadFile.getDataOfFile("/Day_4/Document_data_original.txt");

        CreateNewFile createNewFile = new CreateNewFile();
        createNewFile.createNewFileWithConvertedList(list_original, "/Day_4/Documents_data_converted_copy.txt");

    }
}