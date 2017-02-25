package tarea4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juancarlos
 */
public class Hecho {

    private int idHecho;
    private String nombreHecho;

    public int getIdHecho() {
        return idHecho;
    }

    public String getNombreHecho() {
        return nombreHecho;
    }

    public void setIdHecho(int idHecho) {
        this.idHecho = idHecho;
    }

    public void setNombreHecho(String nombreHecho) {
        this.nombreHecho = nombreHecho;
    }

    public Hecho() {
    }

    @Override
    public String toString() {
        return "["+getIdHecho()+","+getNombreHecho()+"]";
    }

    
}
