<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>末日流云论坛登录</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"/></font>
    </c:if>
    <form action="<c:url value='/loginCheck.html'/>" method="post">
        用户名：<input type="text" name="userName"/><br/>
        密 码：<input type="password" name="password"/><br/>
        <input type="submit" value="登 录"/>
        <input type="reset" value="充 值"/>
    </form>
</body>
</html>
