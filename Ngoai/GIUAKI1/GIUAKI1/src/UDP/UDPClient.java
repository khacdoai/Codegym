package UDP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

public class UDPClient {
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static int loginAttempts = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

 
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                performLogin(username, password);
            }
        });

        frame.setVisible(true);
    }

    private static void performLogin(String username, String password) {
        DatagramSocket socket = null;
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8888;
            socket = new DatagramSocket();

            String message = username + "," + password;
            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            JOptionPane.showMessageDialog(null, "Server response: " + response);

            if (response.equals("OK")) {
                JOptionPane.showMessageDialog(null, "Login successful!");
            } else {
                loginAttempts++;
                if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                    JOptionPane.showMessageDialog(null, "Login failed. Maximum login attempts reached.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}