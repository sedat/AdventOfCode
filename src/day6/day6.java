package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day6 {

    public static int customCustomsPart1(String lines) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0;i<lines.length();i++) {
            if (lines.charAt(i) != ' ') {
                set.add(lines.charAt(i));
                if (lines.charAt(i) == '\n') {
                    count += set.size() - 1;
                    set = new HashSet<>();
                }
            }
        }
        return count;
    }

    public static int customCustomsPart2(String lines) {
        int count = 0;
        int people = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i<   lines.length();i++) {
            if (lines.charAt(i) == ' ') people++;
            if (lines.charAt(i) == '\n') {
                int finalPeople = people;
                long max = map.values().stream().filter(v->v == finalPeople).count();
                count += max - 1; // except the spaces
                people = 0;
                map = new HashMap<>();
            } else {
                if (map.containsKey(lines.charAt(i))) {
                    map.put(lines.charAt(i), map.get(lines.charAt(i)) + 1);
                } else {
                    map.put(lines.charAt(i), 1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src\\day6\\input"));
        StringBuilder strLines = new StringBuilder();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                strLines.append("\n");
            } else {
                strLines.append(line).append(" ");
            }
        }
        strLines.append('\n');

        System.out.println("Part 1: " + customCustomsPart1(strLines.toString()));
        System.out.println("Part 2: " + customCustomsPart2(strLines.toString()));
    }
}
