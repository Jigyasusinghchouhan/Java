import java.rmi.*;
import java.rmi.server.*;

public class stringreverseimpl extends UnicastRemoteObject implements stringreverse {
    public stringreverseimpl() throws RemoteException {
        super();
    }

    public String ReverseString(String str) throws RemoteException {
        StringBuffer sbt = new StringBuffer(str);
        sbt.reverse();
        String str2 = sbt.toString();
        return str2;
    }
}