package com.ga.subclasses.bankaccounts;

public class OverdraftClass extends BankAccount{
    public double over_draft_penalty = 40;
    public  OverdraftClass(double currentBalance){
        super(currentBalance);
    }


    @Override
    public double withdraw(double amount) {
        if (amount <0){
//            throw new IllegalArgumentException("Ammount cannot be less than zero");
        }
        if (amount > currentBalance){
            currentBalance-=over_draft_penalty;
//            throw new IllegalArgumentException("Ammount cannot withdrawn more than current balance. Amount deducted from overdraft amount as a penalty");
            return 0;
        }
        currentBalance -= amount;
        return currentBalance;
    }

    @Override
    public double accumalate_interest() {
        if(currentBalance<0){
            return currentBalance;
        }
        return super.accumalate_interest();
    }
}
