<%--
  Created by IntelliJ IDEA.
  User: karnur
  Date: 19.04.18
  Time: 12:33
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


<h2>List of users: </h2>

<table >

    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Email</th>
        <th>Password</th>
        <th>User group id</th>
        <th>Edit user</th>
    </tr>

    <c:forEach var="element" items="${users}">
        <tr>
            <td>${element.id}</td>
            <td>${element.username}</td>
            <td>${element.email}</td>
            <td>${element.password}</td>
            <td>${element.user_group_id}</td>
            <td><a href="/edituser.jsp?id=${element.id}">Edit user ${element.id}</a></td>
        </tr>
    </c:forEach>

</table>

<h2>Add new user: </h2>
<form action="/adminusers" method="post">
    Username: <input type="text" name="username"><br>
    Email: <input type="text" name="email"><br>
    Password: <input type="text" name="password"><br>
    User group id: <input type="text" name="user_group_id"><br>
    <input type="submit" value="add" name="action">
</form>

<%@include file="footer.jsp"%>
</body>
</html>
