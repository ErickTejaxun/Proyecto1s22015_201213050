<%-- 
    Document   : salida
    Created on : 25/06/2013, 09:27:27 PM
    Author     : kaaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="datosPersona" scope="request" class="MisBean.DatosPersona" />
        Nombre:<jsp:getProperty name="datosPersona" property="nombre" /><br>
        Apellido:<jsp:getProperty name="datosPersona" property="apellido" /><br>
        DNI:<jsp:getProperty name="datosPersona" property="dni" />
    </body>
</html>
