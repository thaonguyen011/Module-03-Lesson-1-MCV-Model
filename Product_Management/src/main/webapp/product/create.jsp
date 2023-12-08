<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 08/12/2023
  Time: 02:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="products?action=products">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Add New Product</h2>
      </caption>
      <tr>
        <th>Product name:</th>
        <td>
          <input type="text" name="name" id="name" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Product price:</th>
        <td>
          <input type="text" name="price" id="price" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Product brand:</th>
        <td>
          <input type="text" name="brand" id="brand" size="15"/>
        </td>
      </tr>
      <tr>
        <th>Product description:</th>
        <td>
          <input type="text" name="description" id="description" size="15"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
