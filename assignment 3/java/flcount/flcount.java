import java.rmi.*;

public interface flcount extends Remote {
    public String counters(String str) throws RemoteException;
}