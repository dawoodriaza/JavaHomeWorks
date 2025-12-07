package com.bank;

public abstract class Card {

    public String cardType;

    public double todayWithdrawTotal = 0;
    public double todayTransferTotal = 0;
    public double todayOwnTransferTotal = 0;
    public double todayDepositTotal = 0;
    public double todayOwnDepositTotal = 0;

    public abstract double withdrawLimit();
    public abstract double transferLimit();
    public abstract double ownTransferLimit();
    public abstract double depositLimit();
    public abstract double ownDepositLimit();

    public boolean canWithdraw(double amt) {
        return todayWithdrawTotal + amt <= withdrawLimit();
    }

    public boolean canTransfer(double amt) {
        return todayTransferTotal + amt <= transferLimit();
    }

    public boolean canTransferOwn(double amt) {
        return todayOwnTransferTotal + amt <= ownTransferLimit();
    }

    public boolean canDeposit(double amt) {
        return todayDepositTotal + amt <= depositLimit();
    }

    public boolean canDepositOwn(double amt) {
        return todayOwnDepositTotal + amt <= ownDepositLimit();
    }

    public void recordWithdraw(double amt) {
        todayWithdrawTotal += amt;
    }

    public void recordTransfer(double amt) {
        todayTransferTotal += amt;
    }

    public void recordTransferOwn(double amt) {
        todayOwnTransferTotal += amt;
    }

    public void recordDeposit(double amt) {
        todayDepositTotal += amt;
    }

    public void recordDepositOwn(double amt) {
        todayOwnDepositTotal += amt;
    }
}
