<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>用户确认</title>
</head>

<body>
<%
    if(session.getAttribute("loginSuccess") == null){
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "login.html");
    }
    else{
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "doctor.html");
    }
%>
</body>

</html>