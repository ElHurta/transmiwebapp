<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TransmiApp</title>
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="icon" href="assets/img/transmiLogo.svg">
</head>

<body>
    <section class="hero_section">
        <div class="hero_content">
            <h1 class="hero_title">TransmiApp</h1>
            <p>Tu App de Gestión de Movilidad</p>
        </div>

        <div class="login_card">
            <form method="POST" action="${pageContext.request.contextPath}/loginServlet">
                <label for="username_login">Nombre De Usuario</label>
                <input name="username_login" id="username_login" type="text">

                <label for="password_login">Contraseña</label>
                <input name="password_login" id="password_login" type="password">

                <button type="submit">Ingresar</button>
            </form>
        </div>
    </section>
</body>
</html>