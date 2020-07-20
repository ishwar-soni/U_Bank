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
        <title>Withdraw</title>
    </head>

    <body>
        Account No: <%= session.getAttribute("accountNo") %>
        <br><br>

        Balance: <%= session.getAttribute("balance") %>
        <br><br>

        <form method="POST" action="/utils">
            <label for="amount">Amount:</label>
            <input type="number" placeholder="1000" required name="amount" id="amount"/>
            <br><br>

            <input type="submit" value="Withdraw" name="actionType"/>
            <a href="/Home.jsp">Home</a>
        </form>
    </body>
</html>