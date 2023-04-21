import java.rmi.*;

public interface stringreverse extends Remote {
    public String ReverseString(String str) throws RemoteException;
}