package HttpRequest;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    public void actionPerformed(ActionEvent e) {
        String emailId = userName_text.getText();
        String passwordId = password_text.getText();
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:/8080/animals/passwordtable/" + emailId + "/" + passwordId))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JOptionPane.showMessageDialog(submit, "Username/Password Don't match");
            } else {
                JOptionPane.showMessageDialog(submit,
                        "Welcome, " + emailId);
            }
        } catch (IOException | InterruptedException ea) {
            ea.printStackTrace();
        }
    }
}

