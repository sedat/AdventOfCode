package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day3 {

    public static int traverseRoad(List<String> list, int right, int down) {
        int trees = 0;
        int pos = 0;
        int roadLen = list.get(0).length();
        for (int i = 0; i < list.size(); i+=down) {
            if (list.get(i).charAt(pos % roadLen) == '#') {
                trees++;
            }
            pos += right;
        }
        return trees;
    }

    public static void main(String[] args) {
        Scanner scanner;
        File file = new File("C:\\Users\\sedat\\IdeaProjects\\AdventOfCode\\src\\day3\\input");
        List<String> list = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int total = traverseRoad(list, 1, 1) * traverseRoad(list, 3,1) * traverseRoad(list,5,1) * traverseRoad(list,7,1) * traverseRoad(list, 1, 2);
        System.out.println(total);
    }
}
