import java.rmi.*;

public class client {
    public static void main(String[] args) throws Exception {
        ADDI obj = (ADDI) Naming.lookup("ADD");
        int n = obj.add(6, 89);
        System.out.println("Addition is " + n);
    }
}