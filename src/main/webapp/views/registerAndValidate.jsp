<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/5
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
</head>
<body>
<form:form commandName="user">
    <form:errors path="*" cssStyle="color:red"/><br/>
    username:<form:input path="user.username"/>
    <form:errors path="username" cssStyle="color:red"/>
    <br/>
    password:<form:password path="user.password"/>
    <form:errors path="password" cssStyle="color:red"/>
    <br/>
    <input type="submit" value="注册"/>
</form:form>

</body>
</html>
