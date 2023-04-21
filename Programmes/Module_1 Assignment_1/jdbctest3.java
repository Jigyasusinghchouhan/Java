import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class jdbctest3 extends Frame implements ActionListener {
    private Label lblName;
    private Label lblRollNo;
    private TextField txtName;
    private TextField txtRollNo;
    private Button btnSubmit;
    private Button btnReset;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    public jdbctest3() {
        lblName = new Label("Name:");
        lblRollNo = new Label("Roll No:");
        txtName = new TextField(20);
        txtRollNo = new TextField(20);
        btnSubmit = new Button("Submit");
        btnReset = new Button("Reset");
        setLayout(new FlowLayout());
        add(lblName);
        add(txtName);
        add(lblRollNo);
        add(txtRollNo);
        add(btnSubmit);
        add(btnReset);
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        setTitle("JDBC Example");
        setSize(250, 150);
        setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root",
"mysql");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            try {
                String name = txtName.getText();
                int rollNo = Integer.parseInt(txtRollNo.getText());
                String sql = "INSERT INTO student (name, roll_no) VALUES ('" +
name + "', '" + rollNo + "')";
                stmt.executeUpdate(sql);
                System.out.println("Record inserted successfully");
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }
        } else {
            txtName.setText("");
            txtRollNo.setText("");
        }
    }
    public static void main(String[] args) {
        jdbctest3 example = new jdbctest3();
    }
}