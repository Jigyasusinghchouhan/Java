import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("localhost", 8083);
        System.out.println("Connected to server!");


        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

     
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while ((message = userInput.readLine()) != null) {
            out.println(message);

            
            String response = in.readLine();
            System.out.println("Server: " + response);
        }

        socket.close();
    }
}
                                                                                                                                                                                                                     