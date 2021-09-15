package zadatak2.client;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite tekst za brojanje");
        String words = scanner.nextLine();
        try (Socket socket = new Socket("localhost", 3333)) {
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(words);
            objectOutputStream.flush();
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
