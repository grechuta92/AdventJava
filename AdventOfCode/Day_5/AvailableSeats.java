package AdventOfCode.Day_5;

import AdventOfCode.ReadFile;

import java.util.ArrayList;
import java.util.Collections;

public class AvailableSeats extends ReadFile {
    public static void main(String[] args) {
        ArrayList<Integer> seatsId = getSeatsId(getArray());
        int maxValueOfSeatId = 0;

        maxValueOfSeatId = getMaxValue(seatsId);
        System.out.println("Max value of Seat Id: " + maxValueOfSeatId);

        System.out.println("Left seats: " + getLeftSeats(seatsId));

    }

    private static ArrayList<Integer> getLeftSeats(ArrayList<Integer> listOfSeatsId) {
        Collections.sort(listOfSeatsId);
        int min = Collections.min(listOfSeatsId);
        int max = Collections.max(listOfSeatsId);
        ArrayList<Integer> listOfAvailableSeats = new ArrayList<>();

        for (int i = min; i < max ; i++) {
            if(!listOfSeatsId.contains(i)){
                listOfAvailableSeats.add(i);
            }
        }
        return listOfAvailableSeats;
    }

    private static int getMaxValue(ArrayList<Integer> listOfSeatsId) {
        Collections.sort(listOfSeatsId);
        return Collections.max(listOfSeatsId);
    }

    private static ArrayList<Integer> getSeatsId(ArrayList<String> arrayList) {
        int front = 0;
        int back = 127;
        int row = 0;
        int column = 0;
        int left = 0;
        int right = 7;
        ArrayList<Integer> seatId = new ArrayList<>();
        for (String var : arrayList) {
            for (int i = 0; i < var.length() - 3; i++) {
                if (var.charAt(i) == 'F') {
                    back += (front - back) / 2 - 1;
                } else if (var.charAt(i) == 'B') {
                    front += ((back - front) / 2 + 1);
                }
            }
            if (front == back) {
                row = front;
            }

            for (int i = var.length() - 3; i < var.length(); i++) {
                if (var.charAt(i) == 'L') {
                    right += ((left - right) / 2 - 1);
                } else if (var.charAt(i) == 'R') {
                    left += ((right - left) / 2 + 1);
                }
            }
            if (right == left) {
                column = right;
            }
            seatId.add((row * 8 + column));
            front = 0;
            back = 127;
            left = 0;
            right = 7;
        }
        return seatId;
    }

    private static ArrayList<String> getArray() {
        return ReadFile.getDataOfFile("Day_5/SeatsPlane.txt");
    }

}
