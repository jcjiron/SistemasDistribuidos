<%-- 
    Document   : index.js
    Created on : 22/05/2017, 07:49:31 PM
    Author     : juan
--%>

<%@page import="cliente.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
            <%-- start web service invocation --%><hr/>
    <%
    try {
	cliente.EmpeladoWS_Service service = new cliente.EmpeladoWS_Service();
	cliente.EmpeladoWS port = service.getEmpeladoWSPort();
	 // TODO initialize WS operation arguments here
	Empleado e = new Empleado();
        e.setNombreEmpleado("Betito");
        e.setPaternoEmpleado("Jiron");
        e.setMaternoEmpleado("Perez");
        e.setEmail("mail@mail.com");
        
	port.crearEmpleado(e);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
