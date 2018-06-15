<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<c:out value="${spitter.userName}"/><br/>
<c:out value="${spitter.firstName}"/><br/>
<c:out value="${spitter.lastName}"/>
</body>
</html>
