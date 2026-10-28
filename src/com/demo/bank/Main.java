package com.demo.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-1001", "Arshad", 500.0);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> account.deposit(readAmount(scanner));
                    case "2" -> account.withdraw(readAmount(scanner));
                    case "3" -> System.out.println("Balance: " + account.getBalance());
                    case "4" -> account.printStatement();
                    case "5" -> running = false;
                    default -> System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a valid number.");
            } catch (IllegalArgumentException | InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Goodbye!");
    }

    private static double readAmount(Scanner scanner) {
        System.out.print("Enter amount: ");
        return Double.parseDouble(scanner.nextLine().trim());
    }

    private static void printMenu() {
        System.out.println("\n1. Deposit\n2. Withdraw\n3. Check balance\n4. Statement\n5. Exit");
        System.out.print("Choose: ");
    }
}
