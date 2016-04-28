<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/6
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>New Sponsor</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>New Car</h1>

<form:form method="post">

    Brand<br />
    <form:select path="brand">
        <form:options items="${brandList}" itemLabel="name" itemValue="id"/>
    </form:select>
    <br/><br/>

    Model<br />
    <form:input path="model" cssClass="error"/><br/><br/>

    Price<br />
    <form:input path="price" cssClass="error"/><br/><br/>

    <input type="submit" value="Submit">

</form:form>
</body>
</html>