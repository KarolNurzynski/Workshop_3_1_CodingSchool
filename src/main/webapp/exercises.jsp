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


<h2>List of exercises</h2>

<table >
    private int id;
    private String title;
    private String description;
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
    </tr>
    
    <c:forEach var="element" items="${exercises}">
        <tr>
            <td>${element.id}</td>
            <td>${element.name}</td>
            <td>${element.description}</td>
        </tr>
    </c:forEach>

</table>


<%@include file="footer.jsp"%>
</body>
</html>
