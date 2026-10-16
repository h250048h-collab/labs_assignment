import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0)
            throw new IllegalArgumentException("Opening balance cannot be negative");
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add("OPEN: " + openingBalance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank())
            throw new IllegalArgumentException("Owner name required");
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        history.add("DEPOSIT: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) {
            history.add("FAILED WITHDRAWAL: " + amount);
            return false;
        }
        balance -= amount;
        history.add("WITHDRAW: " + amount);
        return true;
    }

    // Defensive copy, then wrap read-only
    public List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500);
        acc.deposit(250);
        acc.withdraw(100);
        acc.withdraw(9999);

        for (String line : acc.getHistory()) System.out.println(line);

        try {
            acc.getHistory().add("HACK: +1000000");
        } catch (UnsupportedOperationException e) {
            System.out.println("History is read-only");
        }
    }
}
