import java.io.*;
import java.net.*;

public class q2_server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Chat server started on port 8000");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                String inputLine;
                String outputLine;

                // Start the conversation with the client
                out.println("Welcome to the chat server!");
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client says: " + inputLine);
                    if (inputLine.equals("exit")) {
                        out.println("Goodbye!");
                        break;
                    } else {
                        System.out.print("Server says: ");
                        outputLine = stdIn.readLine();
                        out.println(outputLine);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
