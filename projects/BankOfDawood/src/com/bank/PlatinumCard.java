package com.bank;

public class PlatinumCard extends Card {

    public PlatinumCard() {
        this.cardType = "PlatinumCard";
    }

    public double withdrawLimit() { return 20000; }
    public double transferLimit() { return 40000; }
    public double ownTransferLimit() { return 80000; }
    public double depositLimit() { return 100000; }
    public double ownDepositLimit() { return 200000; }
}
