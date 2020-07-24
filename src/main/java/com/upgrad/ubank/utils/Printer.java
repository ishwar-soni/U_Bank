package com.upgrad.ubank.utils;

import com.upgrad.ubank.dtos.Account;
import com.upgrad.ubank.dtos.Transaction;

public class Printer {
    public void print (Object[] objects) {
        for (Object obj: objects) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setAccountNo(400001);
        account1.setPassword("ishwar123");
        account1.setBalance(1000);

        Account account2 = new Account();
        account2.setAccountNo(400002);
        account2.setPassword("ishwar234");
        account2.setBalance(1000);

        Transaction transaction1 = new Transaction();
        transaction1.setAccountNo(400001);
        transaction1.setDate("DD/MM/YYYY");
        transaction1.setAction("Deposit");
        transaction1.setAmount(1000);

        Transaction transaction2 = new Transaction();
        transaction2.setAccountNo(400001);
        transaction2.setDate("DD/MM/YYYY");
        transaction2.setAction("Withdraw");
        transaction2.setAmount(1000);

        Account[] accounts = {account1, account2};
        Transaction[] transactions = {transaction1, transaction2};

        Printer printer = new Printer();
        printer.print(accounts);
        printer.print(transactions);

        Object[] objects = {account1, transaction1};
        printer.print(objects);
    }
}
