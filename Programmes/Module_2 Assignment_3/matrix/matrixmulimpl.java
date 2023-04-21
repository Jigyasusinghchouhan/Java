import java.rmi.*;
import java.rmi.server.*;
// import java.io.*;
// import java.util.*;

public class matrixmulimpl extends UnicastRemoteObject implements matrixmul {
    public matrixmulimpl() throws RemoteException {
        super();
    }

    public String multi(int a[][]) throws RemoteException {
        int suml = 0, sumr = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    suml += a[i][j];
                }
                if (i + j == a.length - 1) {
                    sumr += a[i][j];
                }
            }
        }

        return ("\nThe sum of the diagonal elements of the matrix you entered is: " + suml
                + "\n The sum of min diagonal elements is " + sumr);

    }

    public String showmatrix(int a[][]) throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("The matrix is ..>>\n");
        for (

                int i = 0; i < (a.length); i++) {
            sb.append("\n");
            for (int j = 0; j < (a.length); j++) {
                sb.append(a[i][j] + " ");

            }
        }
        return sb.toString();

    }
}
