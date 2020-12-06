package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day5 {

    public static ArrayList<Integer> binaryBoarding(List<String> list) { // ex. FFFBFFFLLL
        ArrayList<Integer> seats = new ArrayList<>();
        for (String str: list) {
                int id = binaryPartition(str);
                seats.add(id);
        }
        return seats;
    }

    public static int binaryPartition(String str) {
        int start = 0;
        int end = 127;
        int colStart = 0;
        int colEnd = 7;
        for (char ch: str.toCharArray()) {
            if (ch == 'F') {
                end = ((start + end) / 2) - 1;
            }
            if (ch == 'B') {
                start = ((start + end) / 2) + 1;
            }
            if (ch == 'L') {
                colEnd = ((colEnd + colStart) / 2) - 1;
            }
            if (ch == 'R') {
                colStart = ((colEnd + colStart) / 2) + 1;
            }
        }
        return (start * 8) + colStart;
    }

    public static void main(String[] args) {

        Scanner scanner;
        File file = new File("src\\day5\\input");
        List<String> list = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> boardingPasses = binaryBoarding(list);
        Collections.sort(boardingPasses);
        int highestSeat = Collections.max(boardingPasses);
        int yourSeat = -1;
        for (int i = 0; i < boardingPasses.size() - 1; i++) {
            int current = boardingPasses.get(i);
            int next = boardingPasses.get(i+1);
            if (next - current == 2) {
                yourSeat = current + 1;
            }
        }
        System.out.println("Highests seat: " + highestSeat);
        System.out.println("Your seat: " + yourSeat);
    }
}
