<%--
  Created by IntelliJ IDEA.
  User: Mr Loc
  Date: 11/29/2024
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>
<h1>Delete Student</h1>
<p>
    <a href="/students">Back to Student List</a>
</p>
<form method="post">
    <h3>Are you sure you want to delete this student?</h3>
    <fieldset>
        <legend>Student Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["student"].getName()}</td>
            </tr>
            <tr>
                <td>Score: </td>
                <td>${requestScope["student"].getScore()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Student"></td>
                <td><a href="/students">Cancel</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
