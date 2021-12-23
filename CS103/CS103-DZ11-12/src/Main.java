import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //ne znam da primenim Primov algoritam!!!
        BufferedReader bufferedReader = new BufferedReader(new FileReader("graf.txt"));
        String s = "";
        int num = 0;
        Graph graph = new Graph();
        while ((s = bufferedReader.readLine()) != null) {
            if (num == 0) {
                System.out.println(s);
            }


            num++;
        }
        bufferedReader.close();
    }

}
