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


<h2>List of groups</h2>

<table >

    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Users</th>
    </tr>
    
    <c:forEach var="element" items="${user_groups}">
        <tr>
            <td>${element.id}</td>
            <td>${element.name}</td>
            <td><a href="/users?id=${element.id}">Users of group ${element.id}</a></td>
        </tr>
    </c:forEach>

</table>


<%@include file="footer.jsp"%>
</body>
</html>
