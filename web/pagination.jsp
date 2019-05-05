<%--
  Created by IntelliJ IDEA.
  User: infosec
  Date: 4/19/19
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></style>
</head>
<body>
    <nav aria-label="Pagination">
        <ul class="pagination justify-content-center">
            <c:if test="${currentpage != 1}">
                <li class="page-item"><a class="page-link" href="showcontacts?currentpage=1">Previous</a></li>
            </c:if>
            <c:forEach begin="1" end="${noofpages}" var="i">
                <c:choose>
                    <c:when test="${currentpage eq i}">
                        <li class="page-item active"><a class="page-link" href="showcontacs?currentpage=${i}">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="showcontacts?currentpage=${i}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentpage lt noofpages}">
                <li class="page-item"><a class="page-link" href="showcontacts?currentpage=${currentpage+1}">Next</a></li>
            </c:if>
        </ul>
    </nav>
</body>
</html>
