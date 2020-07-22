package com.upgrad.ubank.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServiceLoader implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.upgrad.ubank.services.AccountServiceImpl");
            Class.forName("com.upgrad.ubank.services.TransactionServiceImpl");
            Class.forName("com.upgrad.ubank.services.TransactionServiceImplMobile");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
