package ClientServer;
import java.net.;
public class Client {
    
        public static void main (String[]args)throws Exception{
            ServerSocket listner = new ServerSocket(1880);
            System.out.println("Server is ready");
            Socket serverSocket=listener.accept();
            InputStream input=serverSocket.getInputStream();
            DataInputStream dis=new DataInputStream(input);
            System.out.println(dis.readUTF());
            listener.close();
        }
}