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

<h2>Edit group: </h2>
<form action="/adminexercises" method="post">
    Id: <input type="text" name="id" value="${param.id}"><br>
    Title: <input type="text" name="title"><br>
    Description: <input type="text" name="description"><br>
    <input type="submit" value="edit" name="action"><br>
</form>

<%@include file="footer.jsp"%>
</body>
</html>
