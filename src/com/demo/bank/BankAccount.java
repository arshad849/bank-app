package com.demo.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {

    private final String accountNumber;
    private final String holderName;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

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
        record(TransactionType.DEPOSIT, amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Balance: " + balance);
        }
        balance -= amount;
        record(TransactionType.WITHDRAWAL, amount);
    }

    private void record(TransactionType type, double amount) {
        transactions.add(new Transaction(type, amount, balance, LocalDateTime.now()));
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void printStatement() {
        System.out.println("--- Statement for " + holderName + " (" + accountNumber + ") ---");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.printf("%s | %-10s | %10.2f | balance: %10.2f%n",
                    t.timestamp(), t.type(), t.amount(), t.balanceAfter());
        }
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
