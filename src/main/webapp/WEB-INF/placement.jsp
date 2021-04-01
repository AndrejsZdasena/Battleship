<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, td {
            border: 1px solid black;
            text-align: center;
            border-collapse: collapse;
        }

        td {
            width: 2em;
            height: 2em;
        }
        td.SHIP {
            background-color: black;
        }
    </style>
</head>
<body>
<form method="post">
    <h1>${player.name} place your ships</h1>
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
                    <td class="${player.playerField[addr]}"><input type="checkbox" name="addr" value="${addr}"
                    <c:if test="${player.playerField[addr] eq 'SHIP'}"> checked </c:if></td>
                </c:forEach>

            </tr>
        </c:forEach>
    </table>
    <button type="submit">Ready</button>
</form>
</body>
</html>
