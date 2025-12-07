package com.bank;

import java.time.LocalDate;

public class Customer implements User{
    private String userName;
    private String name;
    private String email;
    private String password;
    private long cpr;
    private LocalDate dob;
    private Card savingCard;
    private Card checkingCard;
    private Double initialAmount;
    private String secretKeyString;

    private Account savingAccount;
    private Account checkingAccount;

    public Customer(
            String userName,
            Double initialAmount,
            String name , String email , String encryptedPass,String secretKeyString, long cpr, LocalDate dob) {
        this.userName = userName;
        this.initialAmount = initialAmount;
        this.name = name;
        this.email =email;
        this.password = encryptedPass;
        this.cpr =cpr;
        this.dob =dob;
        this.secretKeyString= secretKeyString;
    }
    public Account getCheckingAccount() {
        return checkingAccount;
    }
    public Account getSavingsAccount() {
        return savingAccount;

    }
    public Double getinitialAmount() {
        return initialAmount;
    }
    public String getSecretKeyString() {
        return secretKeyString;
    }
    public Card getSavingCard() { return savingCard; }
    public Card getCheckingCard() { return checkingCard; }

    public void setSavingCard(Card card) { this.savingCard = card; }
    public void setCheckingCard(Card card) { this.checkingCard = card; }

    @Override
    public String getUserName() {
        return userName;
    }
    public void setSavingAccount(Account acc) {
        this.savingAccount = acc;
    }

    public void setCheckingAccount(Account acc) {
        this.checkingAccount = acc;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public long cpr() {
        return cpr;
    }

    @Override
    public LocalDate dateOfBirth() {
        return dob;
    }

    @Override
    public void getName(String name) {

    }
    @Override
    public void getEmail(String email) {

    }
    @Override
    public void getPassword(String password) {

    }
    @Override
    public void cpr(long password) {
    }
    @Override
    public void dateOfBirth(LocalDate dob) {

    }
}
