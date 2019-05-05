<%--
  Created by IntelliJ IDEA.
  User: infosec
  Date: 4/1/19
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Sign in to PhoneBook</title>
</head>
<body>
    <div class="container">
<%--        <h2>Welcome to PhoneBook</h2>--%>
        <jsp:include page="header.jsp"></jsp:include>
    <form action = "login" method="post">
        <div class = "form-group">
            <label for = "email">Email Address:</label>
            <input type = "email" name = "email" class = "form-control" id = "email">
        </div>

        <div class = "form-group">
            <label for = "pwd">Password:</label>
            <input type = "password" name = "pwd" class = "form-control" id = "pwd">
        </div>

        <div class = "form-group form-check">
            <label class = "form-check-label">
                <input class="form-check-input" type="checkbox">Remember me
            </label>
        </div>
        <button type="submit" class = "btn btn-primary">Submit</button>
    </form>
        <a href = "createaccount.jsp" class = "btn btn-info" role ="button">Sign Up</a>
    </div>
</body>
</html>
