import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double startingBalance) {
        this.balance = startingBalance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Enter a valid amount to withdraw.");
            return false;
        }
        if (amount > balance) {
            System.out.println(" Insufficient balance.");
            return false;
        }
        balance -= amount;
        System.out.println(" Withdrawal successful. ₹" + amount + " debited.");
        return true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" Cannot deposit a non-positive amount.");
            return false;
        }
        balance += amount;
        System.out.println(" Deposit successful. ₹" + amount + " credited.");
        return true;
    }

    public double getBalance() {
        return balance;
    }
}

public class ATM {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" Welcome to ATM");
        BankAccount userAccount = new BankAccount(1000.0); 

        boolean sessionActive = true;

        while (sessionActive) {
            System.out.println("\n Choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> handleWithdraw(userAccount);
                case 2 -> handleDeposit(userAccount);
                case 3 -> System.out.printf(" Current Balance: ₹%.2f\n", userAccount.getBalance());
                case 4 -> {
                    System.out.println(" Thank you for using ATM. Have a Nice Day Ahead");
                    sessionActive = false;
                }
                default -> System.out.println(" Invalid option. Please choose between 1-4.");
            }
        }

        input.close();
    }

    private static void handleWithdraw(BankAccount account) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = input.nextDouble();
        account.withdraw(amount);
    }

    private static void handleDeposit(BankAccount account) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = input.nextDouble();
        account.deposit(amount);
    }
}
  