package com.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankOfDawood implements Bank {

    public Map<String, Account> accounts = new HashMap<>();
    LocalDate timeNow = LocalDate.now();

    @Override
    public void createAccount(String UserName, String accountType, double initialDeposit) {
        accountType = accountType.toUpperCase();

        if (accounts.containsKey(UserName + "_" + accountType)) {
            System.out.println("Account already exists.");
            return;
        }

        Customer cus = StartingPoint.customers.get(UserName);
        if (cus == null) {
            System.out.println("Customer not found.");
            return;
        }

        Account acc;

        if (accountType.equals("SAVING")) {
            acc = new SavingAccount(UserName, initialDeposit);
            cus.setSavingCard(new StandardMastercard());
            cus.setSavingAccount(acc);

        } else if (accountType.equals("CHECKING")) {
            acc = new CheckingAccount(UserName, initialDeposit);
            cus.setCheckingCard(new StandardMastercard());
            cus.setCheckingAccount(acc);

        } else {
            System.out.println("Invalid account type.");
            return;
        }

        accounts.put(UserName + "_" + accountType, acc);

        fileMethods.saveCustomer(cus, "c.txt");

        if (acc instanceof CheckingAccount ch) {
            fileMethods.saveAccounts(UserName + "_CHECKING", acc.balance, ch.getOverdraftCount(), ch.isActive());
        } else {
            fileMethods.saveAccounts(UserName + "_SAVING", acc.balance, 0, true);
        }

        System.out.println(accountType + " account created for " + UserName);
    }


    @Override
    public void deposit(String userName) {
        Scanner sc = new Scanner(System.in);
        String type = "";

        while (true) {
            System.out.println("Choose Account Type:");
            System.out.println("1. Saving");
            System.out.println("2. Checking");
            System.out.println("3. Go Back");
            System.out.print("Enter: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1": type = "SAVING"; break;
                case "2": type = "CHECKING"; break;
                case "3": return;
                default: System.out.println("Invalid choice."); continue;
            }
            break;
        }

        Account acc = accounts.get(userName + "_" + type);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        double preBalance = acc.balance;

        System.out.println("Enter Amount");
        double amt = Double.parseDouble(sc.nextLine());

        Customer c = StartingPoint.customers.get(userName);
        Card card = type.equals("SAVING") ? c.getSavingCard() : c.getCheckingCard();

        if (!card.canDeposit(amt)) {
            System.out.println("Deposit limit exceeded.");
            return;
        }

        card.recordDeposit(amt);
        acc.balance += amt;

        System.out.println(preBalance + " Deposited. Current balance: " + acc.balance);

        fileMethods.log(userName + " Deposited " + amt + ". Previous: "
                + preBalance + " Current: " + acc.balance + " Date " + timeNow);

        fileMethods.logStream(
                userName + "|" +
                        "Deposited " + amt + " BHD on " + timeNow +
                        " Previous: " + preBalance + " | Current: " + acc.balance + "."
        );


        if (acc instanceof CheckingAccount ch) {
            fileMethods.updateBalanceInFile(userName + "_CHECKING",
                    acc.balance, ch.getOverdraftCount(), ch.isActive());
        } else {
            fileMethods.updateBalanceInFile(userName + "_SAVING", acc.balance, 0, true);
        }
        fileMethods.saveCardUsage(userName, card);
    }


    @Override
    public void withdrawAmount(String userName) {
        Scanner sc = new Scanner(System.in);
        String type = "";

        while (true) {
            System.out.println("Choose Account Type:");
            System.out.println("1. Saving");
            System.out.println("2. Checking");
            System.out.println("3. Go Back");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": type = "SAVING"; break;
                case "2": type = "CHECKING"; break;
                case "3": return;
                default: System.out.println("Invalid input."); continue;
            }
            break;
        }

        Account acc = accounts.get(userName + "_" + type);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        double preBalance = acc.balance;

        System.out.println("Enter Amount");
        double amt = Double.parseDouble(sc.nextLine());

        Customer c = StartingPoint.customers.get(userName);
        Card card = type.equals("SAVING") ? c.getSavingCard() : c.getCheckingCard();

        if (!card.canWithdraw(amt)) {
            System.out.println("Withdraw limit exceeded.");
            return;
        }

        if (acc instanceof CheckingAccount ch) {

            if (!ch.isActive()) {
                System.out.println("Checking account deactivated.");
                return;
            }

            if (acc.balance < 0 && amt > 100) {
                System.out.println("Cannot withdraw over 100 while negative.");
                return;
            }

            if (acc.balance < amt) {
                double fee = 35;
                ch.addOverdraft();
                acc.balance -= (amt + fee);

                if (ch.getOverdraftCount() >= 2) ch.setActive(false);

                fileMethods.updateBalanceInFile(userName + "_CHECKING",
                        acc.balance, ch.getOverdraftCount(), ch.isActive());

                System.out.println("Overdraft used. Fee charged. Balance: " + acc.balance);
                return;
            }

            acc.balance -= amt;

            if (acc.balance >= 0 && ch.getOverdraftCount() > 0)
                ch.resetOverdrafts();

            fileMethods.updateBalanceInFile(userName + "_CHECKING",
                    acc.balance, ch.getOverdraftCount(), ch.isActive());
        }

        else {
            if (acc.balance < amt) {
                System.out.println("Insufficient funds.");
                return;
            }

            acc.balance -= amt;

            fileMethods.updateBalanceInFile(userName + "_SAVING", acc.balance, 0, true);
        }

        card.recordWithdraw(amt);
        fileMethods.saveCardUsage(userName, card);

        fileMethods.log(userName + " Withdraw " + amt + ". Prev: "
                + preBalance + " Now: " + acc.balance + " Date " + timeNow);



        fileMethods.logStream(
                userName + "|" +
                        "Withdrawn " + amt + " bhd on " + timeNow +
                        " (Previous: " + preBalance + " | Current: " + acc.balance + ")"
        );


        System.out.println("Withdraw Successful. Balance = " + acc.balance);
    }

    public void filterTransactions(String userName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect logs to filter4");
        System.out.println("1. today");
        System.out.println("2. yesterday");
        System.out.println("3. Last 7 days");
        System.out.println("4. Last 30 Ddays");
        System.out.println("5. custom date range (yyyy-MM-dd)");
        System.out.println("6. Exit");

        int choice = Integer.parseInt(sc.nextLine());

        LocalDate today = LocalDate.now();
        LocalDate start = null, end = null;

        switch (choice) {
            case 1:
                start = today;
                end = today;
                break;

            case 2:
                start = today.minusDays(1);
                end = today.minusDays(1);
                break;

            case 3:
                start = today.minusDays(7);
                end = today;
                break;

            case 4:
                start = today.minusDays(30);
                end = today;
                break;

            case 5:
                System.out.println("Enter Start Date (yyyy-MM-dd): ");
                start = LocalDate.parse(sc.nextLine());

                System.out.println("Enter End Date (yyyy-MM-dd): ");
                end = LocalDate.parse(sc.nextLine());
                break;

            case 6:
                return;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\n=== Showing Transactions from " + start + " to " + end + " ===");

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                if (!line.contains(userName)) continue;

                if (!line.contains("Date")) continue;

                String[] parts = line.split("Date");
                if (parts.length < 2) continue;

                String rawDate = parts[1].trim();

                LocalDate entryDate;
                try {
                    entryDate = LocalDate.parse(rawDate);
                } catch (Exception e) {
                    continue;
                }


                if ((entryDate.isEqual(start) || entryDate.isAfter(start)) &&
                        (entryDate.isEqual(end) || entryDate.isBefore(end))) {

                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            System.out.println("Error filtering: " + e.getMessage());
        }

        System.out.println("======BANK OF DAWOOD STATEMENT======\n");
    }
    @Override
    public double checkBalance(String userName) {
        Scanner sc = new Scanner(System.in);
        String type = "";

        while (true) {
            System.out.println("Choose Account Type:");
            System.out.println("1. Saving");
            System.out.println("2. Checking");
            System.out.println("3. Go Back");
            String ch = sc.nextLine();

            switch (ch) {
                case "1": type = "SAVING"; break;
                case "2": type = "CHECKING"; break;
                case "3": return 0;
                default: System.out.println("Invalid."); continue;
            }
            break;
        }

        Account acc = accounts.get(userName + "_" + type);
        if (acc == null) {
            System.out.println("Account not found.");
            return 0;
        }

        System.out.println("Current Balance = " + acc.balance);
        return acc.balance;
    }


    @Override
    public void transferMoney(String userName) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1: Saving to Checking");
        System.out.println("2: Checking to Saving");
        int ch = Integer.parseInt(sc.nextLine());

        String fromType = (ch == 1) ? "SAVING" : "CHECKING";
        String toType   = (ch == 1) ? "CHECKING" : "SAVING";

        Account from = accounts.get(userName + "_" + fromType);
        Account to = accounts.get(userName + "_" + toType);

        if (from == null || to == null) {
            System.out.println("One account missing.");
            return;
        }

        System.out.println("Enter Amount");
        double amount = Double.parseDouble(sc.nextLine());

        Customer c = StartingPoint.customers.get(userName);
        Card card = fromType.equals("SAVING") ? c.getSavingCard() : c.getCheckingCard();

        if (!card.canTransferOwn(amount)) {
            System.out.println("Transfer limit exceeded.");
            return;
        }

        if (from.balance < amount) {
            System.out.println("Insufficient funds.");
            return;
        }

        from.balance -= amount;
        to.balance += amount;

        card.recordTransferOwn(amount);

        if (from instanceof CheckingAccount x) {
            fileMethods.updateBalanceInFile(userName + "_CHECKING", from.balance, x.getOverdraftCount(), x.isActive());
        }
        else {
            fileMethods.updateBalanceInFile(userName + "_SAVING", from.balance, 0, true);
        }
        if (to instanceof CheckingAccount y) {
            fileMethods.updateBalanceInFile(userName + "_CHECKING", to.balance, y.getOverdraftCount(), y.isActive());
        }
        else {
            fileMethods.updateBalanceInFile(userName + "_SAVING", to.balance, 0, true);
        }

        fileMethods.logStream(
                userName + "|" +
                        "Transferred " + amount + " BHD from " + fromType + " to " + toType +
                        " on " + timeNow +
                        " New " + toType + " Balance: " + to.balance + "."
        );





        System.out.println("Transfer Successful");
    }


    @Override
    public void tansferToOther(String userName) {
        Scanner sc = new Scanner(System.in);

        System.out.println("From Account . saving checking");
        String fromType = sc.nextLine().toUpperCase();

        Account from = accounts.get(userName + "_" + fromType);
        if (from == null) {
            System.out.println("Your account not found.");
            return;
        }

        System.out.println("Receiver Name:");
        String rec = sc.nextLine();

        System.out.println("Receiver Account Type .saving checking)");
        String toType = sc.nextLine().toUpperCase();

        Account to = accounts.get(rec + "_" + toType);

        if (to == null) {
            System.out.println("Receiver account not found.");
            return;
        }

        System.out.println("Enter Amout");
        double amt = Double.parseDouble(sc.nextLine());

        Customer c = StartingPoint.customers.get(userName);
        Card card = fromType.equals("SAVING") ? c.getSavingCard() : c.getCheckingCard();

        if (!card.canTransfer(amt)) {
            System.out.println("Limit exceeded.");
            return;
        }

        if (from.balance < amt) {
            System.out.println("Insufficient funds.");
            return;
        }

        from.balance -= amt;
        to.balance += amt;

        card.recordTransfer(amt);

        if (from instanceof CheckingAccount x)
            fileMethods.updateBalanceInFile(userName + "_CHECKING", from.balance, x.getOverdraftCount(), x.isActive());
        else
            fileMethods.updateBalanceInFile(userName + "_SAVING", from.balance, 0, true);

        if (to instanceof CheckingAccount y)
            fileMethods.updateBalanceInFile(rec + "_CHECKING", to.balance, y.getOverdraftCount(), y.isActive());
        else
            fileMethods.updateBalanceInFile(rec + "_SAVING", to.balance, 0, true);
        fileMethods.logStream(
                userName + "|" +
                        "Sent " + amt + " BHD to " + rec + " (" + toType + ") on " + timeNow +
                        " Your New Balance: " + from.balance + "/"
        );

        System.out.println("Transfer Successful.");
    }


    public void changeCardType(String userName) {
        Customer c = StartingPoint.customers.get(userName);

        System.out.println("Select Account Type:");
        System.out.println("1: Saving Card");
        System.out.println("2: Checking Card");

        Scanner sc = new Scanner(System.in);
        int type = Integer.parseInt(sc.nextLine());

        if (type == 1 && c.getSavingsAccount() == null) {
            System.out.println("You do not have a savings account.");
            return;
        }

        if (type == 2 && c.getCheckingAccount() == null) {
            System.out.println("You do not have a checking account.");
            return;
        }

        System.out.println("Select New Card:");
        System.out.println("1: Platinum");
        System.out.println("2: Titanium");
        System.out.println("3: Standard");

        int cardChoice = Integer.parseInt(sc.nextLine());
        Card newCard = null;

        switch (cardChoice) {
            case 1:
                newCard = new PlatinumCard();
                break;

            case 2:
                newCard = new TitaniumCard();
                break;

            case 3:
                newCard = new StandardMastercard();
                break;

            default:
                newCard = null;
                break;
        }


        if (newCard == null) {
            System.out.println("Invalid card.");
            return;
        }

        if (type == 1){
            c.setSavingCard(newCard);};
        if (type == 2)
        {c.setCheckingCard(newCard);};

        fileMethods.saveCustomer(c, "c.txt");

        System.out.println("Card updated successfully.");
    }


    public void viewCardDetails(String userName) {
        Customer c = StartingPoint.customers.get(userName);

        System.out.println("Saving Account Card: " +
                (c.getSavingCard() == null ? "NONE" : c.getSavingCard().cardType));

        System.out.println("Checking Account Card: " +
                (c.getCheckingCard() == null ? "NONE" : c.getCheckingCard().cardType));
    }


    public void printStatemnt(String userName) {
        System.out.println("----- BANK STATEMENT -----");

        Account saving = accounts.get(userName + "_SAVING");
        Account checking = accounts.get(userName + "_CHECKING");

        if (saving != null)
            System.out.println("Saving Balance: " + saving.balance);
        else
            System.out.println("Saving: No Account");

        if (checking != null)
            System.out.println("Checking Balance: " + checking.balance);
        else
            System.out.println("Checking: No Account");

        System.out.println("----- TRANSACTIONS -----");
        fileMethods.printLogFile(userName, "log.txt");
    }


    public void showMyCards(String userName) {
        Customer c = StartingPoint.customers.get(userName);

        System.out.println("\n====== YOUR CARD DETAILS ======");

        String savingCard = (c.getSavingCard() == null)
                ? "no card or saving account"
                : c.getSavingCard().cardType;

        String checkingCard = (c.getCheckingCard() == null)
                ? "no card or checking account"
                : c.getCheckingCard().cardType;

        System.out.println("saving account card   : " + savingCard);
        System.out.println("checking account card : " + checkingCard);

        System.out.println("===========================\n");
    }
}
