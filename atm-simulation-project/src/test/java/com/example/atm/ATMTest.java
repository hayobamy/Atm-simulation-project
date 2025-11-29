package com.example.atm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ATMTest {

    @Test
    public void testWithdrawalSuccess() {
        ATM atm = new ATM();
        Account acc = new Account("X1", "4321", BigDecimal.valueOf(500));
        atm.addAccount(acc);

        Receipt r = atm.processWithdrawal("X1", "4321", BigDecimal.valueOf(100));
        assertTrue(r.isSuccess());
        assertEquals(BigDecimal.valueOf(400), acc.getBalance());
    }

    @Test
    public void testDepositSuccess() {
        ATM atm = new ATM();
        Account acc = new Account("X2", "1111", BigDecimal.valueOf(50));
        atm.addAccount(acc);

        Receipt r = atm.processDeposit("X2", "1111", BigDecimal.valueOf(25));
        assertTrue(r.isSuccess());
        assertEquals(BigDecimal.valueOf(75), acc.getBalance());
    }

    @Test
    public void invalidPinShouldFail() {
        ATM atm = new ATM();
        Account acc = new Account("X3", "9999", BigDecimal.valueOf(100));
        atm.addAccount(acc);

        Receipt r = atm.processWithdrawal("X3", "0000", BigDecimal.valueOf(10));
        assertFalse(r.isSuccess());
        assertEquals("Invalid PIN", r.getMessage());
    }
}
