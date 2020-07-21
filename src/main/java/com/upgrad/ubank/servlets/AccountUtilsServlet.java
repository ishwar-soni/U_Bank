package com.upgrad.ubank.servlets;

import com.upgrad.ubank.dtos.Account;
import com.upgrad.ubank.exceptions.AccountNotFoundException;
import com.upgrad.ubank.exceptions.InsufficientBalanceException;
import com.upgrad.ubank.services.AccountService;
import com.upgrad.ubank.services.AccountServiceImpl;
import com.upgrad.ubank.services.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/utils")
public class AccountUtilsServlet extends HttpServlet {

    private AccountService accountService;
    private ServiceFactory serviceFactory;

    @Override
    public void init() throws ServletException {
        serviceFactory = new ServiceFactory();
        accountService = serviceFactory.getAccountService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        int accountNo = (Integer)req.getSession().getAttribute("accountNo");
        int amount = 0;
        switch (actionType) {
            case "Deposit":
                amount = Integer.parseInt(req.getParameter("amount"));
                try {
                    Account account = accountService.deposit(accountNo, amount);
                    int balance = (Integer)req.getSession().getAttribute("balance");
                    req.getSession().setAttribute("balance", (balance+amount));
                    req.setAttribute("isMessage", true);
                    req.setAttribute("message", "Money successfully deposited into account.");
                    req.getRequestDispatcher("/Home.jsp").forward(req, resp);
                } catch (AccountNotFoundException e) {
                    req.setAttribute("isError", true);
                    req.setAttribute("error", e.getMessage());
                    req.getRequestDispatcher("/Home.jsp").forward(req, resp);
                }
                break;

            case "Withdraw":
                amount = Integer.parseInt(req.getParameter("amount"));
                try {
                    Account account = accountService.withdraw(accountNo, amount);
                    int balance = (Integer)req.getSession().getAttribute("balance");
                    req.getSession().setAttribute("balance", (balance-amount));
                    req.setAttribute("isMessage", true);
                    req.setAttribute("message", "Money successfully withdrawn from account.");
                    req.getRequestDispatcher("/Home.jsp").forward(req, resp);
                } catch (Exception e) {
                    req.setAttribute("isError", true);
                    req.setAttribute("error", e.getMessage());
                    req.getRequestDispatcher("/Home.jsp").forward(req, resp);
                }
                break;
        }
    }
}
