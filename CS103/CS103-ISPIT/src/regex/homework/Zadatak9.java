package regex.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadatak9 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(var|const|let)\\s[a-zA-Z0-9]=");
        Matcher matcher = pattern.matcher("var a=     var c=");
        String s = "";
        while (matcher.find()) {
            s += " " + matcher.group(0);
        }
        System.out.println(s);
    }
}
