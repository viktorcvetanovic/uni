package zadatak2.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainServer {
    public static void main(String[] args) {
        Socket s = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3333);
            System.out.println("SERVER IS STARTED");
            while (true) {
                s = serverSocket.accept();
                System.out.println("USER IS CONNECTED");
                ObjectInputStream objectInputStream = new ObjectInputStream(s.getInputStream());
                String words = (String) objectInputStream.readObject();
                System.out.println(Arrays.toString(countWords(words)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static String[] countWords(String words) {
        String array[] = words.split(" ");
        Logger logger= Logger.getLogger(String[].class.getName());
        logger.log(Level.INFO,Arrays.toString(array));
        String word="";
        int number=0;
        for(int i=0;i< array.length;i++){
            int count=0;
            for(int j=0;j< array.length;j++){
                if(array[i].equalsIgnoreCase(array[j])){
                    count++;
                }
                if(j== array.length-1){
                    if(count>number){
                        number=count;
                        word=array[i];
                    }
                }
            }
        }
        return new String[]{word,String.valueOf(number)};
    }


}
