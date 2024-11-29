<%--
  Created by IntelliJ IDEA.
  User: Mr Loc
  Date: 11/29/2024
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Students</h1>
<p>
    <a href="/students?action=create">Add New Student</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Score</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["students"]}' var="student">
        <tr>
            <td><a href="/students?action=view&id=${student.getId()}">${student.getName()}</a></td>
            <td>${student.getScore()}</td>
            <td><a href="/students?action=edit&id=${student.getId()}">Edit</a></td>
            <td><a href="/students?action=delete&id=${student.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>