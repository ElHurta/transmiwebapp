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
    <title>Paradas - TransmiApp</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="assets/css/menus.css">
    <link rel="stylesheet" href="assets/css/modal.css">
    <link rel="icon" href="assets/img/transmiLogo.svg">
</head>
<body>
<%@include file='templates/navbar.html'%>
<section class="main_section">
    <c:choose>
        <c:when test = "${sessionScope.Logged=='true'}">
            <h1 class="welcome_title">Paradas Registradas: </h1>
            <div class="info_container">
                <table class="queryTable">
                    <!-- Cabeceras -->
                    <tr>
                        <th>Identificación</th>
                        <th>Nombre</th>
                        <th>Tipo De Parada</th>
                        <th>Editar</th>
                    </tr>

                    <!-- Cuerpo -->
                    <c:forEach var="row" items="${paradasList}">
                        <tr>
                            <td><c:out value="${row.getIdParada()}"/></td>
                            <td><c:out value="${row.getnParada()}"/></td>
                            <td><c:out value="${row.getTipoParada()}"/></td>
                            <td><button class="editBtn btnModActParada">🖋️</button></td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <%-- Ingresar Y Actualizar --%>
            <div class="op_container">
                <button id="btnModIngParada">Crear Parada</button>
            </div>

            <div id="ingParadaModal" class="modal">
                <!-- Modal De Creación De Paradas -->
                <div class="modal-content">
                    <span class="close" id="closeIngParadaModal">&times;</span>
                    <div class="modal_form_container">
                        <h1> Registro De Paradas: </h1>
                        <p>Por favor diligencie los siguientes campos</p>

                        <form action="${pageContext.request.contextPath}/paradasServlet" method="post">
                            <input type="hidden" value="insert" name="operation_type" id="operation_type">

                            <label for="parada_nom_ins">Nombre De La Parada</label>
                            <input required type="text" name="parada_nom_ins" id="parada_nom_ins">

                            <label for="parada_type_ins">Tipo de Parada</label>
                            <select name="parada_type_ins" id="parada_type_ins">
                                <option selected value="Portal">Portal</option>
                                <option value="Poste">Poste</option>
                                <option value="Estación">Estación</option>
                            </select>

                            <button type="submit">Registrar Datos</button>
                        </form>

                    </div>

                </div>

            </div>

            <div id="actParadaModal" class="modal">
                <!-- Modal De Actualziación De Paradas -->
                <div class="modal-content">
                    <span class="close" id="closeActParadaModal">&times;</span>
                    <div class="modal_form_container">
                        <h1> Actualización De Paradas: </h1>
                        <p>Por favor diligencie los siguientes campos</p>

                        <form action="${pageContext.request.contextPath}/paradasServlet" method="post">
                            <input type="hidden" value="update" name="operation_type">
                            <input type="hidden" name="parada_id_upd" id="parada_id_upd">

                            <label for="parada_nom_upd">Nombre De La Parada</label>
                            <input required type="text" name="parada_nom_upd" id="parada_nom_upd">

                            <label for="parada_type_upd">Tipo de Parada</label>
                            <select name="parada_type_upd" id="parada_type_upd">
                                <option selected value="Portal">Portal</option>
                                <option value="Poste">Poste</option>
                                <option value="Estación">Estación</option>
                            </select>

                            <button type="submit">Actualizar</button>
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
<script src="js/modalIngParada.js"></script>
<script src="js/modalUpdParada.js"></script>
</body>
</html>
