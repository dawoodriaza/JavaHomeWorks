package com.bank;

public interface Bank {

void createAccount(String Name, String accounts , double initialDeposit);
void deposit(String userName);

void withdrawAmount(String userName);
double checkBalance(String userName);


void transferMoney(String userName);
void tansferToOther(String userName);


}
