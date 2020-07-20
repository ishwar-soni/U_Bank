<%
    try {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (!isLoggedIn) {
            response.sendRedirect("/index.jsp");
        }
    } catch (Exception ex) {
        response.sendRedirect("/index.jsp");
    }
%>

<html>
    <head>
        <title>Home</title>
    </head>

    <body>
        Account No: <%= session.getAttribute("accountNo") %>
        <br><br>

        Balance: <%= session.getAttribute("balance") %>
        <br><br>

        <a href="/ubank/Deposit.jsp">Deposit</a>
        <a href="/ubank/Withdraw.jsp">Withdraw</a>
        <a href="/ubank/AccountStatement.jsp">Account Statement</a>
        <br>
        <a href="/ubank/Logout.jsp">Logout</a>
    </body>
</html>