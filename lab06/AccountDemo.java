abstract class Account {
    private final String id;
    protected double balance;

    Account(String id, double openingBalance) {
        this.id = id;
        this.balance = openingBalance;
    }

    // concrete: shared by all accounts
    void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    // abstract: each account type has its own fee rule
    abstract double monthlyFee();

    void applyMonthlyFee() { balance -= monthlyFee(); }

    String getId()      { return id; }
    double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    SavingsAccount(String id, double opening) { super(id, opening); }
    @Override double monthlyFee() { return 2.00; }         // flat fee
}

class CurrentAccount extends Account {
    CurrentAccount(String id, double opening) { super(id, opening); }
    @Override double monthlyFee() { return balance < 1000 ? 15.00 : 5.00; }   // depends on balance
}

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("S-1", 500),
            new CurrentAccount("C-1", 800),
            new CurrentAccount("C-2", 5000)
        };

        for (Account a : accounts) {
            a.deposit(100);
            a.applyMonthlyFee();
            System.out.printf("%s balance after fee: %.2f%n", a.getId(), a.getBalance());
        }
    }
}
