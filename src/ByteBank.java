import java.util.InputMismatchException;
import java.util.Scanner;

public class ByteBank {

    public static void main(String[] args) {
        // Initialize the bank with some dummy data
        Bank centralBank = new Bank();
        centralBank.addUser("user123", "1234", 1200.50);
        centralBank.addUser("user456", "5678", 350.75);

        // Start the ATM
        ATM atm = new ATM(centralBank);
        atm.start();
    }
}

class ATM {
    private final Bank bank;
    private Account currentUserAccount;
    private final Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to ByteBank!");
        while (true) {
            authenticateUser(); // Login loop
            if (currentUserAccount != null) {
                performTransactions(); // Transaction loop
            }
        }
    }

    private void authenticateUser() {
        while (currentUserAccount == null) {
            try {
                // 1. Updated prompt to inform the user of the new option
                System.out.print("\nEnter User ID (or type 'exit' to quit): ");
                String userId = scanner.next();

                // 2. The core logic for the new feature
                if (userId.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using ByteBank. Exiting.");
                    System.exit(0); // 3. Terminate the application
                }

                System.out.print("Enter PIN: ");
                String pin = scanner.next();
                currentUserAccount = bank.authenticate(userId, pin);
                System.out.println("\nLogin successful. Welcome!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Please try again.");
            }
        }
    }

    private void performTransactions() {
        boolean userExited = false;
        while (!userExited) {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: checkBalance(); break;
                    case 2: withdraw(); break;
                    case 3: deposit(); break;
                    case 4: transfer(); break;
                    case 5:
                        userExited = true;
                        currentUserAccount = null; // Log out the user
                        System.out.println("Thank you for using ByteBank. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nByteBank Menu:");
        System.out.println("1 - Check Balance");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Deposit");
        System.out.println("4 - Transfer");
        System.out.println("5 - Logout");
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", currentUserAccount.getBalance());
    }

    private void withdraw() {
        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            currentUserAccount.withdraw(amount);
            System.out.printf("Successfully withdrew $%.2f. Your new balance is $%.2f%n", amount, currentUserAccount.getBalance());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        } catch (Exception e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

    private void deposit() {
        try {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            currentUserAccount.deposit(amount);
             System.out.printf("Successfully deposited $%.2f. Your new balance is $%.2f%n", amount, currentUserAccount.getBalance());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        } catch (Exception e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }
    
    private void transfer() {
        try {
            System.out.print("Enter recipient's User ID: ");
            String targetUserId = scanner.next();
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            
            // In a real system, you'd transfer between accounts, but this simplifies it
            Account targetAccount = bank.findAccountByUserId(targetUserId);
            currentUserAccount.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.printf("Successfully transferred $%.2f to %s.%n", amount, targetUserId);
            checkBalance();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.next();
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }
}