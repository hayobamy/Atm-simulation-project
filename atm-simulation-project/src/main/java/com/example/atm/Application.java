package com.example.atm;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Account acc = new Account("12345678", "1234", BigDecimal.valueOf(1000));
        atm.addAccount(acc);

        System.out.println("Welcome to ATM Simulation");
        System.out.println(atm.processWithdrawal("12345678", "1234", BigDecimal.valueOf(200)));
        System.out.println(atm.processDeposit("12345678", "1234", BigDecimal.valueOf(500)));
        System.out.println("Final balance: " + atm.getAccount("12345678").getBalance());
    }
}
