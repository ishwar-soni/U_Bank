package com.upgrad.ubank;

public class Account {
    private int accountNo;
    private String password;
    private int balance;

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  "AccountNo: " + accountNo + "\n" +
                "Balance: " + balance;
    }
}
