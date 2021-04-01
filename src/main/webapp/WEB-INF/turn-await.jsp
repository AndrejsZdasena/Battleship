<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="refresh" content="3">
    <title>Battleship - turn</title>
</head>
<body>
<div>
    <h1>${player.name} select cell to fire</h1>
    <table>
        <tr>
            <td></td>
            <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                <td>${col}</td>
            </c:forEach>
        </tr>
        <c:forEach items="1,2,3,4,5,6,7,8,9,10" var="row">
            <tr>
                <td>${row}</td>
                <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                    <c:set var="addr" value="${col}${row}"/>
                    <td class="${player.opponentView[addr]}">
                    </td>
                </c:forEach>

            </tr>
        </c:forEach>
    </table>
    <table class="field">
        <tr>
            <td></td>
            <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                <td>${col}</td>
            </c:forEach>
        </tr>
        <c:forEach items="1,2,3,4,5,6,7,8,9,10" var="row">
            <tr>
                <td>${row}</td>
                <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                    <c:set var="addr" value="${col}${row}"/>
                    <td class="${player.playerField[addr]}"></td>
                </c:forEach>

            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
