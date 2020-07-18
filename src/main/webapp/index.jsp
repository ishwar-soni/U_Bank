<html>
    <head>
        <title>U-Bank</title>
    </head>

    <body>
        <form method="POST" action="/home">
            <table>
                <tr>
                    <td><label for="accountNo">Account No:</label></td>
                    <td><input type="number" placeholder="123456" required name="accountNo" id="accountNo"/></td>
                </tr>

                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" placeholder="********" required name="password" id="password"/></td>
                </tr>
            </table>

            <input type="submit" value="Log In" name="actionType"/>
            <input type="submit" value="Register" name="actionType"/>
        </form>
    </body>
</html>