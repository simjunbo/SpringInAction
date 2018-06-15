<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
</head>
<body>
<h1>Register</h1>

<form:form method="POST">
    First Name: <input type="text" name="firstName"/>
    <form:errors  path="firstName"/>
    <br/>
    Last Name: <input type="text" name="lastName"/>
    <form:errors  path="lastName"/>
    <br/>
    Username: <input type="text" name="userName"/>
    <form:errors  path="userName"/>
    <br/>
    Password: <input type="password" name="password"/>
    <form:errors  path="password"/>
    <br/>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>