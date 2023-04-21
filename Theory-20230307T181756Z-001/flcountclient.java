import java.rmi.*;
import java.util.Scanner;

public class flcountclient {
    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:1440/flcount";
            flcount fci = (flcount) Naming.lookup(url);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the file name you want to count the characters of");
            String fname = sc.nextLine();
            System.out.println(fci.counters(fname));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}