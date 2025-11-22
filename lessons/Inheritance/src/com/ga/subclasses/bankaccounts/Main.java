package com.ga.subclasses.bankaccounts;
/**
 * // Bank App with Inheritance (50 Mins)
 * ## Java Inheritance Lab - Banking System
 * ### Part 1
 * - Create a base BankAccount class.
 * 1. Bank accounts keep track of their current balance.
 * 2. Bank accounts have a check_balance method that returns the current balance.
 * 3. Bank accounts have a deposit method that returns the balance of the account after adding to it.
 * 4. Bank accounts have a withdraw method that returns the amount of money that was successfully withdrawn.
 * 5. Bank accounts return False if someone tries to deposit or withdraw a negative amount.
 * 6. Bank accounts are created with a default interest rate of 2%.
 * 7. Bank accounts have a accumulate_interest method that sets the balance equal to the balance plus the balance times the interest rate.
 * 8. accumulate_interest returns the balance of the account after calculating the accumulated interest.
 * ### Part 2
 * - Create a ChildrensAccount class
 * 1. Inherits from BankAccount
 * 2. Children's bank accounts have an interest rate of Zero.
 * 3. Every time accumulate_interest is executed on a Child's account, the account always gets $10 added to the balance.
 * ### Part 3
 * - Create an OverdraftAccount class
 * 1. Inherits from BankAccount
 * 2. An overdraft account penalizes customers for trying to draw too much money out of their account.
 * 3. Overdraft accounts are created with an overdraft_penalty property that defaults to $40.
 * 4. Customer's aren't allowed to withdraw more money than they have in their account. If a customer tries to withdraw more than they have then the withdraw method returns False and their balance is deducted only by the amount of the overdraft_penalty.
 * 5. Overdraft accounts don't accumulate interest if their balance is below zero.
 * */
public class Main {
    public static void main(String[] args) {
        BankAccount Dawood =  new BankAccount(500);
        System.out.println("Dawood current balance is = " + Dawood.currentBalance);
        System.out.println("Ammount after withdrawing = " + Dawood.withdraw(200));
        System.out.println("Dawood accumalet interest " + Dawood.accumalate_interest());
        ChildrenAccount Shazam = new ChildrenAccount(100);
        System.out.println("Shazam current balance is = " + Shazam.currentBalance);
        System.out.println("Ammount after withdrawing = " + Shazam.withdraw(50));

        OverdraftClass CAT = new OverdraftClass(80);
        System.out.println("cat current balance is = " + CAT.currentBalance);
        System.out.println("CAT  interest RATE = " + CAT.interestRate);
        System.out.println("CAT  WITHDRAWING AMOUNT  = " + CAT.withdraw(90));
        System.out.println("cat current balance is = " + CAT.currentBalance);
    }
}
