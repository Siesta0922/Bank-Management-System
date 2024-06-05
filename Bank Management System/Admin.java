public class Admin {
    private String password;

    public Admin(String pass) {
        password = pass;
    }
    
    // Setters
    public void setPass(String pass) {
        this.password = pass;
    }

    // Getters
    public String getPass() {
        return this.password;
    }
}