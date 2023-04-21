import java.io.*;
import java.net.*;
import java.util.HashSet;

public class q5_server {
    public static String replaceDuplicateCharsWithX(String inputString) {
        HashSet<Character> seen = new HashSet<>();
        StringBuilder output = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (seen.contains(c)) {
                output.append('x');
            } else {
                output.append(c);
                seen.add(c);
            }
        }
        return output.toString();
    }

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
                String outputString = replaceDuplicateCharsWithX(filename);
                dos.writeUTF("OUTPUT:" + outputString);
                listener.close();
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}