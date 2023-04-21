import java.rmi.*;
import java.util.Scanner;

public class stringreverseclient {
    public static void main(String args[]) {
        try {
            String url = "rmi://localhost:1450/stringreverse";
            stringreverse sri = (stringreverse) Naming.lookup(url);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the string you want to reverse");
            String dmo = sc.nextLine();
            String lmo = sri.ReverseString(dmo);
            System.out.println("Reversed String is : " + lmo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}