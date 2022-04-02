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
    <title>Rutas - TransmiApp</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="assets/css/menus.css">
    <link rel="stylesheet" href="assets/css/modal.css">
    <link rel="icon" href="assets/img/transmiLogo.svg">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Sortable/1.15.0/Sortable.min.js"></script>
</head>
<body>
<%@include file='templates/navbar.html'%>
<section class="main_section">
    <c:choose>
        <c:when test = "${sessionScope.Logged=='true'}">
            <h1 class="welcome_title">Rutas Registradas: </h1>
            <div class="info_container">
                <table class="queryTable">
                    <!-- Cabeceras -->
                    <tr>
                        <th>Id</th>
                        <th>Nombre de Ruta</th>
                        <th>Hora De Inicio</th>
                        <th>Hora De Finalización</th>
                        <th>Paradas</th>
                        <th>Editar</th>
                    </tr>

                    <!-- Cuerpo -->
                    <c:forEach var="row" items="${rutasList}">
                        <tr>
                            <td><c:out value="${row.getIdRuta()}"/></td>
                            <td><c:out value="${row.getnRuta()}"/></td>
                            <td><c:out value="${row.getHoraIniRuta()}"/></td>
                            <td><c:out value="${row.getHoraEndRuta()}"/></td>
                            <td><button class="editBtn btnModShowParadas">Ver Paradas</button></td>
                            <td><button class="editBtn btnModActRuta">🖋️</button></td>

                        </tr>
                    </c:forEach>

                </table>
            </div>

            <%-- Ingresar Y Actualizar --%>
            <div class="op_container">
                <button id="btnModIngRuta">Crear Ruta</button>
            </div>


            <div id="ingRutaModal" class="modal">
                <!-- Modal De Creación De Rutas -->
                <div class="modal-content">
                    <span class="close" id="closeIngRutaModal">&times;</span>
                    <div class="modal_form_container">
                        <h1> Registro De Rutas: </h1>
                        <p>Por favor diligencie los siguientes campos</p>

                        <form action="${pageContext.request.contextPath}/rutasServlet" method="post">
                            <input type="hidden" value="insert" name="operation_type" id="operation_type">
                            <input type="hidden" name="ruta_paradas_ids_ins" id="ruta_paradas_ids_ins">

                            <label for="ruta_nom_ins">Nombre De La Ruta</label>
                            <input required type="text" name="ruta_nom_ins" id="ruta_nom_ins">

                            <label for="ruta_ini_ins">Hora de Inicio De La Ruta</label>
                            <input required type="text" name="ruta_ini_ins" id="ruta_ini_ins">

                            <label for="ruta_fin_ins">Hora de Finalización De La Ruta</label>
                            <input required type="text" name="ruta_fin_ins" id="ruta_fin_ins">

                            <div id="rutasParadasIngContainer">
                                <div id="draggCont">

                                </div>
                                <div class="rutasParadasIngCtr">
                                    <select id="paradasSelector">

                                    </select>
                                    <button type="button" id="addParadaToList">Agregar Parada</button>
                                </div>
                            </div>


                            <button type="submit" onsubmit="">Registrar Datos</button>
                        </form>

                    </div>

                </div>

            </div>

            <div id="actParadaModal" class="modal">
                <!-- Modal De Actualización De Rutas -->
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

            <div id="showParadasModal" class="modal">
                <!-- Modal De Actualización De Rutas -->
                <div class="modal-content">
                    <span class="close" id="closeShowParadas">&times;</span>
                    <div class="modal_form_container">
                        <h1 id="paradas_title"> Paradas de la ruta: </h1>
                        <table class="queryTable">
                            <!-- Cabeceras -->
                            <thead>
                                <tr>
                                    <th>Ruta</th>
                                    <th>Paradas</th>
                                </tr>
                            </thead>


                            <!-- Cuerpo -->
                            <tbody id="testBody"></tbody>

                        </table>
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
<script src="js/modalParadas.js"></script>
}<script src="js/modalIngRuta.js"></script>

<script>
    const dragArea = document.getElementById("draggCont");
    new Sortable(dragArea, {
        animation: 350
        }
    )
</script>

</body>
</html>
