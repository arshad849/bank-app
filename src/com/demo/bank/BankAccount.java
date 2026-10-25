package com.demo.bank;

public class BankAccount {

    private final String accountNumber;
    private final String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Balance: " + balance);
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }
}
