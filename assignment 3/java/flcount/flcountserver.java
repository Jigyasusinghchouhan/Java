import java.rmi.registry.*;

public class flcountserver {
    public static void main(String[] args) {
        try {
            flcountimpl fci = new flcountimpl();
            Registry registry = LocateRegistry.createRegistry(1440);
            registry.bind("flcount", fci);
            System.out.println("Server Ready");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}