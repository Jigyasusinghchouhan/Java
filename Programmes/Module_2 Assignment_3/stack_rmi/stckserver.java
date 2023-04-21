import java.rmi.registry.*;

public class stckserver {

    public static void main(String[] args) {
        try {
            stckimpl sti = new stckimpl();
            Registry registry = LocateRegistry.createRegistry(1450);
            registry.bind("stck", sti);
            System.out.println("Server Ready");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
