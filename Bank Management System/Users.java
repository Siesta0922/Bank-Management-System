public class Users extends FullName {
    public String accountNumber;
    public FullName userFullName;
    public String birthDate;
    public String phoneNumber;
    public String address;
    public int accountType;
    public String username;
    public String password;
    public double balance;

    public Users() {
        this.accountNumber = ID_Generator.randomUserID();
        this.userFullName = new FullName();
        this.birthDate = "";
        this.phoneNumber = "";
        this.address = "";
        this.accountType = 0;
        this.username = "";
        this.password = "";
        this.balance = 0;
    }

    // Setters
    public void setUserID(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFullName(String fName, String mName, String lName) {
        this.userFullName.setFirstName(fName);
        this.userFullName.setMiddleName(mName);
        this.userFullName.setLastName(lName);
    }

    public void setBDay(String bDay) {
        this.birthDate = bDay;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(int type) {
        this.accountType = type;
    }

    public void setUsername(String uName) {
        this.username = uName;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    // Getters
    public String getUserID() {
        return this.accountNumber;
    }

    public String getFullName() {
        String temp = this.userFullName.getLastName() + ", " + this.userFullName.getFirstName() + " "
                + this.userFullName.getMiddleName();
        return temp;
    }

    public String getFirstName() {
        return this.userFullName.getFirstName();
    }

    public String getLastName() {
        return this.userFullName.getLastName();
    }

    public String getMiddleName() {
        return this.userFullName.getMiddleName();
    }

    public String getBDay() {
        return this.birthDate;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    // Displays the account type
    public String displayType(int type) {
        String temp = "";
        if (type == 1) {
            temp = "Savings Account";
        } else if (type == 2) {
            temp = "Checking Account";
        }
        return temp;
    }
}