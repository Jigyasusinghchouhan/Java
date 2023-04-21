import java.rmi.*;
import java.rmi.server.*;
import java.util.Stack;

public class stckimpl extends UnicastRemoteObject implements stck {
    private Stack<Integer> stack;

    public stckimpl() throws RemoteException {
        super();
        stack = new Stack<Integer>();
    }

    public void push(int item) throws RemoteException {
        stack.push(item);
    }

    public int pop() throws RemoteException {
        return stack.pop();

    }

    public int peek() throws RemoteException {
        return stack.peek();
    }

    public boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

}
