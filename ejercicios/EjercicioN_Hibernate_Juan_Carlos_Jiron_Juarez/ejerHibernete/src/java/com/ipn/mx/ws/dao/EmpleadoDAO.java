/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.ws.dao;

import com.ipn.mx.ws.entidades.Empleado;
import com.ipn.mx.ws.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juan
 */
public class EmpleadoDAO {
    public void  create(Empleado e){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            s.save(e);
            tx.commit();
        }catch(Exception ex){
            if(tx.isActive() && tx != null){
                tx.rollback();
            }
        }finally{
            //liberar recursos
            
        }
                
    }
    
    public static void main(String[] args) {
        Empleado e = new Empleado();
        e.setNombreEmpleado("Betito");
        e.setPaternoEmpleado("Lopez");
        e.setMaternoEmpleado("Perez");
        e.setEmail("mail@mail.com");
        System.out.println("Empleado:"+ e);
        EmpleadoDAO edao = new EmpleadoDAO();
        edao.create(e);
        
    }
}
