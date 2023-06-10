interface BookingSystem {
    void showMovie();
    void orderTicket();
    void viewProfile();
}

public class User implements BookingSystem {
    private String userId;
    private String userName;
    private double balance;

    public User(String userId, String userName, double balance) {
        this.userId = userId;
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void editName(String newName) {
        this.userName = newName;
        System.out.println("Name updated successfully.");
    }

    public void editBalance(double amount) {
        this.balance += amount;
        System.out.println("Balance updated successfully.");
    }

    @Override
    public void showMovie() {
        // Implementasi metode showMovie
        System.out.println("Showing available movies...");
    }

    @Override
    public void orderTicket() {
        // Implementasi metode orderTicket
        System.out.println("Ordering ticket...");
    }

    @Override
    public void viewProfile() {
        // Implementasi metode viewProfile
        System.out.println("User Profile:");
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + userName);
        System.out.println("Balance: $" + balance);
    }
}