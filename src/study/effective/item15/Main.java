package study.effective.item15;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        System.out.println(account.getAccountInfo());

        account.deposit(500.0);
        System.out.println(account.getAccountInfo());

        account.withdraw(200.0);
        System.out.println(account.getAccountInfo());
    }
}

class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public String getAccountInfo() {
        return "Account owner: " + ownerName + ", Balance: $" + balance;
    }
}
