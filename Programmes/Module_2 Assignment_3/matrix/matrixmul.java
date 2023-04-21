import java.rmi.*;

public interface matrixmul extends Remote {
    public String multi(int a[][]) throws RemoteException;

    public String showmatrix(int a[][]) throws RemoteException;
}