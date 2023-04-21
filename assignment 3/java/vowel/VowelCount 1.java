import java.rmi.*;

public interface VowelCount extends Remote {
    public int findVowelCount(String str) throws RemoteException;
}