package com.bank;

import java.time.LocalDate;
import java.util.*;

public class BankAdmin implements User{
private String userName;
private String name;
    private String email;
    private String password;
    private long cpr;
    private LocalDate dob;

    public BankAdmin(String userName,String name , String email , String password , long cpr, LocalDate dob) {
        this.userName = userName;
        this.name = name;
        this.email =email;
        this.password = password;
        this.cpr =cpr;
        this.dob =dob;
    }


    @Override
    public String getUserName() {
        return userName;
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
