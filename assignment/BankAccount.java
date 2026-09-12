import java.util.ArrayList;
import java.util.List;

/**
 * GreenLeaf Bank - refactored BankAccount class.
 *
 * Reasons to change in the old class:
 * 1. Changes if deposit or withdrawal rules change.
 * 2. Changes if database saving changes.
 * 3. Changes if email or notification messages change.
 * 4. Changes if statement formatting changes.
 * 5. Changes if interest calculation rules change.
 * 6. Changes if account PIN/security rules change.
 *
 * Job: BankAccount should only manage account state and account operations
 * like deposit, withdraw, and balance.
 */
public class BankAccount {

    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType; // "Savings" or "Current"
    private List<String> transactionLog = new ArrayList<>();

    public BankAccount(int accountNumber, String name, int age, double balance, String accountType) {
        if (age < 18) {
            System.out.println("Age was below 18, correcting to 18");
            age = 18;
        }

        double minimumBalance = accountType.equals("Savings") ? 500.0 : 1000.0;
        if (balance < minimumBalance) {
            System.out.println("Initial balance below minimum, correcting to " + minimumBalance);
            balance = minimumBalance;
        }

        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.accountType = accountType;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return false;
        }

        balance += amount;
        transactionLog.add("DEPOSIT: Rs. " + amount + " | New balance: " + balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return false;
        }

        double minimumBalance = accountType.equals("Savings") ? 500.0 : 1000.0;
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal would breach minimum balance");
            return false;
        }

        balance -= amount;
        transactionLog.add("WITHDRAW: Rs. " + amount + " | New balance: " + balance);
        return true;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public List<String> getTransactionLog() { return transactionLog; }
}
