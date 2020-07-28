package com.upgrad.ubank.services;

import com.upgrad.ubank.dtos.Transaction;
import com.upgrad.ubank.interfaces.Observer;
import com.upgrad.ubank.interfaces.Subject;
import com.upgrad.ubank.utils.Logger;

public class SMSNotificationService implements NotificationService, Observer {

    private static SMSNotificationService instance = new SMSNotificationService();
    private ServiceFactory serviceFactory;
    private Subject accountServiceSubject;

    private SMSNotificationService () {
        serviceFactory = new ServiceFactory();
        accountServiceSubject = (Subject) serviceFactory.getAccountService();
        accountServiceSubject.registerObserver(this);
    }

    public static SMSNotificationService getInstance() {
        if (instance == null) {
            instance = new SMSNotificationService();
        }
        return instance;
    }

    @Override
    public void sendNotification(String message) {
        Logger.log(message);
    }

    @Override
    public void update(Object data) {
        if (data instanceof Transaction) {
            Transaction transaction = (Transaction) data;
            String message = "SMS: " + transaction.toString();
            sendNotification(message);
        }
    }
}
