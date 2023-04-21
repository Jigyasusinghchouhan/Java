import java.rmi.Remote;

public interface ADDI extends Remote {
    public int add(int x, int y) throws Exception;
}