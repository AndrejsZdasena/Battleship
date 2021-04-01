<%--
  Created by IntelliJ IDEA.
  User: Cheha
  Date: 3/26/2021
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> ${message}</h1>
<p class="w3-large w3-center">${task.randNumber1} + ${task.randNumber2} = ${task.expectedResult}</p>
<p>Was entered ${task.actualResult}</p>
</body>
</html>
