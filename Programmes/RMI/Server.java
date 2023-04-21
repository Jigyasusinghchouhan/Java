import java.rmi.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ADDC obj = new ADDC();
        Naming.rebind("ADD", obj);
        System.out.println("Server Started");
    }
}