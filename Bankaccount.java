public class BankAccount {
    private int accountNumber;
    private int pin;
    private String name;
    private double currentBalance;

    public BankAccount(int accountNumber, int pin, String name, double currentBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.name = name;
        this.currentBalance = currentBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit must be greater than 0.");
        } else {
            currentBalance += amount;
            System.out.printf("Deposit successful. New balance: $%.2f%n", currentBalance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be greater than 0.");
        } else if (amount > currentBalance) {
            System.out.println("Insufficient funds. You cannot withdraw more than your balance.");
        } else {
            currentBalance -= amount;
            System.out.printf("Withdrawal successful. New balance: $%.2f%n", currentBalance);
        }
    }

    public void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", currentBalance);
    }
}
