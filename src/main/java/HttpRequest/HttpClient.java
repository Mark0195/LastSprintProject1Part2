package HttpRequest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HttpClient extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label, signup_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, signup;
    HttpClient() {
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // SignUp Label
        signup = new JButton("SignUp Here!");
        signup_label = new JLabel();
        signup_label.setText("Create Account ");
        // Submit
        submit = new JButton("Login");
        panel = new JPanel(new GridLayout(4, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        panel.add(signup_label);
        panel.add(signup);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here!");
        setSize(450,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new HttpClient();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            message.setText(" Hello " + userName + "");
        } else {
            message.setText(" Invalid user.. ");
        }

    }

    {Frame1 obj1=new Frame1();}
}

class Frame1 extends JFrame implements ActionListener
{
    JButton b=new JButton("New Frame");

    public Frame1()
    {
        setVisible(true);
        setSize(250,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(b);

        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        Frame2 obj2=new Frame2();
        //dispose();
    }
}


class Frame2 extends JFrame
{
    public Frame2()
    {
        setVisible(true);
        setSize(250,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel l1=new JLabel("Welcome To New Frame");
        add(l1);
    }
}