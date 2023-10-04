package UDP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateUserDataFile {
    private static final String USER_DATA_FILE = "user_data.txt";

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DATA_FILE))) {
            // Sample user data: username, password
            String[] users = {
                    "hoahin,hoa123",
                    "hoahin,hoa234",
                    "hoa2,hoa567"
            };

            // Write user data to the file
            for (String user : users) {
                writer.write(user);
                writer.newLine();  // Add a new line for each user
            }

            System.out.println("User data file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}