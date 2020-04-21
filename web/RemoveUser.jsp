<%--
  Created by IntelliJ IDEA.
  User: Dev Mąż
  Date: 11.03.2020
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove User</title>
</head>
<body>
    <div align="center">
        <h3>Enter user id to remove:</h3><br><br>
        <form action="${pageContext.request.contextPath}/remove" >
            <input type="number" name="id">
            <input type="submit" value="remove">
        </form>
        <a href="AddUser.jsp">Return to add user</a>
        <a href="ViewUsers.jsp">Return to see all users</a>
    </div>
</body>
</html>
