import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class flcountimpl extends UnicastRemoteObject implements flcount {
    public flcountimpl() throws RemoteException {
        super();
    }

    public String counters(String str) throws RemoteException {
        File file = new File(str);
        int c = 0, w = 0, s = 0;
        String drs = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String sr = st;
                String words[] = sr.split(" ");
                w = w + words.length;
                for (String word : words)
                    c = c + word.length();
                for (int i = 0; i < st.length(); i++) {
                    char ee = st.charAt(i);
                    if (!Character.isLetterOrDigit(ee) && !Character.isWhitespace(ee)) {
                        s++;
                    }

                }

            }
            drs = "Number of words in the given file: " + w + "\nNumber of characters in the given file: " + c
                    + " and the number of special characters in the file is " + s;
        } catch (FileNotFoundException e) {
            drs = "File not found";
        } catch (IOException e) {
            drs = "Error reading file";
        } catch (Exception e) {
            drs = "Unexpected error: " + e.getMessage();
        }
        return drs;
    }
}
