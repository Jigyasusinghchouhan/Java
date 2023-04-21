import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeDetails extends JFrame {
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblAge;
    private JTextField txtAge;
    private JLabel lblDesignation;
    private JTextField txtDesignation;
    private JButton btnSave;

    public EmployeeDetails() {
        setTitle("Employee Details");
        setSize(300, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblName = new JLabel("Name: ");
        txtName = new JTextField(20);
        lblAge = new JLabel("Age: ");
        txtAge = new JTextField(3);
        lblDesignation = new JLabel("Designation: ");
        txtDesignation = new JTextField(20);
        btnSave = new JButton("Save");

        add(lblName);
        add(txtName);
        add(lblAge);
        add(txtAge);
        add(lblDesignation);
        add(txtDesignation);
        add(btnSave);

        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeDetails();
    }
}
