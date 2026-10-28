package com.demo.bank;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", "Arshad", 500.0);
        account.deposit(250.0);
        try {
            account.withdraw(100.0);
            account.withdraw(5000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Balance: " + account.getBalance());
    }
}
