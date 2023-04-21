import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatProgram {

    public static void main(String[] args) throws Exception {
        // Create a server socket and listen for incoming connections
        ServerSocket serverSocket = new ServerSocket(8083);
        System.out.println("Waiting for clients to connect...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create input and output streams for the client socket
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Read messages from the client and display them
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Client: " + message);

            // Get input from the user and send it to the client
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("You: ");
            String response = userInput.readLine();
            out.println(response);
        }

        // Close the socket and server socket
        client