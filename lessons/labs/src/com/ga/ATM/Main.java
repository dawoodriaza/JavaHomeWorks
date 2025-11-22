package com.ga.ATM;

public class Main {
    public static void main(String[] args) {
        ATM a = new ATM("Saving");
        ATM b = new ATM("Checking");
        a.setBackupAccount(b);
        a.deposit(100.0);
        b.deposit(50.0);

        a.withdraw(200.0);
        a.printBalance();
        b.printBalance();


    }
}
