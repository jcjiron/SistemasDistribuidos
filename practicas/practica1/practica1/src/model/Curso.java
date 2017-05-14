/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juancarlos
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdcurso", query = "SELECT c FROM Curso c WHERE c.idcurso = :idcurso"),
    @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Curso.findByFechaInicio", query = "SELECT c FROM Curso c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Curso.findByFechaTermino", query = "SELECT c FROM Curso c WHERE c.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Curso.findByCuotaDeRecuperacion", query = "SELECT c FROM Curso c WHERE c.cuotaDeRecuperacion = :cuotaDeRecuperacion")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcurso")
    private Integer idcurso;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fechaTermino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cuotaDeRecuperacion")
    private BigDecimal cuotaDeRecuperacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<AlumnoHasCurso> alumnoHasCursoCollection;

    public Curso() {
    }

    public Curso(Integer idcurso) {
        this.idcurso = idcurso;
    }

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

    @XmlTransient
    public Collection<AlumnoHasCurso> getAlumnoHasCursoCollection() {
        return alumnoHasCursoCollection;
    }

    public void setAlumnoHasCursoCollection(Collection<AlumnoHasCurso> alumnoHasCursoCollection) {
        this.alumnoHasCursoCollection = alumnoHasCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurso != null ? idcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idcurso == null && other.idcurso != null) || (this.idcurso != null && !this.idcurso.equals(other.idcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Curso[ idcurso=" + idcurso + " ]";
    }
    
}
