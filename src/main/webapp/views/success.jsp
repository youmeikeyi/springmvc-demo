<%--
  Created by IntelliJ IDEA.
  User: jinchao.xu
  Date: 14-12-24
  Time: 下午2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login Success</title>
</head>
<body>
    Success
    ${message}
    <c:if test="true">true</c:if>
    EL phoneNumber:${dataBinderTest.phoneNumber}<br/>
    EL state:${dataBinderTest.state}<br/>
    EL date:${dataBinderTest.date}<br/>
</body>
</html>