
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDemo extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message,newUser_label, newPassword_label, newMessage;
    JTextField userName_text,newUserName_text;
    JPasswordField password_text,newPassword_text;
    JButton submit,newSubmit, cancel;

    LoginDemo() {
        
        // User Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        newUser_label = new JLabel();
        newUser_label.setText("New User :");
        newUserName_text = new JTextField();
        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        newPassword_label = new JLabel();
        newPassword_label.setText("Password :");
        newPassword_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");
        newSubmit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(6, 1));
       
        panel.add(user_label); 
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);

        panel.add(newUser_label); 
        panel.add(newUserName_text);
        panel.add(newPassword_label);
        panel.add(newPassword_text);

        newMessage = new JLabel();
        panel.add(newMessage);
        panel.add(newSubmit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        newSubmit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(300, 300);
        
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginDemo();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        String newUserName = newUserName_text.getText();
        String newPassword = newPassword_text.getText();
        if (userName.trim().equals("chinu") && password.trim().equals("123456")) {
            message.setText(" Hello " + userName
                    + "");
        } else {
            message.setText(" Invalid user.. ");
        }
        if (newUserName.trim()=="" && newPassword.trim()=="") {
            message.setText(" Invalid Input.. ");
        } else {
            message.setText(" Hello"  + newUserName );
        }

    }

}