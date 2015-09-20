<%-- 
    Document   : index
    Created on : 25/06/2013, 09:23:25 PM
    Author     : kaaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDD2015</title>
    </head>
    <body>
        <h1>Inicio de Sesion</h1>
        <form method="post" action="miServlet">
            Nombre:<br>
            <input type="text" id="txtNombre" name="username"/><br>
            Apellido:<br>
            <input type="password" id="txtApellido" name="password"/><br>
            Tipo:<br>
            <select name="tipo_dato">
                <option>Administrador</option>
                <option>Chofer</option>
                <option>Estacion</option>
            </select>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
