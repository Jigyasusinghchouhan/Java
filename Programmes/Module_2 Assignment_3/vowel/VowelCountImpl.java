import java.rmi.*;
import java.rmi.server.*;

public class VowelCountImpl extends UnicastRemoteObject implements VowelCount {
    public VowelCountImpl() throws RemoteException {
        super();
    }

    public int findVowelCount(String str) throws RemoteException {
        int count = 0;
        String strr = str.toLowerCase();
        for (int i = 0; i < strr.length(); i++) {
            char ch = strr.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}