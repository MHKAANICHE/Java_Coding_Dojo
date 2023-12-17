import java.util.Random;

public class BankAccount {
    private static int numberOfAccounts = 0;
    private static double totalMoneyStored = 0;

    private double checkingBalance;
    private double savingsBalance;
    private final String accountNumber;

    public BankAccount() {
        numberOfAccounts++;
        accountNumber = generateAccountNumber();
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(double amount, String accountType) {
        if ("checking".equalsIgnoreCase(accountType)) {
            checkingBalance += amount;
        } else if ("saving".equalsIgnoreCase(accountType)) {
            savingsBalance += amount;
        }
        totalMoneyStored += amount;
    }

    public void withdraw(double amount, String accountType) {
        if ("checking".equalsIgnoreCase(accountType) && checkingBalance >= amount) {
            checkingBalance -= amount;
            totalMoneyStored -= amount;
        } else if ("saving".equalsIgnoreCase(accountType) && savingsBalance >= amount) {
            savingsBalance -= amount;
            totalMoneyStored -= amount;
        } else {
            System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        }
    }

    public void displayTotalMoney() {
        System.out.printf("Total Money: Checking - $%.2f, Saving - $%.2f%n", checkingBalance, savingsBalance);
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static double getTotalMoneyStored() {
        return totalMoneyStored;
    }

    private String generateAccountNumber() {
        // Ninja Bonus: Generate a random ten-digit account number
        Random random = new Random();
        long accountNumber = 1_000_000_000L + random.nextInt(9_000_000_000);
        return Long.toString(accountNumber);
    }
}

public class TestBankAccount {
    public static void main(String[] args) {
        // Test BankAccount class
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        System.out.println("Number of accounts created: " + BankAccount.getNumberOfAccounts());

        account1.deposit(1000, "checking");
        account1.deposit(500, "saving");
        account2.deposit(1500, "checking");

        System.out.println("Total money stored: $" + BankAccount.getTotalMoneyStored());

        account1.displayTotalMoney();
        account2.displayTotalMoney();

        account1.withdraw(200, "checking");
        account1.displayTotalMoney();

        account1.withdraw(1000, "saving"); // Insufficient funds
    }
}
