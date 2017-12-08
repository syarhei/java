<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 09.12.2017
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="j_security_check">
    <input type="text" name="j_username" placeholder="username" />
    <input type="password" name="j_password" placeholder="password" />
    <input type="submit" value="OK" />
</form>
</body>
</html>
