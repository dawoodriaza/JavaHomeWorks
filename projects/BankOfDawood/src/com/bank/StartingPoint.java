package com.bank;

import javax.crypto.SecretKey;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;
import java.io.*;

public class StartingPoint {

    public static Map<String, Customer> customers = new HashMap<>();
    public static Map<String, Account> loadedAccounts = new HashMap<>();
    public static Map<String, Long> lockTimes = new HashMap<>();
    public static Map<String, Integer> wrongAttempts = new HashMap<>();
    public static BankOfDawood bank = new BankOfDawood();
    public static void main(String[] args) {
        FileLoaders.loadCustomers();
        FileLoaders.loadAccounts();
        FileLoaders.loadCards();
        FileLoaders.loadCardUsage();
        FileLoaders.loadOverdraftData();

        Scanner input = new Scanner(System.in);

        System.out.println(loadedAccounts.keySet());

        for (String key : loadedAccounts.keySet()) {
            bank.accounts.put(key, loadedAccounts.get(key));
        }

        System.out.println("loadedAccounts" + loadedAccounts);


        while (true) {

            System.out.println("Welcome to Bank Of Dawood");
            System.out.println("Press 1: To Login as customer");
            System.out.println("Press 2: To Login as bank");
            System.out.println("Press 3: To SignUp as customer");

            int kbd = Integer.parseInt(input.nextLine());

            switch (kbd) {


                case 1:

                    System.out.println("Enter Username");
                    String usernameInput = input.nextLine();

                    if (!customers.containsKey(usernameInput)) {
                        System.out.println("No such customer.");
                        break;
                    }

                    if (lockTimes.containsKey(usernameInput)) {
                        long left = (lockTimes.get(usernameInput) - System.currentTimeMillis()) / 1000;
                        if (left > 0) {
                            System.out.println("Account locked for " + left + " seconds.");
                            break;
                        } else {
                            lockTimes.remove(usernameInput);
                            wrongAttempts.put(usernameInput, 0);
                        }
                    }

                    System.out.println("Enter Password");
                    String passwordInput = input.nextLine();

                    Customer loginAcc = customers.get(usernameInput);

                    SecretKey key = PasswordEncryptor.stringToKey(loginAcc.getSecretKeyString());
                    String encryptedInput = PasswordEncryptor.encrypt(passwordInput, key);

                    if (!encryptedInput.equals(loginAcc.getPassword())) {

                        int attempts = wrongAttempts.getOrDefault(usernameInput, 0) + 1;
                        wrongAttempts.put(usernameInput, attempts);

                        if (attempts >= 3) {
                            lockTimes.put(usernameInput, System.currentTimeMillis() + (3 * 60 * 1000));
                            System.out.println("Too many attempts. Locked for 3 minutes.");
                        } else {
                            System.out.println("Incorrect password. Attempts: " + attempts + "/3");
                        }

                        break;
                    }

                    wrongAttempts.put(usernameInput, 0);
                    lockTimes.remove(usernameInput);

                    System.out.println("\nCustomer Login Successful");

                    Customer loggedIn = customers.get(usernameInput);
/*
*
Customer Menu
*
* */
                    while (true) {

                        System.out.println("Press 1: Create Account");
                        System.out.println("Press 2: Check Balance");
                        System.out.println("Press 3: Withdraw");
                        System.out.println("Press 4: Deposit");
                        System.out.println("Press 5: Transfer (Self)");
                        System.out.println("Press 6: Transfer (Other)");
                        System.out.println("Press 7: Change/Upgrade Card");
                        System.out.println("Press 8: View Card Details");
                        System.out.println("Press 10: Print Statement");
                        System.out.println("Press 11: Check Currency Prices");
                        System.out.println("Press 12: Convert Curreny");
                        System.out.println("Press 13: Check Cuurent Card");
                        System.out.println("Press 14: Filter Transactions");
                        System.out.println("Press 9: ToLogOut");

                        int userChoice = Integer.parseInt(input.nextLine());

                        switch (userChoice) {

                            case 1:
                                System.out.println("Enter Account Type (SAVING / CHECKING)");
                                String actType = input.nextLine();
                                System.out.println("Enter Initial Deposit");
                                double dep = Double.parseDouble(input.nextLine());
                                bank.createAccount(loggedIn.getUserName(), actType, dep);
                                break;
                            case 14:

                                bank.filterTransactions(loggedIn.getUserName());
                                break;
                            case 2:
                                System.out.println("Balance: " + bank.checkBalance(loggedIn.getUserName()));
                                break;
                            case 13:
                                bank.showMyCards(loggedIn.getUserName());
                                break;
                            case 3:
                                bank.withdrawAmount(loggedIn.getUserName());
                                break;

                            case 4:
                                bank.deposit(loggedIn.getUserName());
                                break;

                            case 5:
                                bank.transferMoney(loggedIn.getUserName());
                                break;

                            case 6:
                                bank.tansferToOther(loggedIn.getUserName());
                                break;

                            case 7:
                                bank.changeCardType(loggedIn.getUserName());
                                break;

                            case 8:
                                bank.viewCardDetails(loggedIn.getUserName());
                                break;
                            case 10:
                                bank.printStatemnt(loggedIn.getUserName());
                                break;


                            case 11:
                                System.out.println("\nCurrency Prices");
                                Currencies.listCurrencyPrices();
                                break;


                            case 12:
                                System.out.println("Enter amount you want to convert:");
                                double amount = Double.parseDouble(input.nextLine());

                                String from = null;
                                String to = null;


                                while (true) {
                                    System.out.println("\nSelect Currency to convert FROM:");
                                    System.out.println("1: usd");
                                    System.out.println("2: bhd");
                                    System.out.println("3: pkr");
                                    System.out.println("4: gbp");
                                    System.out.println("5: sar");
                                    System.out.println("6: eur");
                                    System.out.println("7: Cancel");

                                    int choice = Integer.parseInt(input.nextLine());

                                    switch (choice) {
                                        case 1: from = "usd"; break;
                                        case 2: from = "bhd"; break;
                                        case 3: from = "pkr"; break;
                                        case 4: from = "gbp"; break;
                                        case 5: from = "sar"; break;
                                        case 6: from = "eur"; break;
                                        case 7:
                                            System.out.println("Operation cancelled.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Try again.");
                                            continue;
                                    }
                                    break;
                                }

                                while (true) {
                                    System.out.println("Select Currency to convert TO:");
                                    System.out.println("1: usd");
                                    System.out.println("2: bhd");
                                    System.out.println("3: pkr");
                                    System.out.println("4: gbp");
                                    System.out.println("5: sar");
                                    System.out.println("6: eur");
                                    System.out.println("7: Cancel");

                                    int choice = Integer.parseInt(input.nextLine());

                                    switch (choice) {
                                        case 1: to = "usd"; break;
                                        case 2: to = "bhd"; break;
                                        case 3: to = "pkr"; break;
                                        case 4: to = "gbp"; break;
                                        case 5: to = "sar"; break;
                                        case 6: to = "eur"; break;
                                        case 7:
                                            System.out.println("Operation cancelled.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Try again.");
                                            continue;
                                    }
                                    break;
                                }

                                Optional<Double> converted = Currencies.convert(amount, from, to);

                                if (converted.isPresent()) {
                                    System.out.println(amount + " " + from + " = "
                                            + converted.get() + " " + to);
                                } else {
                                    System.out.println("Invalid currency type entered.");
                                }
                                break;
                            case 9:
                                System.out.println("Logged Out");
                                break;
                        }

                        if (userChoice == 9) break;
                    }

                    break;



                case 2:
                    System.out.println("Enter Username");
                    String adminUser = input.nextLine();
                    System.out.println("Enter Password");
                    String adminPass = input.nextLine();
                    System.out.println("\nAdmin Login Successful\n");
                    while (true) {
                        System.out.println("Press 1: View All Customers");
                        System.out.println("Press 2: View All Accounts");
                        System.out.println("Press 3: View Log File");
                        System.out.println("Press 4: Unblock User");
                        System.out.println("Press 5: Reset Customer Password");
                        System.out.println("Press 6: Exit Admin Menu");

                        int choice = Integer.parseInt(input.nextLine());

                        switch (choice) {
                            case 1:
                                for (String s : customers.keySet()) System.out.println(s);
                                break;

                            case 2:
                                for (String s : loadedAccounts.keySet()) System.out.println(s);
                                break;
                            case 3:
                                try {
                                    File f = new File("log.txt");
                                    Scanner fs = new Scanner(f);
                                    while (fs.hasNextLine()) System.out.println(fs.nextLine());
                                } catch (Exception e) {}
                                break;

                            case 4:
                                System.out.println("Enter username to unblock:");
                                String u = input.nextLine();
                                lockTimes.remove(u);
                                wrongAttempts.put(u, 0);
                                System.out.println("User unblocked.");
                                break;

                            case 5:
                                System.out.println("Enter user to reset password:");
                                String reset = input.nextLine();
                                if (customers.containsKey(reset)) {
                                    Customer old = customers.get(reset);
                                    System.out.println("Enter new password:");
                                    String np = input.nextLine();
                                    SecretKey newKey = PasswordEncryptor.generateSecretKey();
                                    String newEnc = PasswordEncryptor.encrypt(np, newKey);
                                    String newKeyStr = PasswordEncryptor.keyToString(newKey);
                                    Customer updated = new Customer(
                                            old.getUserName(),
                                            old.getinitialAmount(),
                                            old.getName(),
                                            old.getEmail(),
                                            newEnc,
                                            newKeyStr,
                                            old.cpr(),
                                            old.dateOfBirth()
                                    );
                                    updated.setSavingCard(old.getSavingCard());
                                    updated.setCheckingCard(old.getCheckingCard());
                                    customers.put(reset, updated);
                                    fileMethods.saveCustomer(updated, "c.txt");
                                    System.out.println("Password reset successfully.");
                                }
                                break;

                            case 6:
                                System.out.println("Exiting Admin Menu\n");
                                break;
                        }

                        if (choice == 6) break;
                    }

                    break;

                case 3:
                    System.out.println("Enter userName");
                    String customerUserName = input.nextLine();
                    System.out.println("Enter name");
                    String name = input.nextLine();

                    System.out.println("Enter Email");
                    String customerEmail = input.nextLine();
                    System.out.println("Enter Password");
                    String customerPassword = input.nextLine();

                    SecretKey generateSecretKey = PasswordEncryptor.generateSecretKey();
                    String encryptedPass = PasswordEncryptor.encrypt(customerPassword, generateSecretKey);
                    String secretKeyString = PasswordEncryptor.keyToString(generateSecretKey);

                    System.out.println("Enter cpr");
                    long customerCpr = input.nextLong();

                    LocalDate customerDateOfBirth = null;
                    boolean isValid = false;
                    System.out.println("Enter Date Of Birth in yyyy-MM-dd format");

                    while (!isValid) {
                        String dateInput = input.next();
                        try {
                            customerDateOfBirth = LocalDate.parse(dateInput);
                            isValid = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid format. Try again:");
                        }
                    }

                    Customer c1 = new Customer(
                            customerUserName,
                            0.0,
                            name,
                            customerEmail,
                            encryptedPass,
                            secretKeyString,
                            customerCpr,
                            customerDateOfBirth
                    );
                    customers.put(customerUserName, c1);
                    fileMethods.saveCustomer(c1, "c.txt");
                    System.out.println("Thank you for creating an account.\n");
                    input.nextLine();
                    break;
            }
        }
    }
}
