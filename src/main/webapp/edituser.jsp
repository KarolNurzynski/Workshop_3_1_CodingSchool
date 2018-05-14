<%--
  Created by IntelliJ IDEA.
  User: karnur
  Date: 03.05.18
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
    <style>
        table,th,tr,td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>

<h2>Edit user: </h2>
<form action="/adminusers" method="post">
    Id: <input type="text" name="id" value="${param.id}"><br>
    Username: <input type="text" name="username"><br>
    Email: <input type="text" name="email"><br>
    Password: <input type="text" name="password"><br>
    User group id: <input type="text" name="user_group_id"><br>
    <input type="submit" value="edit" name="action"><br>
</form>

<%@include file="footer.jsp"%>
</body>
</html>
