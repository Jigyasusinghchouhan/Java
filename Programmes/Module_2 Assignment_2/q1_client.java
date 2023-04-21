import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class q1_client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 1880);
            OutputStream os = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            try (Scanner sc = new Scanner(System.in)) {
                String msg = sc.nextLine();

                dos.writeUTF(msg);
            } catch (InputMismatchException ie) {
                ie.printStackTrace();
            }
            clientSocket.close();

        } catch (UnknownHostException ue) {
            ue.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}