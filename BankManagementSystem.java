
import exception.InsufficientBalanceException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import model.BankAccount;
import util.FileUtil;

public class BankManagementSystem {

    private static Map<String, BankAccount> accounts
            = Collections.synchronizedMap(FileUtil.loadAccounts());

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            printMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 ->
                        createAccount();
                    case 2 ->
                        depositMoney();
                    case 3 ->
                        withdrawMoney();
                    case 4 ->
                        checkBalance();
                    case 5 ->
                        viewTransactionHistory();
                    case 6 ->
                        exitSystem();
                    default ->
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n====== BANK MANAGEMENT SYSTEM ======");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    private static void createAccount() {

        System.out.print("Account Number: ");
        String accNo = scanner.nextLine();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists.");
            return;
        }

        try {
            System.out.print("Account Holder Name: ");
            String name = scanner.nextLine();

            System.out.print("Initial Deposit: ");
            double deposit = Double.parseDouble(scanner.nextLine());

            System.out.print("Set PIN: ");
            String pin = scanner.nextLine();

            BankAccount account
                    = new BankAccount(accNo, name, deposit, pin);

            accounts.put(accNo, account);
            FileUtil.saveAccounts(accounts);

            System.out.println("Account created successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static BankAccount authenticate() {

        System.out.print("Account Number: ");
        String accNo = scanner.nextLine();

        BankAccount account = accounts.get(accNo);

        if (account == null) {
            System.out.println("Account not found.");
            return null;
        }

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (!account.validatePin(pin)) {
            System.out.println("Invalid PIN.");
            return null;
        }

        return account;
    }

    private static void depositMoney() {

        BankAccount account = authenticate();
        if (account == null) {
            return;
        }

        try {
            System.out.print("Deposit Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            account.deposit(amount);
            FileUtil.saveAccounts(accounts);

            System.out.println("Deposit successful!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void withdrawMoney() {

        BankAccount account = authenticate();
        if (account == null) {
            return;
        }

        try {
            System.out.print("Withdrawal Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            account.withdraw(amount);
            FileUtil.saveAccounts(accounts);

            System.out.println("Withdrawal successful!");

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
        }
    }

    private static void checkBalance() {

        BankAccount account = authenticate();
        if (account == null) {
            return;
        }

        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    private static void viewTransactionHistory() {

        BankAccount account = authenticate();
        if (account == null) {
            return;
        }

        account.printTransactionHistory();
    }

    private static void exitSystem() {

        FileUtil.saveAccounts(accounts);
        System.out.println("Thank you for using our system.");
        System.exit(0);
    }
}
