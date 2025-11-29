package com.example.atm;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private final Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Receipt processWithdrawal(String accountNumber, String pin, BigDecimal amount) {
        Account acc = accounts.get(accountNumber);
        if (acc == null) {
            return new Receipt(false, "Account not found");
        }
        if (!acc.verifyPin(pin)) {
            return new Receipt(false, "Invalid PIN");
        }
        try {
            acc.withdraw(amount);
            return new Receipt(true, "Withdrawal successful", acc.getBalance());
        } catch (IllegalStateException | IllegalArgumentException e) {
            return new Receipt(false, e.getMessage());
        }
    }

    public Receipt processDeposit(String accountNumber, String pin, BigDecimal amount) {
        Account acc = accounts.get(accountNumber);
        if (acc == null) {
            return new Receipt(false, "Account not found");
        }
        if (!acc.verifyPin(pin)) {
            return new Receipt(false, "Invalid PIN");
        }
        try {
            acc.deposit(amount);
            return new Receipt(true, "Deposit successful", acc.getBalance());
        } catch (IllegalArgumentException e) {
            return new Receipt(false, e.getMessage());
        }
    }
}
