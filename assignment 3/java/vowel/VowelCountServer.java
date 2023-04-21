import java.rmi.registry.*;

public class VowelCountServer {
    public static void main(String[] args) {
        try {
            VowelCountImpl vc = new VowelCountImpl();
            Registry registry = LocateRegistry.createRegistry(1550);
            registry.bind("VowelCount", vc);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}