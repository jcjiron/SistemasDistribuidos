/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author juancarlos
 */
@Embeddable
public class AlumnoHasCursoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "alumno_idalumno")
    private int alumnoIdalumno;
    @Basic(optional = false)
    @Column(name = "curso_idcurso")
    private int cursoIdcurso;

    public AlumnoHasCursoPK() {
    }

    public AlumnoHasCursoPK(int alumnoIdalumno, int cursoIdcurso) {
        this.alumnoIdalumno = alumnoIdalumno;
        this.cursoIdcurso = cursoIdcurso;
    }

    public int getAlumnoIdalumno() {
        return alumnoIdalumno;
    }

    public void setAlumnoIdalumno(int alumnoIdalumno) {
        this.alumnoIdalumno = alumnoIdalumno;
    }

    public int getCursoIdcurso() {
        return cursoIdcurso;
    }

    public void setCursoIdcurso(int cursoIdcurso) {
        this.cursoIdcurso = cursoIdcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alumnoIdalumno;
        hash += (int) cursoIdcurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoHasCursoPK)) {
            return false;
        }
        AlumnoHasCursoPK other = (AlumnoHasCursoPK) object;
        if (this.alumnoIdalumno != other.alumnoIdalumno) {
            return false;
        }
        if (this.cursoIdcurso != other.cursoIdcurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cliente.model.AlumnoHasCursoPK[ alumnoIdalumno=" + alumnoIdalumno + ", cursoIdcurso=" + cursoIdcurso + " ]";
    }
    
}
