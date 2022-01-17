package regex.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadatak1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([1-9][0-9][0-9].){2}\\d{3}\\b");
        Matcher matcher = pattern.matcher("192.168.122");
        String s = "";
        while (matcher.find()) {
            s += " " + matcher.group(0);
        }
        System.out.println(s);
    }

}
