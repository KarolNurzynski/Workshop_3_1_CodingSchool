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


<h2>User details</h2>

<table >
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Email</th>
        <th>Password</th>
        <th>User group id</th>
    </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.user_group_id}</td>
        </tr>
</table>

<h2>User solutions: </h2>

<table >

    <tr>
        <th>Id</th>
        <th>Updated</th>
        <th>Exercise id</th>
        <th>Solution details</th>
    </tr>

    <c:forEach var="element" items="${solutions}">
        <tr>
            <td>${element.id}</td>
            <td>${element.updated}</td>
            <td>${element.users_id}</td>
            <td><a href="/user-solution-details?id=${element.id}">Solution ${element.id}</a></td>
        </tr>
    </c:forEach>

</table>

<%@include file="footer.jsp"%>
</body>
</html>
