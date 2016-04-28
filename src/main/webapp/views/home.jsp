<%--
  Created by IntelliJ IDEA.
  User: jinchao.xu
  Date: 14-12-17
  Time: 下午3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <%--<c:set var="ctx" value="${pageContext.request.contextPath}"/>--%>
</head>
<body>
Hello, ${message}
<%--<c:out value="${message} "/>--%>
<p/>
<%--
Username: <input type="text" maxlength="20" value="请输入用户名${message}"/>
Password: <input type="password" maxlength="20" value="请输入密码${message}"/>
--%>

<div>
    <form action="user/login" method="post">
        <div class="input-prepend">
            <span class="add-on"><em class="icon-user"></em> </span> <input
                type="text" class="span3" name="j_username"
                value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"
                placeholder="username">

        </div>
        <br>

        <div class="input-prepend">
            <span class="add-on"><em class="icon-lock"></em> </span> <input
                type="password" class="span3" name="j_password"
                placeholder="password">
        </div>
        <br> <input type="submit"
                    value="&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;"
                    class="btn btn-primary" style="margin-right: 154px;width: 250px">
    </form>
</div>
</body>
</html>