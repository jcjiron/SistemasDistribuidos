/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juancarlos
 */
@Entity
@Table(name = "alumno_has_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoHasCurso.findAll", query = "SELECT a FROM AlumnoHasCurso a"),
    @NamedQuery(name = "AlumnoHasCurso.findByAlumnoIdalumno", query = "SELECT a FROM AlumnoHasCurso a WHERE a.alumnoHasCursoPK.alumnoIdalumno = :alumnoIdalumno"),
    @NamedQuery(name = "AlumnoHasCurso.findByCursoIdcurso", query = "SELECT a FROM AlumnoHasCurso a WHERE a.alumnoHasCursoPK.cursoIdcurso = :cursoIdcurso"),
    @NamedQuery(name = "AlumnoHasCurso.findByHorario", query = "SELECT a FROM AlumnoHasCurso a WHERE a.horario = :horario"),
    @NamedQuery(name = "AlumnoHasCurso.findByTipoCurso", query = "SELECT a FROM AlumnoHasCurso a WHERE a.tipoCurso = :tipoCurso")})
public class AlumnoHasCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnoHasCursoPK alumnoHasCursoPK;
    @Column(name = "horario")
    private String horario;
    @Column(name = "tipoCurso")
    private String tipoCurso;
    @JoinColumn(name = "alumno_idalumno", referencedColumnName = "idalumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "curso_idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public AlumnoHasCurso() {
    }

    public AlumnoHasCurso(AlumnoHasCursoPK alumnoHasCursoPK) {
        this.alumnoHasCursoPK = alumnoHasCursoPK;
    }

    public AlumnoHasCurso(int alumnoIdalumno, int cursoIdcurso) {
        this.alumnoHasCursoPK = new AlumnoHasCursoPK(alumnoIdalumno, cursoIdcurso);
    }

    public AlumnoHasCursoPK getAlumnoHasCursoPK() {
        return alumnoHasCursoPK;
    }

    public void setAlumnoHasCursoPK(AlumnoHasCursoPK alumnoHasCursoPK) {
        this.alumnoHasCursoPK = alumnoHasCursoPK;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoHasCursoPK != null ? alumnoHasCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoHasCurso)) {
            return false;
        }
        AlumnoHasCurso other = (AlumnoHasCurso) object;
        if ((this.alumnoHasCursoPK == null && other.alumnoHasCursoPK != null) || (this.alumnoHasCursoPK != null && !this.alumnoHasCursoPK.equals(other.alumnoHasCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AlumnoHasCurso[ alumnoHasCursoPK=" + alumnoHasCursoPK + " ]";
    }
    
}
