/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.ws.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable{

    public Empleado() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
    private String nombreEmpleado;
    private String paternoEmpleado;
    private String maternoEmpleado;
    private String email;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPaternoEmpleado() {
        return paternoEmpleado;
    }

    public void setPaternoEmpleado(String paternoEmpleado) {
        this.paternoEmpleado = paternoEmpleado;
    }

    public String getMaternoEmpleado() {
        return maternoEmpleado;
    }

    public void setMaternoEmpleado(String maternoEmpleado) {
        this.maternoEmpleado = maternoEmpleado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", paternoEmpleado=" + paternoEmpleado + ", maternoEmpleado=" + maternoEmpleado + ", email=" + email + '}';
    }
    
    
    
}
