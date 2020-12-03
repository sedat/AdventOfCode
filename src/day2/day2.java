package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day2 {

    public static int validPasswords(List<String[]> list) {
        int validCount = 0;
        for (String[] str: list) {
            int dash = str[0].indexOf("-");
            int min = Integer.parseInt(str[0].substring(0, dash));
            int max = Integer.parseInt(str[0].substring(dash+1));
            char ch = str[1].charAt(0);
            String password = str[2];
            int chCount = 0;
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == ch) {
                    chCount++;
                }
            }
            if (chCount >=min && chCount <= max) {
                validCount++;
            }
        }
        return validCount;
    }

    public static int part2(List<String[]> list) {
        int validCount = 0;
        for (String[] str: list) {
            int dash = str[0].indexOf("-");
            int min = Integer.parseInt(str[0].substring(0, dash));
            int max = Integer.parseInt(str[0].substring(dash+1));
            char ch = str[1].charAt(0);
            String password = str[2];
            int chCount = 0;

            if (password.charAt(min - 1) == ch) {
                    chCount++;
            }
            if (password.charAt(max - 1) == ch) {
                    chCount++;
            }
            if (chCount == 1) {
                validCount++;
            }
        }
        return validCount;
    }

    public static void main(String[] args) {
        Scanner scanner;
        File file = new File("C:\\Users\\sedat\\IdeaProjects\\AdventOfCode\\src\\day2\\input");
        List<String[]> list = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                list.add(scanner.nextLine().split(" "));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(part2(list));

    }
}
