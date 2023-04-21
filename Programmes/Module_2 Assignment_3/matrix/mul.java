import java.io.*;
import java.util.*;

public class mul {
    public static void main(String[] args) {
        int suml = 0, sumr = 0;
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
        System.out.println("The matrix is ..>>\n");
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    suml += a[i][j];
                }
                if (i + j == n - 1) {
                    sumr += a[i][j];
                }
            }
        }
        System.out.println("\nThe sum of the diagonal elements of the matrix you entered is: " + suml
                + "\n The sum of min diagonal elements is " + sumr);

    }
}