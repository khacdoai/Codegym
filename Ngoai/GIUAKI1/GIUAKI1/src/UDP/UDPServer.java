package UDP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.*;

public class UDPServer {
    private static final String USER_DATA_FILE = "user_data.txt";

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            int serverPort = 8888;
            socket = new DatagramSocket(serverPort);
            byte[] receiveData = new byte[1024];

            System.out.println("Server is ready to receive messages.");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                String[] parts = message.split(",");
                String username = parts[0];
                String password = parts[1];

                String response = checkLogin(username, password) ? "OK" : "FAILURE";

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    private static boolean checkLogin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;  // User found, login successful
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;  // User not found, login failed
    }
}

