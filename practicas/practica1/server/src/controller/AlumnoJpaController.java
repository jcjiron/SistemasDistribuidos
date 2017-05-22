/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.AlumnoHasCurso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Alumno;

/**
 *
 * @author juancarlos
 */
public class AlumnoJpaController implements Serializable {

    public AlumnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alumno alumno) {
        if (alumno.getAlumnoHasCursoCollection() == null) {
            alumno.setAlumnoHasCursoCollection(new ArrayList<AlumnoHasCurso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<AlumnoHasCurso> attachedAlumnoHasCursoCollection = new ArrayList<AlumnoHasCurso>();
            for (AlumnoHasCurso alumnoHasCursoCollectionAlumnoHasCursoToAttach : alumno.getAlumnoHasCursoCollection()) {
                alumnoHasCursoCollectionAlumnoHasCursoToAttach = em.getReference(alumnoHasCursoCollectionAlumnoHasCursoToAttach.getClass(), alumnoHasCursoCollectionAlumnoHasCursoToAttach.getAlumnoHasCursoPK());
                attachedAlumnoHasCursoCollection.add(alumnoHasCursoCollectionAlumnoHasCursoToAttach);
            }
            alumno.setAlumnoHasCursoCollection(attachedAlumnoHasCursoCollection);
            em.persist(alumno);
            for (AlumnoHasCurso alumnoHasCursoCollectionAlumnoHasCurso : alumno.getAlumnoHasCursoCollection()) {
                Alumno oldAlumnoOfAlumnoHasCursoCollectionAlumnoHasCurso = alumnoHasCursoCollectionAlumnoHasCurso.getAlumno();
                alumnoHasCursoCollectionAlumnoHasCurso.setAlumno(alumno);
                alumnoHasCursoCollectionAlumnoHasCurso = em.merge(alumnoHasCursoCollectionAlumnoHasCurso);
                if (oldAlumnoOfAlumnoHasCursoCollectionAlumnoHasCurso != null) {
                    oldAlumnoOfAlumnoHasCursoCollectionAlumnoHasCurso.getAlumnoHasCursoCollection().remove(alumnoHasCursoCollectionAlumnoHasCurso);
                    oldAlumnoOfAlumnoHasCursoCollectionAlumnoHasCurso = em.merge(oldAlumnoOfAlumnoHasCursoCollectionAlumnoHasCurso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumno alumno) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno persistentAlumno = em.find(Alumno.class, alumno.getIdalumno());
            Collection<AlumnoHasCurso> alumnoHasCursoCollectionOld = persistentAlumno.getAlumnoHasCursoCollection();
            Collection<AlumnoHasCurso> alumnoHasCursoCollectionNew = alumno.getAlumnoHasCursoCollection();
            List<String> illegalOrphanMessages = null;
            for (AlumnoHasCurso alumnoHasCursoCollectionOldAlumnoHasCurso : alumnoHasCursoCollectionOld) {
                if (!alumnoHasCursoCollectionNew.contains(alumnoHasCursoCollectionOldAlumnoHasCurso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AlumnoHasCurso " + alumnoHasCursoCollectionOldAlumnoHasCurso + " since its alumno field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<AlumnoHasCurso> attachedAlumnoHasCursoCollectionNew = new ArrayList<AlumnoHasCurso>();
            for (AlumnoHasCurso alumnoHasCursoCollectionNewAlumnoHasCursoToAttach : alumnoHasCursoCollectionNew) {
                alumnoHasCursoCollectionNewAlumnoHasCursoToAttach = em.getReference(alumnoHasCursoCollectionNewAlumnoHasCursoToAttach.getClass(), alumnoHasCursoCollectionNewAlumnoHasCursoToAttach.getAlumnoHasCursoPK());
                attachedAlumnoHasCursoCollectionNew.add(alumnoHasCursoCollectionNewAlumnoHasCursoToAttach);
            }
            alumnoHasCursoCollectionNew = attachedAlumnoHasCursoCollectionNew;
            alumno.setAlumnoHasCursoCollection(alumnoHasCursoCollectionNew);
            alumno = em.merge(alumno);
            for (AlumnoHasCurso alumnoHasCursoCollectionNewAlumnoHasCurso : alumnoHasCursoCollectionNew) {
                if (!alumnoHasCursoCollectionOld.contains(alumnoHasCursoCollectionNewAlumnoHasCurso)) {
                    Alumno oldAlumnoOfAlumnoHasCursoCollectionNewAlumnoHasCurso = alumnoHasCursoCollectionNewAlumnoHasCurso.getAlumno();
                    alumnoHasCursoCollectionNewAlumnoHasCurso.setAlumno(alumno);
                    alumnoHasCursoCollectionNewAlumnoHasCurso = em.merge(alumnoHasCursoCollectionNewAlumnoHasCurso);
                    if (oldAlumnoOfAlumnoHasCursoCollectionNewAlumnoHasCurso != null && !oldAlumnoOfAlumnoHasCursoCollectionNewAlumnoHasCurso.equals(alumno)) {
                        oldAlumnoOfAlumnoHasCursoCollectionNewAlumnoHasCurso.getAlumnoHasCursoCollection().remove(alumnoHasCursoCollectionNewAlumnoHasCurso);
                        oldAlumnoOfAlumnoHasCursoCollectionNewAlumnoHasCurso = em.merge(oldAlumnoOfAlumnoHasCursoCollectionNewAlumnoHasCurso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alumno.getIdalumno();
                if (findAlumno(id) == null) {
                    throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno alumno;
            try {
                alumno = em.getReference(Alumno.class, id);
                alumno.getIdalumno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<AlumnoHasCurso> alumnoHasCursoCollectionOrphanCheck = alumno.getAlumnoHasCursoCollection();
            for (AlumnoHasCurso alumnoHasCursoCollectionOrphanCheckAlumnoHasCurso : alumnoHasCursoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Alumno (" + alumno + ") cannot be destroyed since the AlumnoHasCurso " + alumnoHasCursoCollectionOrphanCheckAlumnoHasCurso + " in its alumnoHasCursoCollection field has a non-nullable alumno field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(alumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumno> findAlumnoEntities() {
        return findAlumnoEntities(true, -1, -1);
    }

    public List<Alumno> findAlumnoEntities(int maxResults, int firstResult) {
        return findAlumnoEntities(false, maxResults, firstResult);
    }

    private List<Alumno> findAlumnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumno.class));
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

    public Alumno findAlumno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumno> rt = cq.from(Alumno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
