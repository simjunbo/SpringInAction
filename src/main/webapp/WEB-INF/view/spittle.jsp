<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page session="false" %>
</head>
<body>
<h2>Recent Spittles</h2>
<div class="spittleView">
    <div class="spittleMessage">
        <c:out value="${spittle.message}" />
    </div>
    <div>
        <span class="spittleTime">
            <c:out value="${spittle.time}" />
        </span>
    </div>
</div>
</body>
</html>
