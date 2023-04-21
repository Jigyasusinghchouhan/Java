import java.rmi.*;
import java.util.Scanner;

public class VowelCountClient {
    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:1550/VowelCount";
            VowelCount vc = (VowelCount) Naming.lookup(url);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string: ");
            String str = sc.nextLine();
            int count = vc.findVowelCount(str);
            System.out.println("Number of vowels: " + count);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}