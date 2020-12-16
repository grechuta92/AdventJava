package AdventOfCode.Day_3;

import AdventOfCode.ReadFile;

import java.util.ArrayList;

public class Forest extends ReadFile {
    protected ArrayList<String> forestNormal;
    protected ArrayList<String> forestExtended;

    protected int horizontal_length_extended = 0;
    protected int vertical_length_extended = 0;

    int horizontalIndex = 0;
    int verticalIndex = 0;

    protected void getExtendedForest(int move_right, int move_down) {

        int horizontal_length = 0;
        int vertical_length = 0;
        int div_move = 0;
        int div_down = 0;

        this.forestNormal = getDataOfFile("/Day_3/ForestLarge.txt");
        horizontal_length = forestNormal.get(0).length();
        vertical_length = forestNormal.size();
        int multiplicationOfForestArray = 0;

        div_move = (vertical_length / horizontal_length);
        div_down = (vertical_length / move_down) / horizontal_length;

        if (move_right >= move_down) {
            multiplicationOfForestArray = move_right * (div_move + 1);
        } else {
            multiplicationOfForestArray = div_down;
        }
        getNewArray(multiplicationOfForestArray);

        vertical_length_extended = this.forestExtended.size();
        horizontal_length_extended = this.forestExtended.get(0).length();
    }

    protected void makeIndexMove(int move_right, int move_down){
        this.horizontalIndex += move_right;
        this.verticalIndex += move_down;
    }

    private void getNewArray(int multiplicationOfForestArray) {
        this.forestExtended = new ArrayList<>();
        for (String var : forestNormal) {
            StringBuilder stringBuilder = new StringBuilder(var);
            for (int i = 0; i < multiplicationOfForestArray - 1; i++) {
                stringBuilder.append(var);
            }
            this.forestExtended.add(stringBuilder.toString());
        }
    }
}

