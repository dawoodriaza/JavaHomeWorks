# BankOfDawood  
A Simple Java Banking System (Console Application)

BankOfDawood is a Java-based console banking system that simulates the core features of a real bank.  
It includes account creation, login, deposits, withdrawals, overdraft handling, transfers, currency conversion, encryption, data storage, Generate PDF statements and transaction logs.
This project demonstrates strong knowledge of OOPs concept, file handling, Java utilities, and Test Driverarchitecture.

## Features

###User Account System
- Create customer accounts
- Login using encrypted passwords (AES encryption)
- File-based storage so data stays even after restart

###Banking Operations
- Deposit money  
- Withdraw money (with overdraft control)
- Transfer between accounts
- View current balance
- Account activation/deactivation

### Transaction Logging
Every deposit or withdrawal is saved in `log.txt`:

### Currency Conversion
- Supports BHD, USD, EUR, GBP, SAR, PKR
- Implemented using `HashMap<String, Double>`
- Clean Optional-based result handling

### File Persistence
Data is stored in simple files using:
- `BufferedReader`
- `BufferedWriter`

This acts as a mini local database.

### Account Types
- **Checking Account** (allows overdraft up to –100)
- **Saving Account** (interest rate and minimum balance)


## OOP Concepts Used

### **Interfaces**
`Currency`  
Defines required methods for currency handling.
### **Abstract Classes**
- `Account`
- `AccountTransactions`
- `Currencies`
- `Cards`

These provide shared logic to avoid repeating code.

### ** Concrete Classes**
- `CheckingAccount`
- `SavingAccount`
- `Customer`
- `BankOfDawood`

They contain real working implementations.

### **Encapsulation**
Private fields with getters/setters.

### **Polymorphism**
Different account types share the same base class but behave differently (e.g., overdraft logic).


##  Project Structure

src
└── com.bank
├── Account.java
├── Bank.java (interface)
├── BankAdmin.java
├── BankOfDawood.java
├── Card.java
├── CheckingAccount.java
├── Currencies.java
├── Currency.java (interface)
├── Customer.java
├── FileLoaders.java
├── fileMethods.java
├── PasswordEncryptor.java
├── PlatinumCard.java
├── SavingAccount.java
├── StandardMastercard.java
├── StartingPoint.java (main entry point)
├── TitaniumCard.java
└── User.java (interface)


##  User Stories

### 1. Secure Login
As a user, i want to log into my bank account securely so that my personal financial data stays safe.

### 2. View Account Balance
As a user, i want to check my account balance so that I always know how much money i have.

### 3. Deposit Money
As a user,i want to deposit money so that I can increase my account balance.

### 4. Withdraw Money with Notifications
As a user, i want to withdraw money and receive a confirmation notification so i know the operation was successful.

### 5. Overdraft Handling
As a user, i want the system to warn me when a withdrawal will push my balance past the overdraft limit.

### 6. Currency Conversion
As a user, i want to convert money between multiple currencies (BHD, USD, EUR, GBP, SAR, PKR) so that i can understand the value of my balance internationally.

### 7. View Transaction History
As a user, i should be able to view the full history of my transactions to track my spending and deposits.

### 8. Card Upgrades
As a user, i want to upgrade my card (Standard , Platinum , Titanium) so i can enjoy better banking features.
### 9. Admin Functionality
As an admin, i want to view all customers, accounts, and logs so that i can manage the banking system effectively.
### 10. File Persistence
As a admin , i must see all the banks customer 
### 11 Unblocking/Blocking
As an admin, i can unblock users



Technologies Used
Java 17
AES Encryption
File I/O
Object-Oriented Programming
Streams
Optional\
Maps & Collections

##  How to Run the Project
 **Run 'StartingPoint.main()'**



It:
- Loads customer & account and all necessary files  
- Initializes the BankOfDawood system  
- Shows the main menu  
- Controls all user interactions  


## ERD diagram

![BankOfDawood ERD](https://iili.io/fR69VdG.png)


## References & Learning Resources

### Trello Board (Project Tracking)
https://trello.com/b/YPjGut6b/bank-of-dawood

### YouTube Tutorials Used
- PDF Generation Help:  
  https://www.youtube.com/watch?v=SZEhv8tpT6U&list=PLFh8wpMiEi8-Yo59DBCasuVi1M29kQrvn

- File Reading/Writing (Inspiration for BufferedReader & BufferedWriter approach):  
 https://www.w3schools.com/java/java_files.asp


  
Author
Muhammad Dawood Riaz
Bahraini Software Engineer
Java • Node.js • AWS • MySQL • MERN Stack

