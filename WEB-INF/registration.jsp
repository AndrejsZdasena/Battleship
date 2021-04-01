<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Battleship - registration</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form method="post">
    <c:if test = "${isPlayerNameCorrect}">
        <p>Player name is too short</p>
    </c:if>
    <div class="w3-display-middle">
    <p class="w3-large w3-center">
    <label for="playerNameInput">Enter name</label>
    <input type="text" id = "playerNameInput" name = "playerName" value="${playerName}">
    <input type="password" name = "pwd">
    <button type="submit">Start</button>
    </p>
    </div>
</form>
</body>
</html>
