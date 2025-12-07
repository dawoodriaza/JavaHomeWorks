package com.bank;

public class StandardMastercard extends Card {

    public StandardMastercard() {
        this.cardType = "StandardMastercard";
    }

    public double withdrawLimit() { return 5000; }
    public double transferLimit() { return 10000; }
    public double ownTransferLimit() { return 20000; }
    public double depositLimit() { return 100000; }
    public double ownDepositLimit() { return 200000; }
}
