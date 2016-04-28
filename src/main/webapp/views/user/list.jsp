<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/1
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/create">用户新增</a><br/>
<table border="1" width="50%">
  <tr>
    <th>用户名</th>
    <th>真实姓名</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${userList}" var="user">
    <tr>
      <td>${user.username }</td>
      <td>${user.realname }</td>
<td>
  <a href="${pageContext.request.contextPath}/user/update?username=${user.username}">
    更新</a>
  |
  <a href="${pageContext.request.contextPath}/user/delete?username=${user.username}">
    删除</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
