import java.util.*;

public class Login {
    // Method to create a HashMap of usernames and passwords from a list of Users
    public static HashMap<String, String> createUserPassList(LinkedList<Users> users) {
        HashMap<String, String> accounts = new HashMap<String, String>();
        for (Users user : users) {
            accounts.put(user.getUsername(), user.getPassword());
        }
        return accounts;
    }

    // Method to check if a username exists in the user-password HashMap
    public static Boolean checkUsername(String username) {
        // Get the user-password HashMap from the CSV file
        HashMap<String, String> accounts = createUserPassList(CSVHandler.readUsersFromCSV("users.csv"));

        String key = accounts.get(username);
        if (key != null)
            return true;
        else
            return false;
    }

    // Method to check if a given password matches the password associated with a username
    public static Boolean checkPassword(String username, String password) {
        // Get the user-password HashMap from the CSV file
        HashMap<String, String> accounts = createUserPassList(CSVHandler.readUsersFromCSV("users.csv"));

        String key = accounts.get(username);
        if (key != null && key.equals(password))
            return true;
        else
            return false;
    }
}