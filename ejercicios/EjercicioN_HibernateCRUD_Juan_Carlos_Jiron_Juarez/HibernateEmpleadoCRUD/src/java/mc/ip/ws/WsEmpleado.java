/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mc.ip.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import mx.ipn.dao.EmpleadoDAO;
import mx.ipn.model.Empleado;

/**
 *
 * @author juan
 */
@WebService(serviceName = "WsEmpleado")
public class WsEmpleado {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "addEmpleado")
    public void addEmpleado(@WebParam(name = "empleado") Empleado empleado) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.addEmpleado(empleado);
    }
    
     @WebMethod(operationName = "deleteEmpleado")
    public void deleteEmpleado(@WebParam(name = "IdEmpleado") int idEmpleado) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.deleteEmpleado(idEmpleado);
    }
    

    @WebMethod(operationName = "updateEmpleado")
    public void updateEmpleado(@WebParam(name = "empleado") Empleado empleado) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
         empleadoDAO.updateEmpleado(empleado);
    }
    
     @WebMethod(operationName = "getEmpleadoById")
    public Empleado getEmpleadoById(@WebParam(name = "idEmpleado") int IdEmpleado) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
         return empleadoDAO.getEmpleadoById(IdEmpleado);
    }
     
     @WebMethod(operationName = "getEmpleados")
     public List<Empleado> getEmpleados(){
         EmpleadoDAO empleadoDAO = new EmpleadoDAO();
         List<Empleado> list = empleadoDAO.getEmpleados();
         return list;
     }
}
