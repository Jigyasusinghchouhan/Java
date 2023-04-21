import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class jdbctest4 extends Frame implements ActionListener {
    private TextField tfName = new TextField();
    private TextField tfRollNo = new TextField();
    private TextField tfMarks = new TextField();
    private Button btnSave = new Button("Save");
    public jdbctest4() {
        setLayout(new FlowLayout());
        add(new Label("Name:"));
        add(tfName);
        add(new Label("Roll No:"));
        add(tfRollNo);
        add(new Label("Marks:"));
        add(tfMarks);
        add(btnSave);
        btnSave.addActionListener(this);
        setSize(400, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSave) {
            try {
                // Load the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Connect to the database
                Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root","mysql");
                PreparedStatement pstmt = conn
                        .prepareStatement("INSERT INTO Students (name, rollno,marks) VALUES (?, ?, ?)");
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
    }
    public static void main(String[] args) {
        new jdbctest4();
    }
}