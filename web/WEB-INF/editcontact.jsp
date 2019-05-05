<%--
  Created by IntelliJ IDEA.
  User: infosec
  Date: 4/18/19
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></style>
    <title>Edit Contact</title>
</head>
<body>
 <div class = "container">
     <jsp:include page="../header.jsp"></jsp:include>
     <jsp:include page="../navbar.jsp"></jsp:include>

     <h1>Edit Contact</h1>

     <form action="edit" method="post">
         <input type="hidden" id="contactid" name="contactid" value="${contact.contactId}">
         <div class="form-group">
            <label for="firstname">First Name:</label>
             <input type="text" name="firstname" id="firstname" class="form-control" value="${contact.firstName}">
         </div>

         <div class="form-group">
             <label for="lastname">Last Name:</label>
             <input type="text" name="lastname" id="lastname" class="form-control" value="${contact.lastName}">
         </div>

         <div class="form-group">
             <label for="phone">Phone:</label>
             <input type="text" name="phone" id="phone" class="form-control" value="${contact.phone}">
         </div>

         <div class="form-group">
             <label for="email">Email:</label>
             <input type="text" name="email" id="email" class="form-control" value="${contact.email}">
         </div>
         <button type="submit" class="btn btn-primary">Submit</button>
     </form>

 </div>
</body>
</html>
