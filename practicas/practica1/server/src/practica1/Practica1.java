/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import controller.AlumnoJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Alumno;

/**
 *
 * @author juancarlos
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("practica1PU");
        AlumnoJpaController dao = new AlumnoJpaController(emf);
        
   
        
        Alumno alumno = new Alumno();
        alumno.setNombre("juan");
        alumno.setEmail("email1");
        dao.create(alumno);
    }
}
