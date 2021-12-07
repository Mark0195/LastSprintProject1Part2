package HttpRequest;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HttpClientSearch extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField animal;
    private JTextField common_name;
    private JButton btnNewButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HttpClientSearch frame = new HttpClientSearch();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public HttpClientSearch() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Search Database");
        lblNewUserRegister.setFont(new Font("Roboto", Font.PLAIN, 30));
        lblNewUserRegister.setBounds(362, 50, 450, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblEmailAddress = new JLabel("Animal");
        lblEmailAddress.setFont(new Font("Roboto", Font.PLAIN, 20));
        lblEmailAddress.setBounds(65, 245, 180, 36);
        contentPane.add(lblEmailAddress);

        animal = new JTextField();
        animal.setFont(new Font("Roboto", Font.PLAIN, 32));
        animal.setBounds(214, 235, 228, 50);
        contentPane.add(animal);
        animal.setColumns(10);

        JLabel lblPassword = new JLabel("Common Name");
        lblPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 124, 36);
        contentPane.add(lblPassword);

        common_name = new JTextField();
        common_name.setFont(new Font("Roboto", Font.PLAIN, 32));
        common_name.setBounds(707, 235, 228, 50);
        contentPane.add(common_name);
        common_name.setColumns(10);

        btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
//                public void actionPerformed(ActionEvent e) {
//                    String emailId = email.getText();
//                    String password = passwordField.getText();
//                    String msg = "";
//                    msg += " \n";
//                    if ( != 10) {
//                        JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
//                    }
//
//                    try {
//                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "root");
//
//                        String query = "INSERT INTO account values('" +  "','" +  "','" +  "','" +
//                                password + "','" + emailId + "','" +  "')";
//
//                        Statement sta = connection.createStatement();
//                        int x = sta.executeUpdate(query);
//                        if (x == 0) {
//                            JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
//                        } else {
//                            JOptionPane.showMessageDialog(btnNewButton,
//                                    "Welcome, " + msg + "Your account is sucessfully created");
//                        }
//                        connection.close();
//                    } catch (Exception exception) {
//                        exception.printStackTrace();
//                    }
//                }
//            });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
//        }
    }}