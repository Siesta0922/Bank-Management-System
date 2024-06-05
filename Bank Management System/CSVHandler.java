import java.io.*;
import java.util.*;

public class CSVHandler {
    static Admin admin;

    // Method to read users from a CSV file and return a list of Users
    public static LinkedList<Users> readUsersFromCSV(String filename) {
        LinkedList<Users> users = new LinkedList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            // Read each line from the CSV file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split the line into fields using comma as delimiter
                String[] fields = line.split(",");

                // Extracting individual fields from the array
                String accountNumber = fields[0];
                String firstName = fields[1];
                String middleName = fields[2];
                String lastName = fields[3];
                String birthDate = fields[4];
                String phoneNumber = fields[5];
                String address = fields[6];
                String username = fields[7];
                String password = fields[8];
                int accountType = Integer.parseInt(fields[9]);
                double initialBalance = Double.parseDouble(fields[10]);

                // Create a new Users object and set its properties
                Users user = new Users();
                user.setUserID(accountNumber);
                user.setFullName(firstName, middleName, lastName);
                user.setBDay(birthDate);
                user.setPhoneNumber(phoneNumber);
                user.setAddress(address);
                user.setAccountType(accountType);
                user.setUsername(username);
                user.setPassword(password);
                user.setBalance(initialBalance);

                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + filename);
        }

        return users;
    }

    // Method to write users to a CSV file
    public static void writeUsersToCSV(String filename, LinkedList<Users> users) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            // Iterate over each user and write their information to the CSV file
            for (Users user : users) {
                String line = userToCSVLine(user);
                writer.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to CSV file: " + filename);
        }
    }

    // Method to convert a User object to a CSV formatted line
    private static String userToCSVLine(Users user) {
        return user.getUserID() + "," + user.getFirstName() + "," + user.getMiddleName() + "," + user.getLastName()
                + "," + user.getBDay() + "," + user.getPhoneNumber() + ","
                + user.getAddress() + ","
                + user.getUsername() + "," + user.getPassword() + "," + user.getAccountType() + "," + user.getBalance();
    }

    // Method to read the currently set admin password
    public static Admin readAdminPass(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            String pass = scanner.nextLine();
            admin = new Admin(pass);        
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + filename);
        }

        return admin;
    }

    // Method to write the admin password to the Admin CSV file
    public static void writeAdminPass(String filename, Admin admin) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            writer.println(admin.getPass());
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to CSV file: " + filename);
        }
    }
}