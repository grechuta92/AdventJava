package AdventOfCode.Day_4.Solution;

import com.sun.source.tree.IfTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateNewFile {
    public void createNewFileWithConvertedList(ArrayList<String> arrayList, String path) {
        File file = new File("/Users/user/Desktop/Programowanie/Java/Adventofcode/src/AdventOfCode" + path);
        try {
            if (!file.exists()) {
                FileWriter newDocument = new FileWriter("/Users/user/Desktop/Programowanie/Java/Adventofcode/src/AdventOfCode" + path);
                for (String var : arrayList) {
                    newDocument.write(var.replace(" ", "\n").replace(":", " "));
                    newDocument.write("\n");
                }
                newDocument.close();
            }
        } catch (IOException e) {
            System.out.println("File not created");
        }
    }
}
