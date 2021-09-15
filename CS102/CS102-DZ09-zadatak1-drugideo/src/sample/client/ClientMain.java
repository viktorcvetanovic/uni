package sample.client;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Unesite zeljenu vrednost --> ");
        Double valueToConvert= sc.nextDouble();
        try(Socket s=new Socket("localhost",8500)) {
            DataOutputStream send=new DataOutputStream(s.getOutputStream());
            send.write(toByteArray(valueToConvert));
            send.flush();
            DataInputStream read= new DataInputStream(s.getInputStream());
            byte[] byteArray = new byte[8];
            read.read(byteArray);
            System.out.println(toDouble(byteArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] toByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(value);
        return bytes;
    }
    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
}
