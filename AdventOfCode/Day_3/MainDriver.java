package AdventOfCode.Day_3;

import java.io.FileNotFoundException;

public class MainDriver{
    public static void main(String[] args) throws FileNotFoundException {
        Forest forest = new Forest();
        Toboggan toboggan = new Toboggan();

        toboggan.move(forest);
    }
}
