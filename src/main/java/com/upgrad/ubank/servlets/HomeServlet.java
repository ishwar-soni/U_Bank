package com.upgrad.ubank.servlets;

import com.upgrad.ubank.dtos.Account;
import com.upgrad.ubank.exceptions.AccountNotFoundException;
import com.upgrad.ubank.exceptions.IncorrectPasswordException;
import com.upgrad.ubank.services.AccountService;
import com.upgrad.ubank.services.AccountServiceImpl;
import com.upgrad.ubank.services.TransactionService;
import com.upgrad.ubank.services.TransactionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    public static AccountService accountService;
    public static TransactionService transactionService;

    @Override
    public void init() throws ServletException {
        transactionService = new TransactionServiceImpl();
        accountService = new AccountServiceImpl(transactionService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Learn @ Upgrad");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionType = req.getParameter("actionType");
        int accountNo = Integer.parseInt(req.getParameter("accountNo"));
        String password = req.getParameter("password");
        Account account = new Account();
        account.setAccountNo(accountNo);
        account.setPassword(password);
        switch (actionType) {
            case "Log In":
                try {
                    accountService.login(account);
                    req.getSession().setAttribute("isLoggedIn", true);
                    req.getSession().setAttribute("accountNo", accountNo);
                    req.getSession().setAttribute("balance", accountService.getAccount(accountNo).getBalance());
                    req.getRequestDispatcher("/Home.jsp").forward(req, resp);
                } catch (Exception e) {
                    req.setAttribute("isError", true);
                    req.setAttribute("error", e.getMessage());
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
                break;

            case "Register":
                try {
                    accountService.register(account);
                    req.getSession().setAttribute("isLoggedIn", true);
                    req.getSession().setAttribute("accountNo", accountNo);
                    req.getSession().setAttribute("balance", accountService.getAccount(accountNo).getBalance());
                    req.getRequestDispatcher("/Home.jsp").forward(req, resp);
                } catch (Exception e) {
                    req.setAttribute("isError", true);
                    req.setAttribute("error", e.getMessage());
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
                break;

            default:
                System.out.println("No such action type");
                break;
        }
    }
}