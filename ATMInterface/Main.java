import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class ATMMachine {
    private BankAccount bankAccount;

    public ATMMachine(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void interact() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Machine Options:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bankAccount.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Starting with a balance of 1000
        ATMMachine atm = new ATMMachine(account);
        atm.interact();
    }
}
