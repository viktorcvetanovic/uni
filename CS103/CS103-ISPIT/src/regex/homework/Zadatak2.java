package regex.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadatak2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(([0-9][1-9]-){2}\\d{4}\\b) | ([1-9]\\d{3}-\\d{2}-\\d{2}\\b)");
        Matcher matcher = pattern.matcher("22-23-1922    1932-02-13");
        String s = "";
        while (matcher.find()) {
            s += " " + matcher.group(0);
        }
        System.out.println(s);
    }
}
