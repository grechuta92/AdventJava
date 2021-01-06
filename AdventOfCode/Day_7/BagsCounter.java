package AdventOfCode.Day_7;

import AdventOfCode.ReadFile;

import java.util.ArrayList;
import java.util.HashSet;

public class BagsCounter extends ReadFile {

    public static void main(String[] args) {
        ArrayList<String> listOfRules = getDataOfFile("/Day_7/ListOfRegularRules.txt");
        HashSet<String> listOfBags = new HashSet<>();

        listOfBags = analiseList(listOfRules);

//        System.out.println(listOfBags);
        System.out.println(listOfBags.size() - 1);


    }

    private static HashSet<String> analiseList(ArrayList<String> listOfRules) {
        HashSet<String> listOfContainingBag = new HashSet<>();
        listOfContainingBag.add("shiny gold");
        ArrayList<String> tempListOfColour = new ArrayList<>();
        String tempColour = "";

        for (int i = 0; i < listOfRules.size(); i++) {
            for (String colourOfBag : listOfContainingBag) {
                for (String var : listOfRules) {
                    tempColour = getColourOfBagFromLine(var, colourOfBag);
                    if (!tempColour.equals(""))
                        tempListOfColour.add(tempColour);
                }
            }
            listOfContainingBag.addAll(tempListOfColour);
        }
        return listOfContainingBag;
    }

    private static String getColourOfBagFromLine(String lineOfRules, String myBag) {
        if (lineOfRules.contains(myBag)) {
            return lineOfRules.split(" bags contain ")[0];
        } else {
            return "";
        }
    }
}
