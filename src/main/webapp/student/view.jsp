<%--
  Created by IntelliJ IDEA.
  User: Mr Loc
  Date: 11/29/2024
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Student</title>
</head>
<body>
<h1>Student Details</h1>
<p>
    <a href="/students">Back to Student List</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["student"].getName()}</td>
    </tr>
    <tr>
        <td>Score: </td>
        <td>${requestScope["student"].getScore()}</td>
    </tr>
</table>
</body>
</html>

