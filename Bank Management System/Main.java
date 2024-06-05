import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#,##0");

    static LinkedList<Users> users = new LinkedList<>();
    static Users customer;
    static Admin admin;

    public static void main(String[] args) {
        display();
        main();
    }

    public static void main() {

        while (true) {
            admin = CSVHandler.readAdminPass("admin.csv");
            users = CSVHandler.readUsersFromCSV("users.csv");
            System.out.println();
            displayMenu();

            try {
                System.out.println();
                System.out.println("=================================");
                System.out.print("Enter Choice: "); int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {

                    case 1:
                        login();
                        break;
                    case 2:
                        createAccount();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("=================================");
                        System.out.print("Enter Password: "); String adminPass = sc.nextLine(); // Default Password: admin123

                        if (adminCheck(adminPass)) {
                            adminMenu();
                        } else {
                            System.out.println("Incorrect Password.\n");
                        }
                        break;
                    case 4:
                        CSVHandler.writeUsersToCSV("users.csv", users);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-4.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next();
            }
        }
    }


    // Display Functions - displays the different menus and the corresponding options available

    public static void display() {
        System.out.println("\r\n" + //
                "██████╗░░█████╗░███╗░░██╗░█████╗░░█████╗░   ██████╗░███████╗   ░█████╗░██████╗░░█████╗░░█████╗░░█████╗░███╗░░██╗\r\n" + //
                "██╔══██╗██╔══██╗████╗░██║██╔══██╗██╔══██╗   ██╔══██╗██╔════╝   ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗████╗░██║\r\n" + //
                "██████╦╝███████║██╔██╗██║██║░░╚═╝██║░░██║   ██║░░██║█████╗░░   ██║░░██║██████╔╝██║░░██║██║░░╚═╝███████║██╔██╗██║\r\n" + //
                "██╔══██╗██╔══██║██║╚████║██║░░██╗██║░░██║   ██║░░██║██╔══╝░░   ██║░░██║██╔══██╗██║░░██║██║░░██╗██╔══██║██║╚████║\r\n" + //
                "██████╦╝██║░░██║██║░╚███║╚█████╔╝╚█████╔╝   ██████╔╝███████╗   ╚█████╔╝██║░░██║╚█████╔╝╚█████╔╝██║░░██║██║░╚███║\r\n" + //
                "╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝░╚════╝░░╚════╝░   ╚═════╝░╚══════╝   ░╚════╝░╚═╝░░╚═╝░╚════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░╚══╝");
    }

    public static void displayMenu() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║       Bank Main Menu       ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Login                   ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Create New Account      ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 3. Admin                   ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 4. Exit                    ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void createAccountMenu() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║       Create Account       ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void typeOfAccount() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║     Choose Account Type    ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Savings Account         ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Checking Account        ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void accountSummaryDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║       Account Summary      ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void adminMenuDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║           Admin            ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Search                  ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Display All Accounts    ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 3. Manage Accounts         ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 4. Change Admin Password   ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 5. Return To Main Menu     ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void manageMenuDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║       Manage Accounts      ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Delete An Account       ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Delete All Accounts     ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 3. Back                    ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void searchMenuDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║       Search Options       ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Account Number          ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Last Name               ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 3. First Name              ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 4. Account Type            ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 5. Back                    ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void optionsDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║           Options          ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Deposit                 ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Withdraw                ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 3. View Account Details    ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 4. Logout                  ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void depositDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔═══════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║          Deposit          ║");
        System.out.println("\t\t\t\t\t\b\b\b╚═══════════════════════════╝");
    }

    public static void withdrawDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║          Withdraw          ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void accountDetailDisplay(Users user, String pass) {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║       Account Details      ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
        System.out.println("\t\t\t\t\t\b\b\bAccount Name: " + user.getFullName());
        System.out.println("\t\t\t\t\t\b\b\bUsername: " + user.getUsername());
        System.out.println("\t\t\t\t\t\b\b\bPassword: " + pass);
        System.out.println("\t\t\t\t\t\b\b\bBirth Date: " + displayBirthDate(user.getBDay()));
        System.out.println("\t\t\t\t\t\b\b\bPhone Number: " + user.getPhoneNumber());
        System.out.println("\t\t\t\t\t\b\b\bAddress: " + user.getAddress());
        System.out.println();
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║           Options          ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Edit Details            ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Back                    ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void editDetailsDisplay() {
        System.out.println("\t\t\t\t\t\b\b\b╔════════════════════════════╗");
        System.out.println("\t\t\t\t\t\b\b\b║            Edit            ║");
        System.out.println("\t\t\t\t\t\b\b\b╠════════════════════════════╣");
        System.out.println("\t\t\t\t\t\b\b\b║ 1. Account Name            ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 2. Username                ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 3. Password                ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 4. Birth Date              ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 5. Phone Number            ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 6. Address                 ║");
        System.out.println("\t\t\t\t\t\b\b\b║ 7. Back                    ║");
        System.out.println("\t\t\t\t\t\b\b\b╚════════════════════════════╝");
    }

    public static void passwordRequirementsDisplay(){
        System.out.println("\b\b\b  ╔════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("\b\b\b  ║              Passwords must be at least 7 characters long and include at least 2 digits,               ║");
        System.out.println("\b\b\b  ║                    2 uppercase letters, 2 lowercase letters, and 1 special character                   ║");
        System.out.println("\b\b\b  ╚════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }


    // Menu Functions - handles the menu logic

    public static void userMenu(Users activeUser, String pass) {
        System.out.println();
        optionsDisplay();
        System.out.println("\t\t\t\t\t\b\b\bWelcome, " + activeUser.getUsername() + "!");
        while (true) {
            System.out.println();
            System.out.println("=================================");
            printUserDetails(activeUser);
            System.out.println();

            try {
                System.out.print("Enter Choice: "); int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {

                    case 1:
                        deposit(activeUser);
                        break;
                    case 2:
                        withdraw(activeUser);
                        break;
                    case 3:
                        System.out.println();
                        detailsMenu(activeUser, pass);
                    case 4:
                        main();
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-3.\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next();
            }
        }
    }
    
    public static void detailsMenu(Users user, String pass) {
        while (true) {
            accountDetailDisplay(user, pass);
            System.out.println();
            System.out.println("=================================");

            try {
                System.out.print("Enter Choice: "); int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.println();
                        editMenu(user, pass);
                        break;
                    case 2:
                        userMenu(user, pass);
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-2.\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next();
            }
        }
    }

    public static void editMenu(Users user, String pass) {
        while (true) {
            editDetailsDisplay();
            System.out.println();
            System.out.println("=================================");

            try {
                System.out.print("Enter Choice: "); int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {

                    case 1:
                        editDetails(user, "Name");
                        break;
                    case 2:
                        editDetails(user, "Username");
                        break;
                    case 3:
                        editDetails(user, "Password");
                        break;
                    case 4:
                        editDetails(user, "Birth Date");
                        break;
                    case 5:
                        editDetails(user, "Phone Number");
                        break;
                    case 6:
                        editDetails(user, "Address");
                        break;
                    case 7:
                        System.out.println();
                        detailsMenu(user, pass);
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-7.\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next();
            }
        }
    }
    
    public static void adminMenu() {
        while (true) {
            adminMenuDisplay();
            System.out.println();
            System.out.println("=================================");

            try {
                System.out.print("Enter Choice: "); int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.println();
                        searchMenu();
                        break;
                    case 2:
                        displayAll();
                        break;
                    case 3:
                        System.out.println();
                        manageMenu();
                        break;
                    case 4:
                        changeAdminPass();
                        break;
                    case 5:
                        main();
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-5.\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next();
            }
        }
    }

    public static void searchMenu() {
        while (true) {
            searchMenuDisplay();
            System.out.println();
            System.out.println("=================================");

            try {
                System.out.print("Enter Choice: "); int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {

                    case 1:
                        searchAccount(1);
                        break;
                    case 2:
                        searchAccount(2);
                        break;
                    case 3:
                        searchAccount(3);
                        break;
                    case 4:
                        searchAccount(4);
                        break;
                    case 5:
                        System.out.println();
                        adminMenu();
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-5.\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next();
            }
        }
    }

    public static void manageMenu() {
        while (true) {
            manageMenuDisplay();
            System.out.println();
            System.out.println("=================================");

            try {
                System.out.print("Enter Choice: "); int choice = sc.nextInt(); sc.nextLine();

                switch (choice) {

                    case 1:
                        deleteAccount();
                        break;
                    case 2:
                        deleteAllAccounts();
                        break;
                    case 3:
                        System.out.println();
                        adminMenu();
                        break;
                    default:
                        System.out.println("\nInvalid Choice. Enter a number from 1-3.\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Choice. Enter a number.\n");
                sc.next();
            }
        }
    }


    // Program Functions - functions that handle the program's logic

    // Handles user login, checks if a username exists or not, also checks if a username and a password matches
    public static void login() {
        System.out.println();
        System.out.println("=================================");
        System.out.print("Enter Username : "); String username = sc.nextLine();

        if (Login.checkUsername(username)) {
            System.out.print("Enter Password : "); String password = sc.nextLine();

            if (Login.checkPassword(username, PassHasher.encryptPass(password))) {
                Users accessedUser = accessUserAccount(username);
                userMenu(accessedUser, password);
            }
            else {
                System.out.println("Incorrect Password.");
            }
        }
        else {
            System.out.println("User With This Username Does Not Exist.");
        }
    }

    // Handles user creation
    public static void createAccount() {
        customer = new Users();
        int type = 0;
        double deposit = 0;
        boolean insufficient = true;
        System.out.println();
        createAccountMenu();

        // Gets user input
        System.out.println();
        System.out.println("=================================");
        System.out.println("Please complete the following\n");
        System.out.print("Enter First Name: "); String firstName = getStringInput("First Name");
        System.out.print("Enter Middle Name: "); String middleName = getStringInput("Middle Name");
        System.out.print("Enter Last Name: "); String lastName = getStringInput("Last Name");
        System.out.print("Enter Birth Date (DD/MM/YYYY): "); String birthDate = getBirthDate("Birth Date");
        System.out.print("Enter Phone Number (09********): "); String phoneNumber = getPhoneNumber("Phone Number");
        System.out.print("Enter Address: "); String address = sc.nextLine();
        System.out.println();

        while (true) {
            System.out.print("Create A Username: "); String username = sc.nextLine();

            if (!Login.checkUsername(username)) {
                customer.setUsername(username);
                break;
            } else {
                System.out.println("Username Already Exist.\n");
            }
        }

        String pass = getPassword();

        typeOfAccount();
        System.out.println("Minimum Initial Deposit:");
        System.out.println("Savings: 3,000\nChecking: 10,000\n");
                
        while (true) {
            System.out.print("Choose Account Type (1-2): "); String check = sc.nextLine();
            if (check.equals("1") || check.equals("2")) {
                type = Integer.parseInt(check);
                break;
            } else {
                System.out.println("Invalid Input. Please Try Again.\n");
            }
        }

        while (minimumCheck(deposit, type)) {
            insufficient = true;
            try {
                System.out.print("\nInput Initial Deposit: "); deposit = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid Input. Enter Numbers Only.");
                sc.next();
                insufficient = false;
            }

            if (!minimumCheck(deposit, type)) {
                break;
            } else if (insufficient) {
                System.out.println("Insufficient Amount. Please Try Again.");
            }
        }

        // Passes acquired input to the customer object
        customer.setFullName(firstName, middleName, lastName);
        customer.setBDay(birthDate);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setPassword(PassHasher.encryptPass(pass));
        customer.setAccountType(type);
        customer.setBalance(deposit);

        // Adds customer object to the users LinkedList
        users.add(customer);
        CSVHandler.writeUsersToCSV("users.csv", users);
        System.out.println("\nAccount Successfully Created!");
        System.out.println();

        accountSummaryDisplay();

        // Displays the information of the newly created account
        for (Users temp : users) {
            if (customer.getUserID().equals(temp.getUserID())) {
                System.out.println();
                System.out.println("\t\t\t\t\t\b\b\bAccount Number: " + temp.getUserID());
                System.out.println("\t\t\t\t\t\b\b\bAccount Name: " + temp.getFullName());
                System.out.println("\t\t\t\t\t\b\b\bUsername: " + temp.getUsername());
                System.out.println("\t\t\t\t\t\b\b\bPassword: " + pass);
                System.out.println("\t\t\t\t\t\b\b\bBirth Date: " + displayBirthDate(temp.getBDay()));
                System.out.println("\t\t\t\t\t\b\b\bPhone Number: " + temp.getPhoneNumber());
                System.out.println("\t\t\t\t\t\b\b\bAddress: " + temp.getAddress());
                System.out.println("\t\t\t\t\t\b\b\bAccount Type: " + temp.displayType(temp.getAccountType()));
                System.out.println("\t\t\t\t\t\b\b\bCurrent Balance: " + df.format(temp.getBalance()));
                System.out.println();
            }
        }
    }

    // Checks if a user's initial minimum deposit meets the required amount for the chosen account type
    public static boolean minimumCheck(double deposit, int type) {
        if (type == 1) {
            if (deposit >= 3000) {
                return false;
            }
        } else if (type == 2) {
            if (deposit >= 10000) {
                return false;
            }
        }
        return true;
    }

    // Checks if the input matches the admin password
    public static boolean adminCheck(String pass) {
        if (pass.equals(admin.getPass())) {
            System.out.println("Logged In!\n");
            return true;
        }

        return false;
    }

    // Handles the account searching function
    public static void searchAccount(int option) {
        boolean found = false;
        System.out.println();

        if (option == 1) {
            System.out.print("Enter Account Number: "); String accountNumber = sc.nextLine();

            for (Users temp : users) {
                if (accountNumber.equals(temp.getUserID())) {
                    printAccountDetails(temp);
                    found = true;
                    break;
                }
            }
        } else if (option == 2) {
            System.out.print("Enter Last Name: "); String lastName = sc.nextLine();

            for (Users temp : users) {
                if (lastName.toLowerCase().equals(temp.getLastName().toLowerCase())) {
                    printAccountDetails(temp);
                    found = true;
                    break;
                }
            }
        } else if (option == 3) {
            System.out.print("Enter First Name: "); String firstName = sc.nextLine();
            for (Users temp : users) {
                if (firstName.toLowerCase().equals(temp.getFirstName().toLowerCase())) {
                    printAccountDetails(temp);
                    found = true;
                    break;
                }
            }
        } else if (option == 4) {
            int type = 0;
            typeOfAccount();
            System.out.println();

            while (true) {
                System.out.print("Choose Account Type (1-2): "); String check = sc.nextLine();
                if (check.equals("1") || check.equals("2")) {
                    type = Integer.parseInt(check);
                    break;
                } else {
                    System.out.println("Invalid Input. Please Try Again.\n");
                }
            }

            for (Users temp : users) {
                if (type == temp.getAccountType()) {
                    printAccountDetails(temp);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("No Accounts Found.\n");
        }
    }

    // Function to display all users
    public static void displayAll() {
        for (Users temp : users) {
            printAccountDetails(temp);
        }

        if (users.isEmpty()) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("No Accounts Found.\n");
        }
    }

    // Function to change the admin's password
    public static void changeAdminPass() {
        System.out.println("\nChange Admin Password:");
        while (true) {
            System.out.println();
            System.out.print("Enter Current Password: "); String confirm = sc.nextLine();

            if (admin.getPass().equals(confirm)) {
                break;
            } else {
                System.out.println("Incorrect. Please Try Again.");
            }
        }

        System.out.println();
        System.out.print("Enter New Password: "); String pass = sc.nextLine();

        while (true) {
            System.out.print("Re-Enter New Password: "); String pass2 = sc.nextLine();

            if (pass.equals(pass2)) {
                System.out.println("\nPassword Changed!");
                break;
            } else {
                System.out.println("\nPasswords do not match. Please Try Again");
            }
        }
        admin.setPass(pass);
        CSVHandler.writeAdminPass("admin.csv", admin);
    }

    // Function to delete an individual account using an its account number
    public static void deleteAccount() {
        boolean found = false;
        System.out.print("Enter Account Number Of The Account To Delete: "); String accountNumber = sc.nextLine();

        for (int i = 0; i < users.size(); i++) {
            Users temp = users.get(i);
            if (temp.getUserID().equals(accountNumber)) {
                users.remove(i);
                System.out.println("Account Deleted.");
                System.out.println();
                CSVHandler.writeUsersToCSV("users.csv", users);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No Account Found with the given account number.");
            System.out.println();
        }
    }

    // Function to delete all user accounts
    public static void deleteAllAccounts() {
        while (true) {
            System.out.print("Enter Admin Password: "); String confirm = sc.nextLine();

            if (admin.getPass().equals(confirm)) {
                break;
            } else {
                System.out.println("Incorrect. Please Try Again.\n");
                System.out.println();
                manageMenu();
            }
        }

        while (true) {
            System.out.print("Are You Sure You Want To Delete All Accounts? Answer [Y/N] : "); String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                System.out.println();
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println();
                manageMenu();
            } else {
                System.out.println("Invalid Input. Please Try Again.\n");
            }
        }

        users.clear();
        System.out.println("\nAll Existing Accounts Deleted.");
        System.out.println();
        CSVHandler.writeUsersToCSV("users.csv", users);
    }

    // Displays account details for the admin
    public static void printAccountDetails(Users user) {
        System.out.println();
        System.out.println("=================================");
        System.out.println("Account Number: " + user.getUserID());
        System.out.println("Account Name: " + user.getFullName());
        System.out.println("Birth Date: " + displayBirthDate(user.getBDay()));
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Account Type: " + user.displayType(user.getAccountType()));
        System.out.println("Current Balance: " + df.format(user.getBalance()));
    }
    
    // Displays account details for the user menu
    public static void printUserDetails(Users user) {
        System.out.println("Account Number: " + user.getUserID());
        System.out.println("Account Name: " + user.getFullName());
        System.out.println("Account Type: " + user.displayType(user.getAccountType()));
        System.out.println("Current Balance: " + df.format(user.getBalance()));
    }

    // Iterates through the list of users if a login is successful to find the matching username and returns that user
    public static Users accessUserAccount(String username) {
        Users accessedUser = null;
        for (int i = 0; i < users.size(); i++) {
            Users user = users.get(i);

            if (user.getUsername().equals(username)) {
                accessedUser = user;
                break;
            }
        }
        return accessedUser;
    }

    // Handles user deposits
    public static void deposit(Users user) {
        double amount = 0;
        System.out.println();
        depositDisplay();
        System.out.println();

        while (true) {
            try {
                System.out.print("Enter Amount: "); amount = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input. Enter Numbers Only.\n");
                sc.next();
            }
        }
        
        double temp = user.getBalance() + amount;
        user.setBalance(temp);
        System.out.println("Success!");
        System.out.println();
        CSVHandler.writeUsersToCSV("users.csv", users);
        optionsDisplay();
    }

    // Handles user withdrawals
    public static void withdraw(Users user) {
        double amount = 0;
        System.out.println();
        withdrawDisplay();
        System.out.println();
        
        while (true) {
            while (true) {
                try {
                    System.out.print("Enter Amount: "); amount = sc.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Input. Enter Numbers Only.\n");
                    sc.next();
                }
            }

            if (amount > user.getBalance()) {
                System.out.println("Withdrawal Amount Cannot Exceed Current Balance. Please Try Again.\n");
            } else {
                double temp = user.getBalance() - amount;
                user.setBalance(temp);
                System.out.println("Success!");
                System.out.println();
                CSVHandler.writeUsersToCSV("users.csv", users);
                optionsDisplay();
                break;
            }
        }
    }

    // Checks if user input only consists of alphabetical characters
    public static String getStringInput(String requirement) {
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            } else {
                System.out.println("Invalid Input. Please Enter Only Alphabetical Characters.\n");
                System.out.print("Enter " + requirement + ": ");
            }
        }
    }

    // Checks if user input consists only of numerical digits and is 11 digits long
    public static String getPhoneNumber(String requirement) {
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.matches("[0-9]+") && input.length() == 11) {
                return input;
            } else if (!input.matches("[0-9]+")) {
                System.out.println("Invalid Input. Please Enter Only Numerical Digits.\n");
                System.out.print("Enter " + requirement + ": ");
            }  else if (input.length() != 11) {
                System.out.println("Invalid Input. Please Enter Exactly 11 Numbers.\n");
                System.out.print("Enter " + requirement + ": ");
            }
        }
    }

    // Checks if user input consists only of numerical digits and is 8 digits long
    public static String getBirthDate(String requirement) {
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.matches("[0-9]+") && input.length() == 8) {
                return input;
            } else if (!input.matches("[0-9]+")) {
                System.out.println("Invalid Input. Please Enter Only Numerical Digits.\n");
                System.out.print("Enter " + requirement + " (DD/MM/YYYY): ");
            }  else if (input.length() != 8) {
                System.out.println("Invalid Input. Please Enter Exactly 8 Numbers\n");
                System.out.print("Enter " + requirement + " (DD/MM/YYYY): ");
            }
        }
    }

    // Handles password creation for the users, checks if a password meets the requirements
    public static String getPassword() {

		char [] specialCharacters = {'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'};

		while (true){

            boolean hasSpecial = false;
            boolean length = false;
            int upperCase = 0;
            int lowerCase = 0;
            int digit = 0;

            System.out.println();
            passwordRequirementsDisplay();

			System.out.print("\nEnter Your Password: ");
			String password = sc.nextLine();
			char [] passwordChar = password.toCharArray();

			for (int i : passwordChar){

			if (Character.isUpperCase(i)){
				upperCase++;
			} else if (Character.isLowerCase(i)){
				lowerCase++;
			} if (Character.isDigit(i)){
				digit++;
			}

			if (password.length() > 6){
				length = true;
			}

			for (int j : specialCharacters){
				if(j == i){
					hasSpecial = true;
					}
				}
			}
            
			if (upperCase >= 2 && lowerCase >= 2 && digit >= 2 && length && hasSpecial) {
				System.out.print("Re-enter Your password: ");
				String finalPassword = sc.nextLine();

				if (password.equals(finalPassword)){
					System.out.print("Password Successfully Created!\n");
                    return finalPassword;
				} else {
					System.out.print("\nPassword Do Not Match. Please Try Again.\n");
				}
			} else {
				System.out.print("\nPlease Enter A Valid Password.\n");
		    }
	    }
    }

    // Returns the birth date in the format: DD/MM/YYYY
    public static String displayBirthDate(String birth) {
        StringBuilder birthday = new StringBuilder();
    
        for (int i = 0; i < 8; i++) {
            if (i == 2 || i == 4) {
                birthday.append("/");
            }
            birthday.append(birth.charAt(i));
        }
    
        return birthday.toString();
    }

    // Function in handling the editing of a user's details
    public static void editDetails(Users user, String option) {
        System.out.println();
        
        if (option.equals("Name")) {
            System.out.println("=================================");
            System.out.println("Please complete the following\n");
            System.out.print("Enter First Name: "); String firstName = getStringInput("First Name");
            System.out.print("Enter Middle Name: "); String middleName = getStringInput("Middle Name");
            System.out.print("Enter Last Name: "); String lastName = getStringInput("Last Name");
            user.setFullName(firstName, middleName, lastName);
            System.out.println(option + " Changed Successfully!");
        } else if (option.equals("Username")) {
            while (true) {
                System.out.print("Create A Username: "); String username = sc.nextLine();
    
                if (!Login.checkUsername(username)) {
                    user.setUsername(username);
                    break;
                } else {
                    System.out.println("Username Already Exist.\n");
                }
            }
            System.out.println(option + " Changed Successfully!");
        } else if (option.equals("Password")) {
            String pass = getPassword();
            user.setPassword(PassHasher.encryptPass(pass));
            System.out.println(option + " Changed Successfully!");
            CSVHandler.writeUsersToCSV("users.csv", users);
            editMenu(user, pass);
            System.out.println();
        } else if (option.equals("Birth Date")) {
            System.out.print("Enter Birth Date (DD/MM/YYYY): "); String birthDate = getBirthDate("Birth Date");
            user.setBDay(birthDate);
            System.out.println(option + " Changed Successfully!");
        } else if (option.equals("Phone Number")) {
            System.out.print("Enter Phone Number (09********): "); String phoneNumber = getPhoneNumber("Phone Number");
            user.setPhoneNumber(phoneNumber);
            System.out.println(option + " Changed Successfully!");
        } else if (option.equals("Address")) {
            System.out.print("Enter Address: "); String address = sc.nextLine();
            user.setAddress(address);
            System.out.println(option + " Changed Successfully!");
        }

        System.out.println();
        CSVHandler.writeUsersToCSV("users.csv", users);
    }
}