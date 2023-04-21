import java.rmi.*;

public class stckclient {
    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:1450/stck";
            stck sti = (stck) Naming.lookup(url);
            sti.push(1);
            sti.push(2);
            sti.push(3);
            System.out.println(sti.pop()); // should print 3
            System.out.println(sti.peek()); // should print 2
            System.out.println(sti.isEmpty()); // should print false
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
