<%-- 
    Document   : index.jsp
    Created on : 21/05/2017, 05:49:29 PM
    Author     : juancarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente Java</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
    </head>
    <body>
        <nav class="navbar navbar-toggleable-md navbar-inverse  bg-inverse">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">Juan Carlos Jirón</a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <h1>Hello World!</h1>
        <%-- start web service invocation --%><hr/>
        <form>
            <fieldset class="form-group row">
                <legend class="col-form-legend col-sm-2">conversiones</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="1" checked>
                            Celsius a Farehtheit
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="2">
                            Farehtheit a Celsius
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="3" >
                            Celsius a Kelvin
                        </label>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="4" >
                            Kelvin a Celsius
                        </label>
                    </div>
                </div>
            </fieldset>
            <div class="form-group">
                <label for="exampleInputEmail1">Grados</label>
                <input type="text" class="form-control" id="gradosInput"  name="txtGrados" placeholder="Introduce los grados">
                <input type="hidden" class="form-control" id="gradosOcultos"  name="txtOculto" value='<%=request.getAttribute("TextValue")%>'>
                <button type="submit" class="btn btn-primary" id="idOculto" onclick="funMostrar()">Calcular</button>
            </div>
        </form>
        <%
            try {
                cliente.ConversionGrados_Service service = new cliente.ConversionGrados_Service();
                cliente.ConversionGrados port = service.getConversionGradosPort();
                // TODO initialize WS operation arguments here
                int opc = Integer.parseInt(request.getParameter("gridRadios"));
                String g = request.getParameter("txtGrados");
                double grados = 0;
                double result = 0;
                if (g != null) {
                    grados = Double.parseDouble(g);
                }

                switch (opc) {
                    case 1:
                        result = port.celsiusToFahrenheit(grados);

                        break;
                    case 2:
                        result = port.fahrenheitToCelsius(grados);
                        break;
                    case 3:
                        result = port.celsiusToKelvin(grados);
                        break;
                    case 4:
                        result = port.kelvinToCelsius(grados);
                        break;
                }
                out.write("Conversión: "+result);
                System.out.println("Conversión: "+result);
                request.setAttribute("TextValue","Conversión: "+result);
                //http://localhost:8080/ClienteJava/?gridRadios=3&txtGrados=8&txtOculto=null
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%><hr/>

        <script>
            function funMostrar(){
                //alert(document.getElementById("gradosOcultos").value);
            }
            
        </script>
    </body>

</html>
