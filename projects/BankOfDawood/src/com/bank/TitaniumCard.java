package com.bank;

public class TitaniumCard extends Card {

    public TitaniumCard() {
        this.cardType = "TitaniumCard";
    }

    public double withdrawLimit() { return 10000; }
    public double transferLimit() { return 20000; }
    public double ownTransferLimit() { return 40000; }
    public double depositLimit() { return 100000; }
    public double ownDepositLimit() { return 200000; }
}
