import java.io.*;
import java.net.*;

public class q1_server {
    public static void main(String[] args) {
        try {
            ServerSocket listener = new ServerSocket(1880);
            System.out.println("Server is ready");
            Socket serverSocket = listener.accept();
            InputStream input = serverSocket.getInputStream();
            DataInputStream dis = new DataInputStream(input);
            System.out.println(dis.readUTF());
            listener.close();

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}