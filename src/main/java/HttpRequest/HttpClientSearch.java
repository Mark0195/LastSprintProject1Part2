package HttpRequest;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HttpClientSearch extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox database;
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
        lblPassword.setBounds(542, 245, 150, 36);
        contentPane.add(lblPassword);

        common_name = new JTextField();
        common_name.setFont(new Font("Roboto", Font.PLAIN, 32));
        common_name.setBounds(707, 235, 228, 50);
        contentPane.add(common_name);
        common_name.setColumns(10);

        database = new JComboBox();
        database.addItem("Choose a Database...");
        database.addItem("Postgres");
        database.addItem("MySql");
        database.addItem("Both");
        database.setBounds(400, 400, 200, 60);
        contentPane.add(database);

        btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String common_nameId = common_name.getText();
                String animalId = animal.getText();
                java.net.http.HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:/8080/animals/" + common_nameId))
                        .uri(URI.create("http://localhost:/8080/animals/" + animalId))
                        .header("Content-Type", "application/json")
                        .GET()
                        .build();
                try {
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        JOptionPane.showMessageDialog(btnNewButton, "No Animal found!");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                 common_nameId + " " + animalId);
                    }
                } catch (IOException | InterruptedException ea) {
                    ea.printStackTrace();
                }
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 475, 200, 40);
        contentPane.add(btnNewButton);
    }}