<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 06/12/2023
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer list</title>
</head>
<body>
<h1>Customers</h1>
<p><a href="/customers?action=create">Create new customer</a></p>
<table border="1">
  <tr>
    <td>Name</td>
    <td>Email</td>
    <td>Address</td>
    <td>Edit</td>
    <td>Remove</td>
  </tr>
  <c:forEach items="$requestScope['customers']}" var="customer">
    <tr>
      <td>${customer.name}</td>
      <td>${customer.getEmail()}</td>
      <td>${customer.getAddress()}</td>
      <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
      <td><a  href="/customers?action=remove&&id=${customer.getId()}">remove</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
