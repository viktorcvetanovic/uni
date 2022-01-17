package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadatak3 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(CS|IT|SE)");
        Matcher matcher = pattern.matcher("CS111 SE202 SE222");
        String s="";
        while (matcher.find()) {
            s+= " "+matcher.group(0);
        }
        System.out.println(s);
    }
}
