
import java.util.HashMap;
import java.util.Map;

public class Bank {
    // Maps User ID to an Account object
    private final Map<String, Account> accounts = new HashMap<>();

    public void addUser(String userId, String pin, double initialBalance) {
        String accountNumber = "ACC" + (accounts.size() + 1001);
        Account newAccount = new Account(accountNumber, userId, pin, initialBalance);
        accounts.put(userId, newAccount);
    }

    public Account authenticate(String userId, String pin) throws Exception {
        Account account = accounts.get(userId);
        if (account == null) {
            throw new Exception("User ID not found.");
        }
        if (!account.validatePin(pin)) {
            throw new Exception("Incorrect PIN.");
        }
        return account;
    }
    
    public Account findAccountByUserId(String userId) throws Exception {
        Account account = accounts.get(userId);
        if (account == null) {
            throw new Exception("Recipient user does not exist.");
        }
        return account;
    }
}