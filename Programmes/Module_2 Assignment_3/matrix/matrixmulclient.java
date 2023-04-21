import java.rmi.Naming;
import java.util.*;

public class matrixmulclient {
    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:1500/matrixmul";
            matrixmul mmi = (matrixmul) Naming.lookup(url);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the order of the matrix");
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter the element [" + i + "][" + j + "]");
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.println(mmi.showmatrix(a));
            System.out.println(mmi.multi(a));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}