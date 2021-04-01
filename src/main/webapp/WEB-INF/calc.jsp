<%--
  Created by IntelliJ IDEA.
  User: Cheha
  Date: 3/18/2021
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-display-middle">
    <form method="post">

        <p class="w3-large w3-center">${task.randNumber1} + ${task.randNumber2} = <input class="w3-large" type="number"
                                                                                         name="result">
        </p>
        <p class="w3-large  w3-left-align ">
            <button type="submit">Submit</button>
        </p>

    </form>
</div>
</body>
</html>
