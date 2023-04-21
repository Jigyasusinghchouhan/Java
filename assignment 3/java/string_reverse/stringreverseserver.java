import java.rmi.registry.*;

public class stringreverseserver {
    public static void main(String args[]) {
        try {
            stringreverseimpl sri = new stringreverseimpl();
            Registry registry = LocateRegistry.createRegistry(1450);
            registry.bind("stringreverse", sri);
            System.out.println("server ready");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
