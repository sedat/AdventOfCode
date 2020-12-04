package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.*;

// could have used regex in checkProperty, but I was too sleepy to think in regex

public class day4 {

    public static int validPasswords(List<String[]> list, Set<String> fields) {
        int valid = 0;
        int count = 0;
        for (String[] field : list) {
            for (int j = 0; j < field.length && field[j] != null; j++) {
                String property = field[j].substring(0, field[j].indexOf(":"));
                if (!property.equals("cid") && fields.contains(property)) {
                    String value = field[j].substring(field[j].indexOf(":") + 1);
                    boolean check = checkProperty(property, value);
                    if (check) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count == fields.size()) {
                valid++;
            }
            count = 0;
        }

        return valid;
    }

    public static boolean checkProperty(String property, String value) {
        boolean check = false;
        switch (property) {
            case("byr"):
                if (Integer.parseInt(value) >= 1920 && Integer.parseInt(value) <= 2002) {
                    check = true;
                }
                break;
            case("eyr"):
                if (Integer.parseInt(value) >= 2020 && Integer.parseInt(value) <= 2030) {
                    check = true;
                }
                break;
            case("iyr"):
                if (Integer.parseInt(value) >= 2010 && Integer.parseInt(value) <= 2020) {
                    check = true;
                }
                break;
            case("hgt"):
                if (value.length() == 2) {
                    break;
                }
                int val = Integer.parseInt(value.substring(0, value.length() - 2));
                final String substring = value.substring(value.length() - 2);
                if (substring.equals("cm")) {
                    if (val >= 150 && val <= 193) {
                        check = true;
                    }
                }
                if (substring.equals("in")) {
                    if (val >= 59 && val <= 76) {
                        check = true;
                    }
                }
                break;
            case("hcl"):
                if (value.charAt(0) == '#' && value.substring(1).length() == 6) {
                    check = true;
                }
                break;
            case("ecl"):
                if (value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry") || value.equals("grn") || value.equals("hzl") || value.equals("oth")) {
                    check = true;
                }
                break;
            case("pid"):
                if (value.length() == 9) {
                    check = true;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + property);
        }
        return check;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("byr");
        set.add("eyr");
        set.add("iyr");
        set.add("hgt");
        set.add("hcl");
        set.add("ecl");
        set.add("pid");


        Scanner scanner;
        File file = new File("src\\day4\\input");
        List<String[]> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        try {
            // Rather than doing some tricks here to read faster, I'm doing it the real way, getting and storing each passport in an array
            scanner = new Scanner(file);
            int i = 0;
            int j = 0;
            String[] fields = new String[8];
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    list.add(i++, fields);
                    fields = new String[8];
                    j = 0;
                    continue;
                }
                for (String str: line.split(" ")
                     ) {
                    fields[j++] = str;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = validPasswords(list,set);
        long stop = System.currentTimeMillis() - start;
        System.out.println(stop);
        System.out.println(count);
    }
}
