package com.ga.subclasses.bankaccounts;

public class ChildrenAccount extends BankAccount{
    public ChildrenAccount(double currentBalance){
        super(currentBalance);
        this.interestRate = 0.0;
    }
    @Override
    public double accumalate_interest(){
        return currentBalance+= 10;
    }
}
