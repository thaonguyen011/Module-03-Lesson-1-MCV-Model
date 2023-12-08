<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 08/12/2023
  Time: 02:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Manager</title>
    <style>

        h1, h2 {
            text-align: center;
        }
        table {
            margin: 0 auto;
            width: 75%;
            border-collapse: collapse;
        }

        table tr {
            border: 1px solid cornflowerblue;
        }

        table tr td {
            border-right: 1px solid cornflowerblue;
        }

        a {
            text-decoration: none;
            color: black;
        }

        a:hover {
            color: blue;
            cursor: pointer;
        }

    </style>
</head>
<body>
    <h1>Product Manager</h1>
    <h2>
        <a href = "${pageContext.request.contextPath}/products?action=create">Add new product</a>
    </h2>
<div style="align: center;">
    <table style="border: 1px; cellpadding: 10px">
        <caption><h2>List of product</h2></caption>
        <tr style="border: none;">
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Brand</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.brand}</td>
                <td>${product.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
