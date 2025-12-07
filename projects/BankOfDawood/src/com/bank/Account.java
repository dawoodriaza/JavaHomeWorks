package com.bank;

abstract class Account {

    protected String name;
    protected double balance;
    Account(String name, double balance)
    {
        this.name = name;
        this.balance = balance;

    }
    public void deposit(double amount) {
        double preBalance = amount;
        balance += amount;
        System.out.println(amount + " deposited. Current balance: " + balance);
        String txt = amount + " deposited.Prevous Balance :" + preBalance + " Current balance is:" +balance ;
        fileMethods.log(txt);


    }
    public abstract void withdraw(double amount);
    public double getBalance() {
        return balance;
    }
}
