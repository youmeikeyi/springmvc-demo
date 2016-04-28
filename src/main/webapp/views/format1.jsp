<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/26
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
totalCount:<spring:bind path="model.totalCount">${model.totalCount}</spring:bind><br/>
discount:<spring:bind path="model.discount">${status.value}</spring:bind><br/>
sumMoney:<spring:bind path="model.sumMoney">${status.value}</spring:bind><br/>
phoneNumber:<spring:bind path="model.phoneNumber">${status.value}</spring:bind><br/>
<!-- 如果没有配置org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor将
会报错 -->
phoneNumber:<spring:eval expression="model.phoneNumber"></spring:eval><br/>
<br/><br/>
<form:form commandName="model">
  <form:input path="phoneNumber"/><br/>
  <form:input path="sumMoney"/>
</form:form>
</body>
</html>
