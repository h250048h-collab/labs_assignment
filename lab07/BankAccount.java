public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0)
            throw new IllegalArgumentException("Opening balance cannot be negative");
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    // was: boolean withdraw(...) returning false; now the failure cannot be ignored
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Cannot withdraw " + amount + "; balance is " + balance, amount - balance);
        }
        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500);
        try {
            acc.withdraw(100);
            System.out.println("Balance: " + acc.getBalance());
            acc.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }
    }
}
