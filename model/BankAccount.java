package model;

import exception.InsufficientBalanceException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName,
            double initialDeposit, String pin) {

        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();

        addTransaction("Account created with ₹" + initialDeposit);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive.");
        }

        balance += amount;
        addTransaction("Deposited ₹" + amount);
    }

    public synchronized void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive.");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        balance -= amount;
        addTransaction("Withdrawn ₹" + amount);
    }

    private void addTransaction(String message) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String timestamp = LocalDateTime.now().format(formatter);
        transactionHistory.add(timestamp + " - " + message);
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        System.out.println("\n--- Transaction History ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}
