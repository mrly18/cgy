<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=ISO-8859-1">
    <title>末日流云论坛主页面</title>
</head>
<body>
    <c:choose>
        <c:when test="${'wangmeina' eq user.userName}">
            嗨，猪头王美娜，欢迎来到关爱智障儿童社区！^_^<br/>
            您当前的积分为${user.credits}
        </c:when>
        <c:otherwise>
            嗨，帅哥${user.userName},欢迎来到高智商集中营！您当前的积分为${user.credits}
        </c:otherwise>
    </c:choose>
</body>
</html>
