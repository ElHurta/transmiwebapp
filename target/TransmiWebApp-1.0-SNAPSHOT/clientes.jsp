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
    <title>Clientes - TransmiApp</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="assets/css/menus.css">
    <link rel="stylesheet" href="assets/css/modal.css">

</head>
<body>
<%@include file='templates/navbar.html'%>
<section class="main_section">
    <c:choose>
        <c:when test = "${sessionScope.Logged=='true'}">
            <h1 class="welcome_title">Clientes Registrados: </h1>
            <div class="info_container">
                <table class="queryTable">
                    <!-- Cabeceras -->
                    <tr>
                        <th>Identificación</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Editar</th>
                    </tr>

                    <!-- Cuerpo -->
                    <c:forEach var="row" items="${clientesList}">
                        <tr>
                            <td><c:out value="${row.idCliente}"/></td>
                            <td><c:out value="${row.nCliente}"/></td>
                            <td><c:out value="${row.apelCliente}"/></td>
                            <td><button class="editBtn btnModActCliente">🖋️</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>


            <%-- Ingresar Y Actualizar --%>
            <div class="op_container">
                <button id="btnModIngCliente">Crear Cliente</button>
            </div>

            <div id="ingClientModal" class="modal">
                <!-- Modal De Creación De Clientes -->
                <div class="modal-content">
                    <span class="close" id="closeIngClientModal">&times;</span>
                    <div class="modal_form_container">
                        <h1> Registro De Clientes: </h1>
                        <p>Por favor diligencie los siguientes campos</p>

                        <form action="${pageContext.request.contextPath}/clientsServlet" method="post">
                            <input type="hidden" value="insert" name="operation_type" id="operation_type">

                            <label for="client_id_ins">Número de Identificación</label>
                            <input required type="text" name="client_id_ins" id="client_id_ins">

                            <label for="client_nom_ins">Nombres Del Cliente</label>
                            <input required type="text" name="client_nom_ins" id="client_nom_ins">

                            <label for="client_apel_ins">Apellidos del Cliente</label>
                            <input required type="text" name="client_apel_ins" id="client_apel_ins">

                            <button type="submit">Registrar Datos</button>
                        </form>

                    </div>

                </div>

            </div>

            <div id="actClientModal" class="modal">
                <!-- Modal De Creación De Clientes -->
                <div class="modal-content">
                    <span class="close" id="closeActClientModal">&times;</span>
                    <div class="modal_form_container">
                        <h1> Actualización De Clientes: </h1>
                        <p>Por favor diligencie los siguientes campos</p>

                        <form action="${pageContext.request.contextPath}/clientsServlet" method="post">
                            <input type="hidden" value="update" name="operation_type">

                            <label for="client_id_upd">Número de Identificación Seleccionado</label>
                            <input disabled type="text" name="client_id_upd" id="client_id_upd">

                            <label for="new_client_id_upd">Número de Identificación</label>
                            <input required type="text" name="new_client_id_upd" id="new_client_id_upd">

                            <label for="client_nom_upd">Nombres Del Cliente</label>
                            <input required type="text" name="client_nom_upd" id="client_nom_upd">

                            <label for="client_apel_upd">Apellidos del Cliente</label>
                            <input required type="text" name="client_apel_upd" id="client_apel_upd">

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
<script src="js/modalIngCli.js"></script>
<script src="js/modalUpdCli.js"></script>
</body>
</html>
