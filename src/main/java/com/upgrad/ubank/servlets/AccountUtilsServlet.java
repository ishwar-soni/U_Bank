package com.upgrad.ubank.servlets;

import com.upgrad.ubank.dtos.Account;
import com.upgrad.ubank.exceptions.AccountNotFoundException;
import com.upgrad.ubank.services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountUtilsServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = HomeServlet.accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        int accountNo = (Integer)req.getSession().getAttribute("accountNo");
        switch (actionType) {
            case "Deposit":
                int amount = Integer.parseInt(req.getParameter("amount"));
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
        }
    }
}
