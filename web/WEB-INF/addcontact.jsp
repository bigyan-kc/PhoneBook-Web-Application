<%--
  Created by IntelliJ IDEA.
  User: infosec
  Date: 4/4/19
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PhoneBook Web App</title>
</head>
<body>
<div class = "container">
    <jsp:include page="../header.jsp"></jsp:include>
    <jsp:include page="../navbar.jsp"></jsp:include>

    <form action="addcontact" method="post">
        <div class="form-group">
            <label for ="firstname">First Name:</label>
            <input type = "text" name="firstName" id="firstname" class="form-control">
        </div>

        <div class="form-group">
            <label for = "lastname">Last Name:</label>
            <input type="text" name="lastName" id="lastName" class="form-control">
        </div>

        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="tel" name="phone" id="phone" class="form-control">
        </div>
        <div class="form-group">
            <label for = "email">Email:</label>
            <input type="email" id="email" name="email" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

</body>
</html>
