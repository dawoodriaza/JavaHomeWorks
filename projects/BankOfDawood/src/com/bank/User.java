package com.bank;

import java.time.LocalDate;
import java.util.*;

public interface User {
    String getUserName();
    String getName();
    String getEmail();
    String getPassword();
    long cpr();
    LocalDate dateOfBirth();
    void getName(String name);
    void getEmail(String email);
    void getPassword(String password);
    void cpr(long password);
    void dateOfBirth(LocalDate dob);
}


