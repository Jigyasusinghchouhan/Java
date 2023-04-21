import java.rmi.server.*;

public class ADDC extends UnicastRemoteObject implements ADDI {
    public ADDC() throws Exception {
        super();
    }

    public int add(int x, int y) {
        return x + y;
    }
}