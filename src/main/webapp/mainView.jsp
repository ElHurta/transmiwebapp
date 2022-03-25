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
    <%@include file='templates/navbar.html'%>
    <section class="main_section">
        <c:choose>
            <c:when test = "${sessionScope.Logged=='true'}">
                <h1 class="welcome_title">Bienvenid@</h1>
                <div class="menu_grid">

                    <div class="menu_card">
                        <img src="assets/img/bus.svg">
                        <p>Clientes</p>
                    </div>

                    <div class="menu_card">
                        <img src="assets/img/tarjeta.svg">
                        <p>Tarjetas</p>
                    </div>

                    <div class="menu_card">
                        <img src="assets/img/ruta.svg">
                        <p>Rutas</p>
                    </div>

                    <div class="menu_card">
                        <img src="assets/img/parada.svg">
                        <p>Paradas</p>
                    </div>

                    <div class="menu_card">
                        <img src="assets/img/persona.svg">
                        <p>Cliente</p>
                    </div>

                    <div class="menu_card">
                        <img src="assets/img/bus.svg">
                        <p>Buses</p>
                    </div>
                </div>
            </c:when>
            <c:when test="${sessionScope.Logged=='false'}">
                <div class="login_warning">
                    <h1 class="welcome_title">Datos de inicio de sesión incorrectos. Inténtalo nuevamente ❤</h1>
                    <a href="${pageContext.request.contextPath}/">Volver al Login</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="login_warning">
                    <h1 class="welcome_title">Por favor Inicia Sesión Para poder continuar</h1>
                    <a href="${pageContext.request.contextPath}/">Volver al Login</a>
                </div>
            </c:otherwise>
        </c:choose>
    </section>

</body>
</html>
