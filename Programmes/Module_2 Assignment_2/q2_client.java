import java.io.*;
import java.net.*;

public class q2_client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to server");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Server says: " + inputLine);
                    if (inputLine.equals("Goodbye!")) {
                        break;
                    }
                    System.out.print("Client says: ");
                    String outputLine = stdIn.readLine();
                    out.println(outputLine);
                }
            } catch (UnknownHostException ue) {
                ue.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
