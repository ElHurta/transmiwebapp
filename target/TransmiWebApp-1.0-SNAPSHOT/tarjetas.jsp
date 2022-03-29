<%--
  Created by IntelliJ IDEA.
  User: Hurtado
  Date: 25/03/2022
  Time: 5:01 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarjetas - TransmiApp</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="assets/css/menus.css">
    <link rel="stylesheet" href="assets/css/modal.css">

</head>
<body>
<%@include file='templates/navbar.html'%>
<section class="main_section">
    <c:choose>
        <c:when test = "${sessionScope.Logged=='true'}">
            <h1 class="welcome_title">Tarjetas Registradas: </h1>
            <div class="info_container">
                <table class="queryTable">
                    <!-- Cabeceras -->
                    <tr>
                        <th>Id de Tarjeta</th>
                        <th>Cliente Asociado</th>
                        <th>Saldo Actual</th>
                        <th>Estado</th>
                        <th>Editar</th>
                    </tr>

                    <!-- Cuerpo -->
                    <c:forEach var="row" items="${tarjetasList}">
                        <tr>
                            <td><c:out value="${row.getIdTarjeta()}"/></td>
                            <td><c:out value="${row.getCliente().getIdCliente()} - ${row.getCliente().getnCliente()} ${row.getCliente().getApelCliente()}"/></td>
                            <td><c:out value="${row.getSaldoTarjeta()}"/></td>
                            <td><c:out value="${row.getEstTarjeta()}"/></td>
                            <td><button class="editBtn btnModActCliente">🖋️</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>


            <%-- Ingresar Y Actualizar --%>
            <div class="op_container">
                <button id="btnModIngTarjeta">Crear Tarjeta</button>
            </div>

            <div id="ingTarjModal" class="modal">
                <!-- Modal De Creación De Clientes -->
                <div class="modal-content">
                    <span class="close" id="closeIngTarjModal">&times;</span>
                    <div class="modal_form_container">
                        <h1> Registro De Tarjetas: </h1>
                        <p>Por favor diligencie los siguientes campos</p>

                        <form action="${pageContext.request.contextPath}/tarjetaServlet" method="post">

                        </form>

                    </div>

                </div>

            </div>

            <div id="actTarjModal" class="modal">
                <!-- Modal De Creación De Tarjetas -->
                <div class="modal-content">
                    <span class="close" id="closeActTarjModal">&times;</span>
                    <div class="modal_form_container">
                        <h1> Actualización De Tarjetas: </h1>
                        <p>Por favor diligencie los siguientes campos</p>

                        <form action="${pageContext.request.contextPath}/tarjetaServlet" method="post">
                            <input type="hidden" value="insert" name="operation_type">

                            <label for="tarjeta_cli_ins">Cliente Asociado a la Tarjeta</label>
                            <select name="tarjeta_cli_ins" id="tarjeta_cli_ins">

                                <option selected></option>

                            </select>

                            <label for="client_nom_ins">Nombres Del Cliente</label>
                            <input required type="text" name="client_nom_ins" id="client_nom_ins">

                            <label for="client_apel_ins">Apellidos del Cliente</label>
                            <input required type="text" name="client_apel_ins" id="client_apel_ins">

                            <button type="submit">Registrar Datos</button>
                        </form>

                    </div>

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
<script src="js/modalIngTarj.js"></script>
</body>
</html>