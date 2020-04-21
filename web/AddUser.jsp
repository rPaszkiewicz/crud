<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add bean.Employee</title>
</head>
<body>
        <form style="text-align: center" action="${pageContext.request.contextPath}/add" method="post">
            Name::<input type="text" name="name"><br>
            <br>
            Last Name::<input type="text" name="lastName"><br>
            <br>
            Email::<input type="email" name="email"><br>
            <br>
            <input type="submit" value="add user"><br>
            <br>
            <a href="${pageContext.request.contextPath}/viewServlet"><strong>See all users</strong></a>
            <a href="${pageContext.request.contextPath}/remove"><strong>Remove user by id</strong></a>
        </form>
</body>
</html>
