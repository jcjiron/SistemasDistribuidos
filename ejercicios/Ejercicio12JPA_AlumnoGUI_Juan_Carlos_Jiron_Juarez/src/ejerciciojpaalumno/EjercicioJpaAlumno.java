/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojpaalumno;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author juan
 */
public class EjercicioJpaAlumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjercicioJpaAlumnoPU");
        AlumnoJpaController alumnoJPA = new AlumnoJpaController(emf);
        
        Alumno alumno = new Alumno();
        alumno.setNombreAlumno("juan");
        alumno.setPaternoAlumno("jiron");
        alumno.setMaternoAlumno("juarez");
        alumno.setEmail("email1");
        alumnoJPA.create(alumno);
    }
    
}
