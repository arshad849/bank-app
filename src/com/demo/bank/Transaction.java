package com.demo.bank;

import java.time.LocalDateTime;

public record Transaction(TransactionType type, double amount, double balanceAfter, LocalDateTime timestamp) {
}
