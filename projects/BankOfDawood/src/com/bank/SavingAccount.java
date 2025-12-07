package com.bank;

class SavingAccount extends Account {

    SavingAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Cannot withdraw. Insufficient funds.");
            return;
        }

        balance -= amount;
        System.out.println(amount + " withdrawn. Current balance: " + balance);
    }
}
