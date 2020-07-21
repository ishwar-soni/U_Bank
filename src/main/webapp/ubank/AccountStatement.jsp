<%@ page import="com.upgrad.ubank.dtos.Transaction" %>
<%@ page import="com.upgrad.ubank.services.ServiceFactory" %>

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
        <title>Account Statement</title>
    </head>

    <body>
        Account No: <%= session.getAttribute("accountNo") %>
        <br><br>

        Balance: <%= session.getAttribute("balance") %>
        <br><br>

        <a href="/Home.jsp">Home</a>

        <%
            int accountNo = (Integer) session.getAttribute("accountNo");
            Transaction[] transactions = new ServiceFactory().getTransactionService().getTransactions(accountNo);
            if (transactions == null) {
                out.println("This feature is not available for mobile");
                return;
            } else if (transactions[0] == null) {
                out.println("No transaction exists for you.");
                return;
            }
            %>
            <table>
            <%
            for (Transaction transaction: transactions) {
                if (transaction == null) {
                    break;
                }
                %>
                <tr>
                    <td><%= transaction.getDate()%></td>
                    <td><%= transaction.getAction()%></td>
                    <td><%= transaction.getAmount()%></td>
                </tr>
                <%
            }
            %>
            </table>
            <%
        %>
    </body>
</html>