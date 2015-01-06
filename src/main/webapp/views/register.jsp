<%--
  Created by IntelliJ IDEA.
  User: jinchao.xu
  Date: 14-12-19
  Time: 下午2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>注册展示页面</title>
</head>
<body>
<!-- register.jsp -->
<form method="post">
    username:<input type="text" name="username" value="${user.username}"><br/>
    password:<input type="password" name="password"><br/>
    city:<select>
            <c:forEach items="${cityList }" var="city">
                <option>${city}</option>
            </c:forEach>
         </select><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>