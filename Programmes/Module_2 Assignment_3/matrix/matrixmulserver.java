import java.rmi.registry.*;

public class matrixmulserver {
    public static void main(String[] args) {
        try {
            matrixmulimpl mmi = new matrixmulimpl();
            Registry registry = LocateRegistry.createRegistry(1500);
            registry.bind("matrixmul", mmi);
            System.out.println("Server Ready");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}