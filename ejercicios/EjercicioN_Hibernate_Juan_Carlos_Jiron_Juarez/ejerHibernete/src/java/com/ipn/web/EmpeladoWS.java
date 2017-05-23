/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.web;

import com.ipn.mx.ws.dao.EmpleadoDAO;
import com.ipn.mx.ws.entidades.Empleado;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author juan
 */
@WebService(serviceName = "EmpeladoWS")
public class EmpeladoWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearEmpleado")
    public void crearEmpleado(@WebParam(name = "empleado") Empleado empleado) {
        EmpleadoDAO d = new EmpleadoDAO();
        d.create(empleado);
        
    }
}
