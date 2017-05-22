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
import model.Curso;

/**
 *
 * @author juancarlos
 */
public class CursoJpaController implements Serializable {

    public CursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Curso curso) {
        if (curso.getAlumnoHasCursoCollection() == null) {
            curso.setAlumnoHasCursoCollection(new ArrayList<AlumnoHasCurso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<AlumnoHasCurso> attachedAlumnoHasCursoCollection = new ArrayList<AlumnoHasCurso>();
            for (AlumnoHasCurso alumnoHasCursoCollectionAlumnoHasCursoToAttach : curso.getAlumnoHasCursoCollection()) {
                alumnoHasCursoCollectionAlumnoHasCursoToAttach = em.getReference(alumnoHasCursoCollectionAlumnoHasCursoToAttach.getClass(), alumnoHasCursoCollectionAlumnoHasCursoToAttach.getAlumnoHasCursoPK());
                attachedAlumnoHasCursoCollection.add(alumnoHasCursoCollectionAlumnoHasCursoToAttach);
            }
            curso.setAlumnoHasCursoCollection(attachedAlumnoHasCursoCollection);
            em.persist(curso);
            for (AlumnoHasCurso alumnoHasCursoCollectionAlumnoHasCurso : curso.getAlumnoHasCursoCollection()) {
                Curso oldCursoOfAlumnoHasCursoCollectionAlumnoHasCurso = alumnoHasCursoCollectionAlumnoHasCurso.getCurso();
                alumnoHasCursoCollectionAlumnoHasCurso.setCurso(curso);
                alumnoHasCursoCollectionAlumnoHasCurso = em.merge(alumnoHasCursoCollectionAlumnoHasCurso);
                if (oldCursoOfAlumnoHasCursoCollectionAlumnoHasCurso != null) {
                    oldCursoOfAlumnoHasCursoCollectionAlumnoHasCurso.getAlumnoHasCursoCollection().remove(alumnoHasCursoCollectionAlumnoHasCurso);
                    oldCursoOfAlumnoHasCursoCollectionAlumnoHasCurso = em.merge(oldCursoOfAlumnoHasCursoCollectionAlumnoHasCurso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curso curso) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getIdcurso());
            Collection<AlumnoHasCurso> alumnoHasCursoCollectionOld = persistentCurso.getAlumnoHasCursoCollection();
            Collection<AlumnoHasCurso> alumnoHasCursoCollectionNew = curso.getAlumnoHasCursoCollection();
            List<String> illegalOrphanMessages = null;
            for (AlumnoHasCurso alumnoHasCursoCollectionOldAlumnoHasCurso : alumnoHasCursoCollectionOld) {
                if (!alumnoHasCursoCollectionNew.contains(alumnoHasCursoCollectionOldAlumnoHasCurso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AlumnoHasCurso " + alumnoHasCursoCollectionOldAlumnoHasCurso + " since its curso field is not nullable.");
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
            curso.setAlumnoHasCursoCollection(alumnoHasCursoCollectionNew);
            curso = em.merge(curso);
            for (AlumnoHasCurso alumnoHasCursoCollectionNewAlumnoHasCurso : alumnoHasCursoCollectionNew) {
                if (!alumnoHasCursoCollectionOld.contains(alumnoHasCursoCollectionNewAlumnoHasCurso)) {
                    Curso oldCursoOfAlumnoHasCursoCollectionNewAlumnoHasCurso = alumnoHasCursoCollectionNewAlumnoHasCurso.getCurso();
                    alumnoHasCursoCollectionNewAlumnoHasCurso.setCurso(curso);
                    alumnoHasCursoCollectionNewAlumnoHasCurso = em.merge(alumnoHasCursoCollectionNewAlumnoHasCurso);
                    if (oldCursoOfAlumnoHasCursoCollectionNewAlumnoHasCurso != null && !oldCursoOfAlumnoHasCursoCollectionNewAlumnoHasCurso.equals(curso)) {
                        oldCursoOfAlumnoHasCursoCollectionNewAlumnoHasCurso.getAlumnoHasCursoCollection().remove(alumnoHasCursoCollectionNewAlumnoHasCurso);
                        oldCursoOfAlumnoHasCursoCollectionNewAlumnoHasCurso = em.merge(oldCursoOfAlumnoHasCursoCollectionNewAlumnoHasCurso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = curso.getIdcurso();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
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
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getIdcurso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<AlumnoHasCurso> alumnoHasCursoCollectionOrphanCheck = curso.getAlumnoHasCursoCollection();
            for (AlumnoHasCurso alumnoHasCursoCollectionOrphanCheckAlumnoHasCurso : alumnoHasCursoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Curso (" + curso + ") cannot be destroyed since the AlumnoHasCurso " + alumnoHasCursoCollectionOrphanCheckAlumnoHasCurso + " in its alumnoHasCursoCollection field has a non-nullable curso field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
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

    public Curso findCurso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
