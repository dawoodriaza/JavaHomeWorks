package com.bank;

class CheckingAccount extends Account {

    private int overdraftCount = 0;
    private boolean active = true;

    CheckingAccount(String name, double balance) {
        super(name, balance);
    }

    public void addOverdraft() {
        overdraftCount++;
    }

    public int getOverdraftCount() {
        return overdraftCount;
    }

    public void resetOverdrafts() {
        overdraftCount = 0;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean value) {
        active = value;
    }

    public void setOverdraftData(int count, boolean act) {
        this.overdraftCount = count;
        this.active = act;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < -100) {
            System.out.println("Overdraft limit exceeded!");
            return;
        }

        balance -= amount;
        System.out.println(amount + " withdrawn. Current balance: " + balance);
    }
}
