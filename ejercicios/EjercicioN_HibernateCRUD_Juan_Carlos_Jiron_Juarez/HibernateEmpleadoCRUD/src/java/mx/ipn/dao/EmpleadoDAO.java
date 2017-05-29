/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.dao;

import java.util.List;
import mx.ipn.model.Empleado;
import mx.ipn.utils.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juan
 */
public class EmpleadoDAO {
    public void addEmpleado(Empleado empleado){
        Transaction tx = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = sesion.beginTransaction();
            sesion.save(empleado);
            sesion.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
                    
        }finally{
            sesion.flush();
            sesion.close();
        }
    }
    
    public void updateEmpleado(Empleado empleado){
        Transaction tx = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = sesion.beginTransaction();
            sesion.update(empleado);
            sesion.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
                    
        }finally{
            sesion.flush();
            sesion.close();
        }
    }
    
    public void deleteEmpleado(int idEmpleado){
        Transaction tx = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = sesion.beginTransaction();
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(idEmpleado);
            sesion.delete(empleado);
            sesion.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
                    
        }finally{
            sesion.flush();
            sesion.close();
        }
    }
    
    public Empleado getEmpleadoById(int idEmpleado){
        Transaction tx = null;
        Empleado empleado = null;
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = sesion.beginTransaction();
            empleado = (Empleado) sesion.get(Empleado.class,idEmpleado );
            sesion.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
                    
        }finally{
            sesion.flush();
            sesion.close();
        }
        return empleado;
    }
    
    public List<Empleado> getEmpleados(){
        List<Empleado> empleados = null;
        Transaction tx = null;
       
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = sesion.beginTransaction();
            empleados =sesion.createCriteria(Empleado.class).list();
            sesion.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
                    
        }finally{
            sesion.flush();
            sesion.close();
        }
        return empleados;
    }
}
