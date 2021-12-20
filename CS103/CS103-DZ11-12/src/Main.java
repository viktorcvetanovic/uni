import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new FileReader("graf.txt"));
        String s="";
        while ((s=bufferedReader.readLine())!=null){
            System.out.println(s);
        }
        bufferedReader.close();
    }

}
