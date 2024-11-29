<%--
  Created by IntelliJ IDEA.
  User: Mr Loc
  Date: 11/29/2024
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Edit Student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/students">Back to Student List</a>
</p>
<form method="post">
    <fieldset>
        <legend>Student Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["student"].getName()}" required></td>
            </tr>
            <tr>
                <td>Score: </td>
                <td><input type="number" name="score" id="score" value="${requestScope["student"].getScore()}" step="0.1" required></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

