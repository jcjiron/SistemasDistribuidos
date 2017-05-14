/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Alumno;
import model.AlumnoHasCurso;
import model.AlumnoHasCursoPK;
import model.Curso;

/**
 *
 * @author juancarlos
 */
public class AlumnoHasCursoJpaController implements Serializable {

    public AlumnoHasCursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AlumnoHasCurso alumnoHasCurso) throws PreexistingEntityException, Exception {
        if (alumnoHasCurso.getAlumnoHasCursoPK() == null) {
            alumnoHasCurso.setAlumnoHasCursoPK(new AlumnoHasCursoPK());
        }
        alumnoHasCurso.getAlumnoHasCursoPK().setCursoIdcurso(alumnoHasCurso.getCurso().getIdcurso());
        alumnoHasCurso.getAlumnoHasCursoPK().setAlumnoIdalumno(alumnoHasCurso.getAlumno().getIdalumno());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno alumno = alumnoHasCurso.getAlumno();
            if (alumno != null) {
                alumno = em.getReference(alumno.getClass(), alumno.getIdalumno());
                alumnoHasCurso.setAlumno(alumno);
            }
            Curso curso = alumnoHasCurso.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getIdcurso());
                alumnoHasCurso.setCurso(curso);
            }
            em.persist(alumnoHasCurso);
            if (alumno != null) {
                alumno.getAlumnoHasCursoCollection().add(alumnoHasCurso);
                alumno = em.merge(alumno);
            }
            if (curso != null) {
                curso.getAlumnoHasCursoCollection().add(alumnoHasCurso);
                curso = em.merge(curso);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlumnoHasCurso(alumnoHasCurso.getAlumnoHasCursoPK()) != null) {
                throw new PreexistingEntityException("AlumnoHasCurso " + alumnoHasCurso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AlumnoHasCurso alumnoHasCurso) throws NonexistentEntityException, Exception {
        alumnoHasCurso.getAlumnoHasCursoPK().setCursoIdcurso(alumnoHasCurso.getCurso().getIdcurso());
        alumnoHasCurso.getAlumnoHasCursoPK().setAlumnoIdalumno(alumnoHasCurso.getAlumno().getIdalumno());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AlumnoHasCurso persistentAlumnoHasCurso = em.find(AlumnoHasCurso.class, alumnoHasCurso.getAlumnoHasCursoPK());
            Alumno alumnoOld = persistentAlumnoHasCurso.getAlumno();
            Alumno alumnoNew = alumnoHasCurso.getAlumno();
            Curso cursoOld = persistentAlumnoHasCurso.getCurso();
            Curso cursoNew = alumnoHasCurso.getCurso();
            if (alumnoNew != null) {
                alumnoNew = em.getReference(alumnoNew.getClass(), alumnoNew.getIdalumno());
                alumnoHasCurso.setAlumno(alumnoNew);
            }
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getIdcurso());
                alumnoHasCurso.setCurso(cursoNew);
            }
            alumnoHasCurso = em.merge(alumnoHasCurso);
            if (alumnoOld != null && !alumnoOld.equals(alumnoNew)) {
                alumnoOld.getAlumnoHasCursoCollection().remove(alumnoHasCurso);
                alumnoOld = em.merge(alumnoOld);
            }
            if (alumnoNew != null && !alumnoNew.equals(alumnoOld)) {
                alumnoNew.getAlumnoHasCursoCollection().add(alumnoHasCurso);
                alumnoNew = em.merge(alumnoNew);
            }
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getAlumnoHasCursoCollection().remove(alumnoHasCurso);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getAlumnoHasCursoCollection().add(alumnoHasCurso);
                cursoNew = em.merge(cursoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                AlumnoHasCursoPK id = alumnoHasCurso.getAlumnoHasCursoPK();
                if (findAlumnoHasCurso(id) == null) {
                    throw new NonexistentEntityException("The alumnoHasCurso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(AlumnoHasCursoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AlumnoHasCurso alumnoHasCurso;
            try {
                alumnoHasCurso = em.getReference(AlumnoHasCurso.class, id);
                alumnoHasCurso.getAlumnoHasCursoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumnoHasCurso with id " + id + " no longer exists.", enfe);
            }
            Alumno alumno = alumnoHasCurso.getAlumno();
            if (alumno != null) {
                alumno.getAlumnoHasCursoCollection().remove(alumnoHasCurso);
                alumno = em.merge(alumno);
            }
            Curso curso = alumnoHasCurso.getCurso();
            if (curso != null) {
                curso.getAlumnoHasCursoCollection().remove(alumnoHasCurso);
                curso = em.merge(curso);
            }
            em.remove(alumnoHasCurso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AlumnoHasCurso> findAlumnoHasCursoEntities() {
        return findAlumnoHasCursoEntities(true, -1, -1);
    }

    public List<AlumnoHasCurso> findAlumnoHasCursoEntities(int maxResults, int firstResult) {
        return findAlumnoHasCursoEntities(false, maxResults, firstResult);
    }

    private List<AlumnoHasCurso> findAlumnoHasCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AlumnoHasCurso.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AlumnoHasCurso findAlumnoHasCurso(AlumnoHasCursoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AlumnoHasCurso.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoHasCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AlumnoHasCurso> rt = cq.from(AlumnoHasCurso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
