import java.io.*;
import java.net.*;

public class q4_server {
    public static void main(String[] args) {
        try {
            ServerSocket listener = new ServerSocket(1990);
            System.out.println("Server is ready");
            Socket serverSocket = listener.accept();
            InputStream input = serverSocket.getInputStream();
            DataInputStream dis = new DataInputStream(input);
            OutputStream os = serverSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            try {
                String filename = dis.readUTF();
                FileInputStream fi = new FileInputStream(filename);
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String st;

                while ((st = br.readLine()) != null) {
                    StringBuffer buffer = new StringBuffer(st);
                    buffer = buffer.reverse();
                    String ts = buffer.toString();
                    dos.writeUTF("File Content:" + ts);
                }

                listener.close();
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
