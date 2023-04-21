import java.rmi.*;

public interface stck extends Remote {
    public void push(int item) throws Exception;

    public int pop() throws Exception;

    public int peek() throws Exception;

    public boolean isEmpty() throws RemoteException;
}
