<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/1
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user2" method="post">
  用户名： <input type="text" name="username" value="${command.username}"/><br/>
  真实姓名：<input type="text" name="realname" value="${command.realname}"/><br/>
  <input type="submit" name="create" value="新增"/>
</form>
</body>
</html>
