import java.io.*;
import java.net.*;
import java.util.Scanner;

public class q3_client {
    public static void main(String abc[]) {
        try {
            Socket clientSocket = new Socket("localhost", 1800);
            OutputStream os = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            // for (int i = 0; i < 1; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter filename");
            String msg = scan.nextLine();
            dos.writeUTF(msg);
            System.out.println(dis.readUTF());
        } catch (UnknownHostException ue) {
            ue.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}