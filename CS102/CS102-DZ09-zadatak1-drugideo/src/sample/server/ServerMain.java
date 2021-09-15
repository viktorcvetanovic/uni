package sample.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ServerMain {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8500);
        System.out.println("Server started on port 8500");
        new Thread(() -> {
            while (true) {
                try (Socket s = server.accept()){
                    DataInputStream read = new DataInputStream(s.getInputStream());
                    byte[] byteArray = new byte[8];
                    read.read(byteArray);
                    byte[] kgValue = convertLbToKg( toDouble(byteArray));
                    DataOutputStream send = new DataOutputStream(s.getOutputStream());
                    send.write(kgValue);
                    send.flush();
                    System.out.println("User is connected");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static byte[] convertLbToKg(Double lbValue) {
        return toByteArray(lbValue * 0.45359237);
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
