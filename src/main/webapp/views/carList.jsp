<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/6
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Car List</h1>

<c:forEach items="${carList}" var="car">
  ${car.brand.name} ${car.model}: ${car.price}
  <br />
</c:forEach>

</body>
</html>
