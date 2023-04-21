import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LibraryGUI extends Frame implements ActionListener {
    private TextField tfBookId = new TextField();
    private TextField tfBookName = new TextField();
    private TextField tfAuthor = new TextField();
    private Button btnAdd = new Button("Add");
    private Button btnUpdate = new Button("Update");
    private Button btnDelete = new Button("Delete");
    private Button btnShow = new Button("Show");
    public LibraryGUI() {
        setLayout(new FlowLayout());
        add(new Label("Book ID:"));
        add(tfBookId);
        add(new Label("Book Name:"));
        add(tfBookName);
        add(new Label("Author:"));
        add(tfAuthor);
        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnShow);
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnShow.addActionListener(this);
        setSize(400, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
   public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == btnAdd) {
           try {
               
               Class.forName("com.mysql.jdbc.Driver");
               
               Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user","password");
               
               PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Library (bookid, bookname, author) VALUES (?, ?, ?)");
               pstmt.setInt(1, Integer.parseInt(tfBookId.getText()));
               pstmt.setString(2, tfBookName.getText());
               pstmt.setString(3, tfAuthor.getText());
               int result = pstmt.executeUpdate();
               if (result == 1) {
                   tfBookId.setText("");
                   tfBookName.setText("");
                   tfAuthor.setText("");
                   System.out.println("Data saved successfully.");
               } else {
                   System.out.println("Error saving data.");
               }
               
               conn.close();
           } catch (Exception e) {
               System.out.println("Error: " + e.getMessage());
           }
       } else if (ae.getSource() == btnUpdate) {
      
            
    Driver DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "username","password");
            PreparedStatement pstmt = conn
.prepareStatement("INSERT INTO Students (name, rollno, marks) VALUES (?, ?, ?)");
            pstmt.setString(1, tfName.getText());
            pstmt.setInt(2, Integer.parseInt(tfRollNo.getText()));
            pstmt.setInt(3, Integer.parseInt(tfMarks.getText()));
            int result = pstmt.executeUpdate();
            if (result == 1) {
                tfName.setText("");
                tfRollNo.setText("");
                tfMarks.setText("");
                System.out.println("Data saved successfully.");
            } else {
                System.out.println("Error saving data.");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new LibraryGUI();
    }
}