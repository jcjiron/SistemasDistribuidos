/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.bean;

import mx.ipn.wsc.Empleado;
/**
 *
 * @author juan
 */
public class EmpleadoBean {

    public static void addEmpleado(mx.ipn.wsc.Empleado empleado) {
        mx.ipn.wsc.WsEmpleado_Service service = new mx.ipn.wsc.WsEmpleado_Service();
        mx.ipn.wsc.WsEmpleado port = service.getWsEmpleadoPort();
        port.addEmpleado(empleado);
    }

    public static void deleteEmpleado(int idEmpleado) {
        mx.ipn.wsc.WsEmpleado_Service service = new mx.ipn.wsc.WsEmpleado_Service();
        mx.ipn.wsc.WsEmpleado port = service.getWsEmpleadoPort();
        port.deleteEmpleado(idEmpleado);
    }

    public static Empleado getEmpleadoById(int idEmpleado) {
        mx.ipn.wsc.WsEmpleado_Service service = new mx.ipn.wsc.WsEmpleado_Service();
        mx.ipn.wsc.WsEmpleado port = service.getWsEmpleadoPort();
        return port.getEmpleadoById(idEmpleado);
    }

    public static java.util.List<mx.ipn.wsc.Empleado> getEmpleados() {
        mx.ipn.wsc.WsEmpleado_Service service = new mx.ipn.wsc.WsEmpleado_Service();
        mx.ipn.wsc.WsEmpleado port = service.getWsEmpleadoPort();
        return port.getEmpleados();
    }

    public static void updateEmpleado(mx.ipn.wsc.Empleado empleado) {
        mx.ipn.wsc.WsEmpleado_Service service = new mx.ipn.wsc.WsEmpleado_Service();
        mx.ipn.wsc.WsEmpleado port = service.getWsEmpleadoPort();
        port.updateEmpleado(empleado);
    }



}
