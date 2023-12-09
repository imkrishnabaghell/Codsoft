
/* CODSOFT TASK 3 ATM INTERFACE */

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                double balance = userAccount.getBalance();
                System.out.println("Your current balance is: Rs" + balance);
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            case 3:
                System.out.print("Enter withdrawal amount: Rs");
                double withdrawAmount = scanner.nextDouble();
                boolean success = userAccount.withdraw(withdrawAmount);
                if (success) {
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public static void main(String[] args) {
        BankAccount userBankAccount = new BankAccount(0); // Initial balance Rs 0
        ATM atm = new ATM(userBankAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.processOption(choice);
        }
    }
}
