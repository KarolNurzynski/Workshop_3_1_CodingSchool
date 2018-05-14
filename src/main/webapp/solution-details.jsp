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


<h2>Solution details</h2>

<table >
    <tr>
        <th>Id</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Description</th>
        <th>Exercise id</th>
        <th>Users id</th>
    </tr>
        <tr>
            <td>${solution.id}</td>
            <td>${solution.created}</td>
            <td>${solution.updated}</td>
            <td>${solution.description}</td>
            <td>${solution.exercise_id}</td>
            <td>${solution.users_id}</td>
        </tr>
</table>


<%@include file="footer.jsp"%>
</body>
</html>
