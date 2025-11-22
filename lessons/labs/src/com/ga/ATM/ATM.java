package com.ga.ATM;

import java.util.ArrayList;

/*
* ⏱️ Estimated Time: 30 minutes

In this exercise, you will create an ATM class with properties, methods, and extended behavior.

🔧 Requirements
🏦 Properties
type → e.g., "checking" (set via constructor)
money → starts at 0
transactionHistory → keeps track of all deposits and withdrawals
Include whether each transaction increased or decreased the balance.
backupAccount → optional reference to another ATM object
🛠️ Methods
withdraw(amount) → decreases the balance
deposit(amount) → increases the balance
showBalance() → prints the current balance
⚠️ Special Behavior
If the ATM’s balance goes below 0, it should automatically pull money from its backupAccount to bring the balance back to 0.
The backup account should perform a withdrawal equal to (or up to) the required amount.
* */
public class ATM {
    private String type;
    private double money = 0;
    ArrayList<String> transactionHistory;
    private ATM backupAccount;
    public double withdraw(Double withdrawMoney){
        transactionHistory.add("Amount is withdrawn descread the balance by" +withdrawMoney );
        if (money < 0 && backupAccount != null ){
            double needed = -money;
            System.out.println("PULLING money from backup"+ needed + " amount");
           double withdrawed = backupAccount.withdrawfromBackAccount(needed);
            money+= withdrawed;
        }
        System.out.println("Money withdrawm");
        return money - withdrawMoney;
    }
    public  double withdrawfromBackAccount(double uptoamount){
        double withdrawn = Math.min(uptoamount,money );
        money -= uptoamount;
        transactionHistory.add("BackupWithdraw");
        return withdrawn;
    }


    public double deposit(Double depositMoney){
        transactionHistory.add("Amount is withdrawn increased the balance by" +depositMoney );
        System.out.println("Deposited amount " + depositMoney);
        return money + depositMoney;
    }

    public ATM(String type){
        this.type = type;
        this.money = 0;
        this.transactionHistory = new ArrayList<>();
        this.backupAccount = null;
    }

    public void setBackupAccount(ATM backup){
        this.backupAccount = backup;

    }
    public void printBalance(){
        System.out.println("The current balance is "+money );
    }

}
