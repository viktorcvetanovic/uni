import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("PAL", "LAP", "PAM", "MAP", "PAT", "PET", "SET", "SAT", "TAT", "BAT");

        Hash hash=new Hash();
        for(String s:list){
            hash.add(s);
        }
        System.out.println(hash);


        Hash2 hash2=new Hash2();
        for(String s:list){
            hash2.add(s);
        }
        System.out.println(hash2);

    }
}
