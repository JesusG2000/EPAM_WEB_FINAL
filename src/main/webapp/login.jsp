<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="loginForm" method="post" action="/login">
    <label>Username: <input type="text" required placeholder="enter your username" name="name"> </label> <br>
    <label>Password: <input type="password" required placeholder="enter your password" name="password"></label> <br>
    <input type="submit" value="login">
    <p>
        <c:if test="${message !=null}">
            <c:out value="${message}"/>
        </c:if>
    </p>
</form>

<form id="something" method="post" action="/userRegistration">
    <input type="submit" value="registration">
</form>
</body>
</html>
