package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day1 {

    public static int to2020_1(ArrayList<Integer> arr, int year) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : arr) {
            int temp = year - integer;
            if (set.contains(temp)) {
                return temp * integer;
            } else {
                set.add(integer);
            }
        }
        return 0;
    }

    public static int to2020_2(ArrayList<Integer> arr, int year) {
        for (int i = 0; i < arr.size() - 2; i++) {
            int next = i + 1;
            int end = arr.size() - 1;
            while(next < end) {
                if ((arr.get(i) + arr.get(next) + arr.get(end)) == year) {
                    return arr.get(i) * arr.get(next) * arr.get(end);
                }
                else if ((arr.get(i) + arr.get(next) + arr.get(end)) < year) {
                    next++;
                } else {
                    end--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\sedat\\IdeaProjects\\AdventOfCode\\src\\day1\\input");
        ArrayList<Integer> list = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        list.sort(Comparator.comparingInt(one -> one)); // required for part 2 of the question (for better performance, quicksort can be used)

        int res1 = to2020_1(list, 2020);
        int res2 = to2020_2(list, 2020);


        System.out.println(res1);
        System.out.println(res2);
    }
}
