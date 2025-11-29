package com.example.atm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void depositShouldIncreaseBalance() {
        Account acc = new Account("A1", "0000", BigDecimal.valueOf(100));
        acc.deposit(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(150), acc.getBalance());
    }

    @Test
    public void withdrawShouldDecreaseBalance() {
        Account acc = new Account("A2", "0000", BigDecimal.valueOf(200));
        acc.withdraw(BigDecimal.valueOf(75));
        assertEquals(BigDecimal.valueOf(125), acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowOnInsufficientFunds() {
        Account acc = new Account("A3", "0000", BigDecimal.valueOf(30));
        assertThrows(IllegalStateException.class, () -> acc.withdraw(BigDecimal.valueOf(50)));
    }

    @Test
    public void verifyPinWorks() {
        Account acc = new Account("A4", "1234", BigDecimal.valueOf(10));
        assertTrue(acc.verifyPin("1234"));
        assertFalse(acc.verifyPin("0000"));
    }
}
