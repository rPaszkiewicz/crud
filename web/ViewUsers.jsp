<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>View</title>
</head>
<body bgcolor="#fff8dc">
    <table width="80%" >
        <tr>
            <th>Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Id</th>
        </tr>
        <c:forEach var="emp" items="emp">
            <tr>
                <td>${emp.getName()}</td>
                <td>${emp.getLastName()}</td>
                <td>${emp.getEmail()}</td>
                <td>${emp.getId()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
