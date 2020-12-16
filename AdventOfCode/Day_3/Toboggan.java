package AdventOfCode.Day_3;


import java.util.ArrayList;

public class Toboggan extends Forest {

    protected ArrayList<Integer> listTrees = new ArrayList<>();

    public void move(Forest forest) {
        int[][] moves = {{1,1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
        char x;

        for (int[] move : moves) {
            int treesCounter = 0;
            forest.getExtendedForest(move[0], move[1]);
            while (forest.verticalIndex < forest.vertical_length_extended & forest.horizontalIndex < forest.horizontal_length_extended) {
                x = forest.forestExtended.get(forest.verticalIndex).charAt(forest.horizontalIndex);

                if (x == '#'){
                    treesCounter++;
                    forest.makeIndexMove(move[0],move[1]);
                } else if (x == '.'){
                    forest.makeIndexMove(move[0],move[1]);
                } else {
                    break;
                }

            }
            listTrees.add(treesCounter);
            forest.verticalIndex = 0;
            forest.horizontalIndex = 0;
        }
        System.out.println(listTrees);

    }

}

