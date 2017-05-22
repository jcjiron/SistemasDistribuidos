/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author juancarlos
 */

public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idcurso;
    private String nombre;
    private Date fechaInicio;
    private Date fechaTermino;
    private BigDecimal cuotaDeRecuperacion;


    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public BigDecimal getCuotaDeRecuperacion() {
        return cuotaDeRecuperacion;
    }

    public void setCuotaDeRecuperacion(BigDecimal cuotaDeRecuperacion) {
        this.cuotaDeRecuperacion = cuotaDeRecuperacion;
    }

    public Curso() {
    }

    public Curso(Integer idcurso) {
        this.idcurso = idcurso;
    }
}