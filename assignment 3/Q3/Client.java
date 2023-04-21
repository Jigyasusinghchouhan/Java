import java.rmi.*;

public class Client {

    public static void main(String[] args) {
        try {
            DiagonalSumInterface server = (DiagonalSumInterface) Naming.lookup("DiagonalSum");
            int sum = server.diagonalSum();
            System.out.println("Sum of diagonal elements: " + sum);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
