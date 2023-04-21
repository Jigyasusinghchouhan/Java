import java.io.*;
import java.net.*;

public class q3_server {
    public static void main(String[] args) {
        try {
            ServerSocket listener = new ServerSocket(1800);
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
                    dos.writeUTF("File Content:" + st);
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

// StringBuffer buffer = new StringBuffer(st);
// buffer = buffer.reverse();
// String ts = buffer.toString();
// dos.writeUTF("File Content:" + ts);