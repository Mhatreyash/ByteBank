public class Account {
    private final String accountNumber;
    private final String userId;
    private final String pin;
    private double balance;

    public Account(String accountNumber, String userId, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean validatePin(String pinToValidate) {
        return this.pin.equals(pinToValidate);
    }

    // Synchronized methods are thread-safe, important for banking apps
    public synchronized void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public synchronized void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance for this withdrawal.");
        }
        balance -= amount;
    }
}