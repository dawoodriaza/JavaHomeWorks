package com.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class fileMethods {

    private static final String HEADER =
            "UserName , Name, Email , CPR , DateOfBirth , Password , SecretKey , InitialAmount , SavingCard , CheckingCard ";



    private static final String HEADER2 =
            "AccountType, CurrentAmount , OverDraftCount , AccountStatus ";


    private static final String HEADER3 =
            "userName, cardType , todayWithdrawTotal , todayTransferTotal , todayOwnTransferTotal , todayDepositTotal , todayOwnDepositTotal ";

    /*
     *
     *
     *
     *
     * */

    public static void saveCustomer(Customer user, String filePath) {
        File file = new File(filePath);


        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(HEADER);
                bw.newLine();
            } catch (Exception e) {}
        }

        try {
            List<String> updated = Files.readAllLines(file.toPath());
            boolean found = false;

            String fullRow =
                    user.getUserName() + "," +
                            user.getName() + "," +
                            user.getEmail() + "," +
                            user.cpr() + "," +
                            user.dateOfBirth() + "," +
                            user.getPassword() + "," +
                            user.getSecretKeyString() + "," +
                            user.getinitialAmount() + "," +
                            (user.getSavingCard() == null ? "noAccount" : user.getSavingCard().getClass().getSimpleName()) + "," +
                            (user.getCheckingCard() == null ? "noAccount" : user.getCheckingCard().getClass().getSimpleName());


            for (int i = 1; i < updated.size(); i++) {
                String[] p = updated.get(i).split(",");
                if (p[0].equals(user.getUserName())) {
                    updated.set(i, fullRow);
                    found = true;
                    break;
                }
            }


            if (!found) {
                updated.add(fullRow);
            }

            Files.write(file.toPath(), updated);

        } catch (Exception e) {
            System.out.println("Error saving customer: " + e.getMessage());
        }
    }



    public static void saveAccounts(String name, double balance, int overdraftCount, boolean active) {
        File file = new File("accounts.txt");

        try {

            if (!file.exists() || file.length() == 0) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(HEADER2);
                    bw.newLine();
                } catch (Exception e) {}
            }

            List<String> updated = file.exists() ? Files.readAllLines(file.toPath()) : List.of();
            boolean found = false;

            for (int i = 0; i < updated.size(); i++) {
                String[] p = updated.get(i).split(",");
                if (p[0].equals(name)) {
                    updated.set(i, name + "," + balance + "," + overdraftCount + "," + active);
                    found = true;
                    break;
                }
            }

            if (!found) {
                updated.add(name + "," + balance + "," + overdraftCount + "," + active);
            }

            Files.write(file.toPath(), updated);

        } catch (Exception e) {}
    }


    public static void updateBalanceInFile(String name, double balance, int overdraftCount, boolean active) {
        saveAccounts(name, balance, overdraftCount, active);
    }

    public static void saveCardUsage(String name, Card card) {
        File file = new File("cardusage.txt");
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(HEADER3);
                bw.newLine();
            } catch (Exception e) {}
        }

        try {
            List<String> updated = file.exists() ? Files.readAllLines(file.toPath()) : List.of();
            boolean found = false;

            for (int i = 0; i < updated.size(); i++) {
                String[] p = updated.get(i).split(",");
                if (p[0].equals(name)) {
                    updated.set(i,
                            name + "," +
                                    card.cardType + "," +
                                    card.todayWithdrawTotal + "," +
                                    card.todayTransferTotal + "," +
                                    card.todayOwnTransferTotal + "," +
                                    card.todayDepositTotal + "," +
                                    card.todayOwnDepositTotal
                    );
                    found = true;
                    break;
                }
            }

            if (!found) {
                updated.add(
                        name + "," +
                                card.cardType + "," +
                                card.todayWithdrawTotal + "," +
                                card.todayTransferTotal + "," +
                                card.todayOwnTransferTotal + "," +
                                card.todayDepositTotal + "," +
                                card.todayOwnDepositTotal
                );
            }

            Files.write(file.toPath(), updated);

        } catch (Exception e) {}
    }

    public static void log(String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))) {
            bw.write(message);
            bw.newLine();
        } catch (Exception e) {}
    }


    public static void printLogFile(String userName, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains(userName)) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void printStatement(String userName, BankOfDawood bank) {

        Account saving = bank.accounts.get(userName + "_SAVING");
        Account checking = bank.accounts.get(userName + "_CHECKING");
        System.out.println("---------BANK OF DAWOOD ---T----");
        System.out.println("---------BANK STATEMENT ---T----");
        System.out.println("User: " + userName);
        System.out.println("------------------------------");

        if (saving != null)
            System.out.println("Saving Account Balance: " + saving.balance);
        else
            System.out.println("Saving Account: Not Opened");

        if (checking != null)
            System.out.println("Checking Account Balance: " + checking.balance);
        else
            System.out.println("Checking Account: Not Opened");

        System.out.println("------------------------------");
        System.out.println(" TRANSACTIONS —");
        printLogFile(userName, "log.txt");

        System.out.println("=======================================");
    }

}
