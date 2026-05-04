import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> accounts;
    private Scanner input;

    public Bank() {
        accounts = new ArrayList<>();
        input = new Scanner(System.in);

        accounts.add(new BankAccount(1001, 1234, "John Doe", 500.00));
        accounts.add(new BankAccount(1002, 2345, "Jane Smith", 1200.00));
        accounts.add(new BankAccount(1003, 3456, "Alice Johnson", 850.00));
    }

    public BankAccount findAccount(int accountNumber, int pin) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber && account.validatePin(pin)) {
                return account;
            }
        }

        return null;
    }

    public void performTransaction() {
        System.out.println("Welcome to the Java Banking System");

        System.out.print("Enter your account number: ");
        int accountNumber = input.nextInt();

        System.out.print("Enter your PIN: ");
        int pin = input.nextInt();

        BankAccount currentAccount = findAccount(accountNumber, pin);

        if (currentAccount == null) {
            System.out.println("Invalid account number or PIN. Login failed.");
            return;
        }

        System.out.println("Login successful!");
        System.out.println("Welcome, " + currentAccount.getName() + "!");

        int choice;

        do {
            System.out.println("\n----- Banking Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    currentAccount.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = input.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the Java Banking System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose 1, 2, 3, or 4.");
            }

        } while (choice != 4);
    }
}
