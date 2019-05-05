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
    <table class = "table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Phone No</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <c:forEach items ="${contacts}" var="contact" varStatus="counter">
                    <tr>
                        <td><c:out value = "${counter.count}"/></td>
                        <td><c:out value = "${contact.firstName}"/></td>
                        <td><c:out value = "${contact.lastName}"/></td>
                        <td><c:out value = "${contact.phone}"/></td>
                        <td><c:out value = "${contact.email}"/></td>
                        <td><a class="btn btn-warning" href="edit?contact_id=${contact.contactId}" role="button">Edit</a> </td>
                        <td><a class="btn btn-danger" href="delete?contact_id=${contact.contactId}" role="button">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        <jsp:include page="../pagination.jsp"></jsp:include>
    </div>

</body>
</html>
