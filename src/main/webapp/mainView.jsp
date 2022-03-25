<%--
  Created by IntelliJ IDEA.
  User: Hurtado
  Date: 24/03/2022
  Time: 10:12 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Principal - TransmiApp</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/mainMenu.css">
</head>
<body>
    <nav>
        <ul>
            <li><a href="/">Clientes</a></li>
            <li><a href="/">Tarjetas</a></li>
            <li><a href="/">Rutas</a></li>
            <li><a href="/">Paradas</a></li>
            <li><a href="/">Buses</a></li>
        </ul>
    </nav>
    <section class="main_section">
        <h1 class="welcome_title">Bienvenid@</h1>
        <div class="menu_grid">

            <div class="menu_card">
                <img src="assets/img/bus.svg">
                <p>Clientes</p>
            </div>

            <div class="menu_card">
                <img src="assets/img/bus.svg">
                <p>Tarjetas</p>
            </div>

            <div class="menu_card">
                <img src="assets/img/bus.svg">
                <p>Rutas</p>
            </div>

            <div class="menu_card">
                <img src="assets/img/bus.svg">
                <p>Paradas</p>
            </div>

            <div class="menu_card">
                <img src="assets/img/bus.svg">
                <p>Buses</p>
            </div>

            <div class="menu_card">
                <img src="assets/img/bus.svg">
                <p>Buses</p>
            </div>
        </div>
        <c:choose>
            <c:when test = "${sessionScope.Logged==true}">
                <h2>AAAA</h2>
            </c:when>
            <c:otherwise>
                null
            </c:otherwise>
        </c:choose>
    </section>

</body>
</html>