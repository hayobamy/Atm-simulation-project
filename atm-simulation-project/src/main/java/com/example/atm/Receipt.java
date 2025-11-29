package com.example.atm;

import java.math.BigDecimal;

public class Receipt {
    private final boolean success;
    private final String message;
    private final BigDecimal balance;

    public Receipt(boolean success, String message, BigDecimal balance) {
        this.success = success;
        this.message = message;
        this.balance = balance;
    }

    public Receipt(boolean success, String message) {
        this(success, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", balance=" + balance +
                '}';
    }
}
