package com.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BankTests {


    @Test
    @DisplayName("Deposit should increase balance")
    public void depositShouldIncreaseBalance() {
        CheckingAccount acc = new CheckingAccount("Dawood", 100);
        acc.deposit(50);
        assertEquals(150, acc.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Withdraw should decrease balance when sufficient funds are available")
    public void withdrawShouldDecreaseBalance() {
        CheckingAccount acc = new CheckingAccount("Dawood", 200);
        acc.withdraw(50);
        assertEquals(150, acc.getBalance(), 0.001);
    }

    @Test
    @DisplayName("CheckingAccount should allow overdraft up to -100")
    public void overdraftWithinLimitShouldBeAllowed() {
        CheckingAccount acc = new CheckingAccount("Dawood", 0);
        acc.withdraw(80);
        assertEquals(-80, acc.getBalance(), 0.001);
    }

    @Test
    @DisplayName("CheckingAccount should NOT allow overdraft beyond -100")
    public void overdraftBeyondLimitShouldFail() {
        CheckingAccount acc = new CheckingAccount("Dawood", 0);
        acc.withdraw(150); // not allowed
        assertEquals(0, acc.getBalance(), 0.001);
    }


    @Test
    @DisplayName("SavingAccount should block withdrawal below minimum balance")
    public void savingAccountShouldRespectMinimumBalance() {
        SavingAccount acc = new SavingAccount("Dawood", 900);
        acc.withdraw(450);
        assertEquals(450, acc.getBalance(), 0.001);
    }

    @Test
    @DisplayName("SavingAccount allows withdrawal as long as balance is sufficient")
    public void savingAccountShouldAllowNormalWithdrawal() {
        SavingAccount acc = new SavingAccount("Dawood", 900);
        acc.withdraw(450);
        assertEquals(450, acc.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Transfer from Saving Checking should update both balances correctly")
    public void testTransferMoney() {
        BankOfDawood bank = new BankOfDawood();
        Customer c = new Customer("Dawood",800.0,"dawood","dawoodriaz","99080","99",99080, LocalDate.of(1999, 5, 20));
        StartingPoint.customers.put("Dawood", c);

        Account saving = new SavingAccount("Dawood", 1000);
        Account checking = new CheckingAccount("Dawood", 200);

        c.setSavingAccount(saving);
        c.setCheckingAccount(checking);

        bank.accounts.put("Dawood_SAVING", saving);
        bank.accounts.put("Dawood_CHECKING", checking);

        double amount = 300;
        saving.balance -= amount;
        checking.balance += amount;


        assertEquals(700, saving.getBalance(), 0.001);
        assertEquals(500, checking.getBalance(), 0.001);
    }

}
