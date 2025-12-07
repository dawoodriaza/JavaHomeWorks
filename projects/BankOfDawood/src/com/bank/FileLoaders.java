package com.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

import static com.bank.StartingPoint.customers;
import static com.bank.StartingPoint.loadedAccounts;

public class FileLoaders {

    public static Card createCard(String type) {
        switch (type) {
            case "PlatinumCard": return new PlatinumCard();
            case "TitaniumCard": return new TitaniumCard();
            case "StandardMastercard": return new StandardMastercard();
            default: return null;
        }
    }



    public static void loadCustomers() {
        File file = new File("c.txt");

        if (!file.exists() || file.length() == 0) {
            System.out.println("No customer file found.");
            return;
        }

        try {
            Files.lines(file.toPath())
                    .skip(1)
                    .filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        try {
                            String[] p = line.split(",");

                            if (p.length < 10) {
                                System.out.println("Skipping bad customer row: " + line);
                                return;
                            }
                            String userName = p[0].trim();
                            String name = p[1].trim();
                            String email = p[2].trim();
                            long cpr = Long.parseLong(p[3].trim());
                            LocalDate dob = LocalDate.parse(p[4].trim());
                            String password = p[5].trim();
                            String secretKey = p[6].trim();
                            double initialAmount = Double.parseDouble(p[7].trim());

                            Customer c = new Customer(
                                    userName,
                                    initialAmount,
                                    name,
                                    email,
                                    password,
                                    secretKey,
                                    cpr,
                                    dob
                            );

                            String savingCardType = p[8].trim();
                            String checkingCardType = p[9].trim();

                            if (!savingCardType.equals("noAccount")) {
                                c.setSavingCard(createCard(savingCardType));
                            }
                            if (!checkingCardType.equals("noAccount")) {
                                c.setCheckingCard(createCard(checkingCardType));
                            }
                            customers.put(userName, c);

                        } catch (Exception ex) {
                            System.out.println("Invalid row skipped: " + line);
                        }
                    });

            System.out.println("Customers loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }


    public static void loadAccounts() {
        File file = new File("accounts.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            boolean skip = true;

            while ((line = br.readLine()) != null) {

                if (skip) { skip = false; continue; } // skip header

                String[] p = line.split(",");
                if (p.length < 4) continue;

                String name = p[0];
                double bal = Double.parseDouble(p[1]);
                int overdraftCount = Integer.parseInt(p[2]);
                boolean active = Boolean.parseBoolean(p[3]);

                Account acc;

                if (name.contains("_CHECKING")) {
                    CheckingAccount ch = new CheckingAccount(name, bal);
                    ch.setOverdraftData(overdraftCount, active);
                    acc = ch;
                } else {
                    acc = new SavingAccount(name, bal);
                }

                loadedAccounts.put(name, acc);
            }

        } catch (Exception e) {
            System.out.println("Error loading accounts.");
        }
    }


    public static void loadCards() {
        for (String name : customers.keySet()) {
            Customer c = customers.get(name);

            if (c.getSavingCard() == null)
                c.setSavingCard(new StandardMastercard());

            if (c.getCheckingCard() == null)
                c.setCheckingCard(new StandardMastercard());
        }
    }


    public static void loadCardUsage() {
        File file = new File("cardusage.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] p = line.split(",");
                if (p.length < 7) continue;

                String name = p[0];

                Customer c = customers.get(name);
                if (c == null) continue;

                Card card = p[1].equals("TitaniumCard") ? c.getCheckingCard() : c.getSavingCard();

                card.todayWithdrawTotal = Double.parseDouble(p[2]);
                card.todayTransferTotal = Double.parseDouble(p[3]);
                card.todayOwnTransferTotal = Double.parseDouble(p[4]);
                card.todayDepositTotal = Double.parseDouble(p[5]);
                card.todayOwnDepositTotal = Double.parseDouble(p[6]);
            }

        } catch (Exception e) {
            System.out.println("Error loading card usage.");
        }
    }


    public static void loadOverdraftData() {
        for (String name : loadedAccounts.keySet()) {

            Account acc = loadedAccounts.get(name);

            if (acc instanceof CheckingAccount ch) {
                ch.setOverdraftData(ch.getOverdraftCount(), ch.isActive());
            }
        }
    }
}
