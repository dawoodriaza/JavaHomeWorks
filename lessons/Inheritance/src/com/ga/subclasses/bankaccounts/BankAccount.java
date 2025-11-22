package com.ga.subclasses.bankaccounts;

public class BankAccount {
    protected double currentBalance;

protected double interestRate = 0.02;

    public BankAccount(double currentBalance) {
        this.currentBalance =currentBalance;
    }

    public double  check_balance(){
        return currentBalance;
    }
    public double deposit(double amount){
        if(amount<0){
//            throw new IllegalArgumentException("Ammount cannot be less then zero");
            return 0;
        }
        return amount + currentBalance;
    }

    public double withdraw(double amount){
        if(amount<0){
//            throw new IllegalArgumentException("Amount cannot be less than zero");
            return 0;
        }
        return currentBalance - amount;
    }
    public double accumalate_interest(){
        return   currentBalance = currentBalance + (currentBalance *interestRate );
    }


}
