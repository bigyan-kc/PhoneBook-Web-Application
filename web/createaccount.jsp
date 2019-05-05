<%--
  Created by IntelliJ IDEA.
  User: infosec
  Date: 4/3/19
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Create New Account</title>
</head>
<body>
    <div class = "container">
        <jsp:include page="header.jsp"></jsp:include>
        <div class="page-header">
            <h2>Create New Account</h2>
        </div>
        <form action="createaccount" method="post">
            <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class = "form-control" name="email" id="email" placeholder="Enter Email">
                </div>

            <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Enter Password">
            </div>

            <div class="form-group">
                    <label for="repwd">Re-type Password:</label>
                    <input type="password" class="form-control" name="repwd" id="repwd" placeholder="Re-type Password">
            </div>

            <div class="form-group">
                    <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>
</body>
</html>
